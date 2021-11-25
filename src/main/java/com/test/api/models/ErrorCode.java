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
package com.test.api.models;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorCode {
  ERR_DATASET_NOT_FOUND,
  ERR_TABLE_NOT_FOUND,
  ERR_JOB_NOT_FOUND,
  ERR_INVALID_JOB_STACK,
  ERR_WORKSPACE_NOT_FOUND,
  ERR_OWNER_NOT_FOUND,
  ERR_RUN_NOT_FOUND,
  ERR_SCHEMA_NOT_FOUND,
  ERR_TAG_NOT_FOUND,
  ERR_SNIPPET_NOT_FOUND,
  ERR_STORE_NOT_FOUND,
  ERR_SERVICE_NOT_FOUND,
  ERR_DATASET_ADDRESS_NOT_FOUND,
  ERR_DATASET_MEASURE_NOT_FOUND,
  ERR_DEPOT_NOT_FOUND,
  ERR_DASHBOARD_NOT_FOUND,
  ERR_CHART_NOT_FOUND,
  ERR_RULE_NOT_FOUND,
  ERR_INVALID_RULE,
  ERR_FIELD_NOT_FOUND,
  ERR_VERSION_NOT_FOUND,
  ERR_FUNCTION_NOT_FOUND,
  ERR_TOPIC_NOT_FOUND,
  ERR_TOPOLOGY_NOT_FOUND,
  ERR_VIEW_DEFINITION_NOT_FOUND,
  ERR_HIVE_TABLE_NOT_FOUND,
  ERR_WORKFLOW_RUN_NOT_FOUND,
  ERR_INVALID_RESOURCE_IDENTIFIER,
  ERR_WORKFLOW_NOT_FOUND,
  ERR_ENTITY_NOT_FOUND,
  ERR_NOTE_NOT_FOUND,
  ERR_WARNING_NOT_FOUND,
  ERR_TAG_RELATION_NOT_FOUND,
  ERR_TAG_RELATION_MAPPING_NOT_FOUND,
  ERR_FINGERPRINT_NOT_FOUND,
  ERR_CATALOG_NOT_FOUND,
  ERR_SUBJECT_NOT_FOUND,
  ERR_SUBJECT_VERSION_NOT_FOUND,
  ERR_INVALID_ENTITY_TYPE,
  ERR_HIVE_TABLE_EXISTS,
  ERR_TAG_RELATION_MAPPING_EXISTS,
  ERR_DATASET_MEASURE_EXISTS,
  ERR_INVALID_NAME,
  ERR_INVALID_SORT_ATTRIBUTE,
  ERR_INVALID_SOURCE_VIEW,
  ERR_INVALID_TOPOLOGY,
  ERR_INVALID_UUID,
  ERR_KEYWORD_NOT_ALLOWED,
  ERR_TAG_NOT_ENABLED,
  ERR_TAG_RELATION_ARCHIVED,
  ERR_RESOURCE_NOT_FOUND,
  ERR_TAG_ARCHIVED,
  ERR_BAD_REQUEST,
  ERR_UNAUTHORIZED,
}
