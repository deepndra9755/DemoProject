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
package com.test.api.common.models.base;

import lombok.NonNull;

import javax.annotation.Nullable;

import static com.google.common.base.Strings.lenientFormat;

public final class MorePreconditions {
  private MorePreconditions() {}

  public static String checkNotBlank(@NonNull final String arg) {
    if (emptyOrBlank(arg)) {
      throw new IllegalArgumentException();
    }
    return arg;
  }

  public static String checkNotBlank(
      @NonNull final String arg,
      @Nullable final String errorMessage,
      @Nullable final Object... errorMessageArgs) {
    if (emptyOrBlank(arg)) {
      throw new IllegalArgumentException(lenientFormat(errorMessage, errorMessageArgs));
    }
    return arg;
  }

  public static String checkValidUrl(
      @NonNull final String arg,
      @Nullable final String errorMessage,
      @Nullable final Object... errorMessageArgs) {
    if (emptyOrBlank(arg)) {
      throw new IllegalArgumentException(lenientFormat(errorMessage, errorMessageArgs));
    }
    return arg;
  }

  private static Boolean emptyOrBlank(final String arg) {
    return arg.trim().isEmpty();
  }
}
