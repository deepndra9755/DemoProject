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
package com.test.api.common.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Nullable;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorMessage {
  private final int code;
  private final String errorCode;
  private final String message;

  @JsonCreator
  public ErrorMessage(
      @JsonProperty("code") int code,
      @JsonProperty("errorCode") String errorCode,
      @JsonProperty("message") String message) {
    this.code = code;
    this.errorCode = errorCode;
    this.message = message;
  }

  @JsonProperty("code")
  public Integer getCode() {
    return this.code;
  }

  @JsonProperty("errorCode")
  @Nullable
  public String getErrorCode() {
    return this.errorCode;
  }

  @JsonProperty("message")
  public String getMessage() {
    return this.message;
  }

  public String toString() {
    return "ErrorMessage{code="
        + this.code
        + ", message='"
        + this.message
        + "', errorCode='"
        + this.errorCode
        + "'}";
  }
}
