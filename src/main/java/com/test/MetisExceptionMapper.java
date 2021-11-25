/*************************************************************************
 *
 * Rubik Inc. CONFIDENTIAL
 * __________________
 *
 *  © 2020-2021 All Rights Reserved.
 *
 * NOTICE:  All information contained herein is, and remains the property
 * of Rubik Inc. The intellectual and technical concepts contained
 * herein are proprietary to Rubik Incorporated may be covered by U.S.
 * and Foreign Patents, patents in process, and are protected by trade
 * secret or copyright law.
 *
 * Dissemination of this information or reproduction of this material
 * is strictly forbidden unless prior written permission is obtained
 * from Rubik Inc.
 */
package com.test;

import com.test.api.common.models.ErrorCode;
import com.test.api.common.models.ErrorMessage;
import io.dropwizard.jersey.errors.LoggingExceptionMapper;
import lombok.NonNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import java.util.concurrent.ThreadLocalRandom;

@Provider
public class MetisExceptionMapper implements ExceptionMapper<Exception> {
  private final Logger logger;

  private MetisExceptionMapper(@NonNull Logger logger) {
    this.logger = logger;
  }

  MetisExceptionMapper() {
    this(LoggerFactory.getLogger(LoggingExceptionMapper.class));
  }

  @Override
  public Response toResponse(Exception exception) {
    logger.error("Request failed with error.", exception);

    // If we're dealing with a web exception, we can service certain types of request (like
    // redirection or server errors) better and also propagate properties of the inner response.
    if (exception instanceof MetisException) {
      final MetisException metisException = (MetisException) exception;
      logException(exception);
      return handleMetisException(metisException);
    }
    return handleInternalServerException(exception);
  }

  private Response handleMetisException(MetisException exception) {
    return Response.status(exception.getStatus())
        .entity(
            new ErrorMessage(
                exception.getStatus().getStatusCode(),
                exception.getErrorCode().name(),
                exception.getMessage()))
        .build();
  }

  private Response handleInternalServerException(Exception exception) {
    final long id = logException(exception);
    if (exception instanceof IllegalArgumentException) {
      return Response.status(Response.Status.BAD_REQUEST)
          .entity(
              new ErrorMessage(
                  Response.Status.BAD_REQUEST.getStatusCode(),
                  ErrorCode.ERR_BAD_REQUEST.name(),
                  exception.getMessage()))
          .build();
    } else if (exception instanceof NotFoundException) {
      return Response.status(Response.Status.NOT_FOUND)
          .entity(
              new ErrorMessage(
                  Response.Status.NOT_FOUND.getStatusCode(),
                  ErrorCode.ERR_ENTITY_NOT_FOUND.name(),
                  exception.getMessage()))
          .build();
    }

    return Response.status(Response.Status.INTERNAL_SERVER_ERROR.getStatusCode())
        .type(MediaType.APPLICATION_JSON_TYPE)
        .entity(
            new ErrorMessage(
                Response.Status.INTERNAL_SERVER_ERROR.getStatusCode(),
                Response.Status.INTERNAL_SERVER_ERROR.name(),
                formatErrorMessage(id, exception)))
        .build();
  }

  private String formatErrorMessage(long id, Exception exception) {
    // TODO: update this message to a generic message for resource exceptions
    return exception.getMessage();
  }

  private long logException(Exception exception) {
    // todo: can we use request correlation id here?
    final long id = ThreadLocalRandom.current().nextLong();
    logException(id, exception);
    return id;
  }

  private void logException(long id, Exception exception) {
    logger.error(formatLogMessage(id, exception), exception);
  }

  private String formatLogMessage(long id, Throwable exception) {
    return String.format("Error handling a request: %016x", id);
  }
}
