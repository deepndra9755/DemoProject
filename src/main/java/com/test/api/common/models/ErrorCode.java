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

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  ERR_USER_NOT_FOUND,
  ERR_FORM_VALIDATION_EXCEPTION,
  ERR_ALL_FIELD_MANDATORY,
  ERR_USER_NAME_MUST_NOT_EMPTY,
  ERR_USER_LAST_NAME_MUST_NOT_EMPTY,
  ERR_NUMBER_NOT_VALID,
  ERR_RESOURCE_NOT_FOUND,
  ERR_ENTITY_NOT_FOUND,
  ERR_TAG_ARCHIVED,
  ERR_BAD_REQUEST,
  ERR_UNAUTHORIZED,
  ERR_USER_NOT_INSERTED

}
