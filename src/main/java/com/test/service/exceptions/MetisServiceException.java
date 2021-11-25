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
package com.test.service.exceptions;

import com.test.MetisException;
import lombok.NoArgsConstructor;

import javax.annotation.Nullable;

@NoArgsConstructor
public class MetisServiceException extends MetisException {
  private static final long serialVersionUID = 1L;

  public MetisServiceException(@Nullable final String message) {
    super(message);
  }

  public MetisServiceException(@Nullable final Throwable cause) {
    super(cause);
  }

  public MetisServiceException(@Nullable final String message, @Nullable final Throwable cause) {
    super(message, cause);
  }
}
