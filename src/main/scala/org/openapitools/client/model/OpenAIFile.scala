/**
 * OpenAI API
 * APIs for sampling from and fine-tuning language models
 *
 * The version of the OpenAPI document: 1.2.0
 * 
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package org.openapitools.client.model


case class OpenAIFile(
  id: String,
  `object`: String,
  bytes: Int,
  createdAt: Int,
  filename: String,
  purpose: String,
  status: Option[String] = None,
  statusDetails: Option[Any] = None
)

