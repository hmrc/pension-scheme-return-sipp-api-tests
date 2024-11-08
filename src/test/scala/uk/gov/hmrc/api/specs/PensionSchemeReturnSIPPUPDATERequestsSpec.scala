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

package uk.gov.hmrc.api.specs

import uk.gov.hmrc.api.service.PensionSchemeReturnSippDELETERequestService

class PensionSchemeReturnSIPPUPDATERequestsSpec extends BaseSpec {

  val pensionSchemeReturnSippDELETEServiceAPI: PensionSchemeReturnSippDELETERequestService =
    new PensionSchemeReturnSippDELETERequestService
  val authBearerToken: String                                                              = authHelper.getAuthBearerToken
  val payload: String                                                                      =
    """
      |{
      |  "current": {
      |    "firstName": "John",
      |    "lastName": "Doe",
      |    "dateOfBirth": "1980-01-01",
      |    "nino": "AB123456C"
      |  },
      |  "updated": {
      |    "firstName": "Johna",
      |    "lastName": "Doe",
      |    "dateOfBirth": "1980-01-01",
      |    "nino": "AB123456C"
      |  }
      |}
      |""".stripMargin

  Feature("Update Request for member details for assets class") {

    Scenario("Verify 200 response when Delete request to Update record") {
      Then("200 response is expected when updating details of asset class")
      DELETERequestsHelper.deleteFullBodyRequestEndpoint(authBearerToken, payload, "member-details")
    }

    Scenario("401 Unauthorized error when DELETE request to Update details without token") {
      Then("401 response is expected when updating details of asset class")
      DELETERequestsHelper.deleteUnauthorizedRequestEndpoint("", payload, "member-details")
    }

    Scenario("400 Server error when DELETE request to Update without payload") {
      Then("400 response is expected when updating details of asset class")
      DELETERequestsHelper.deleteNoBodyRequestEndpoint(authBearerToken, "", "member-details")
    }
  }
}
