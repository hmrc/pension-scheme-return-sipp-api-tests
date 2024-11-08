/*
 * Copyright 2024 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package uk.gov.hmrc.api.helpers

import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import play.api.libs.ws.StandaloneWSRequest
import uk.gov.hmrc.api.service.PensionSchemeReturnSippDELETERequestService

class DELETERequestsHelper {

  val pensionSchemeReturnDELETEServiceAPI: PensionSchemeReturnSippDELETERequestService =
    new PensionSchemeReturnSippDELETERequestService

  def deleteFullBodyRequestEndpoint(authBearerToken: String, payload: String, action: String): Unit = {
    val versionsGetResponse: StandaloneWSRequest#Self#Response =
      pensionSchemeReturnDELETEServiceAPI.deleteStandardPSR(authBearerToken, payload, action)
    assert(Set(200, 201).contains(versionsGetResponse.status))
  }: Unit

  def deleteUnauthorizedRequestEndpoint(authBearerToken: String, payload: String, action: String): Unit = {
    val versionsGetResponse: StandaloneWSRequest#Self#Response =
      pensionSchemeReturnDELETEServiceAPI.deleteStandardPSR(authBearerToken, payload, action)
    versionsGetResponse.status shouldBe 401
  }: Unit

  def deleteNotFoundRequestEndpoint(authBearerToken: String, payload: String, action: String): Unit = {
    val versionsGetResponse: StandaloneWSRequest#Self#Response =
      pensionSchemeReturnDELETEServiceAPI.deleteStandardPSR(authBearerToken, payload, action)
    versionsGetResponse.status shouldBe 404
  }: Unit

  def deleteNoBodyRequestEndpoint(authBearerToken: String, payload: String, action: String): Unit = {
    val versionsGetResponse: StandaloneWSRequest#Self#Response =
      pensionSchemeReturnDELETEServiceAPI.deleteStandardPSR(authBearerToken, payload, action)
    versionsGetResponse.status shouldBe 400
  }: Unit

}
