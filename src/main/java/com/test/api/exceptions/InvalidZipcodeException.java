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
package com.test.api.exceptions;

import com.test.MetisException;
import com.test.api.common.models.ErrorCode;

import javax.ws.rs.core.Response;

public final class InvalidZipcodeException extends MetisException {
  private static final long serialVersionUID = 1L;

  public InvalidZipcodeException(final String newFormat) {
    super(
        ErrorCode.ERR_NUMBER_NOT_VALID,
        Response.Status.NOT_ACCEPTABLE,
        "this Zipcode Number Not Currect '%s' can't proceed further with It"
        );
  }
}
