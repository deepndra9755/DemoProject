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
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;

@NoArgsConstructor
/** todo: get rid of this and use {@link io.dataos.metis.commons.exceptions.MetisException} */
public class MetisException extends WebApplicationException {
  private static final long serialVersionUID = 1L;
  @Getter private ErrorCode errorCode;
  @Getter private Response.Status status;

  public MetisException(ErrorCode errorCode, Response.Status status, String message) {
    super(message);
    this.errorCode = errorCode;
    this.status = status;
  }

  public MetisException(@Nullable final String message) {
    super(message);
  }

  public MetisException(@Nullable final Throwable cause) {
    super(cause);
  }

  public MetisException(@Nullable final String message, @Nullable final Throwable cause) {
    super(message, cause);
  }
}
