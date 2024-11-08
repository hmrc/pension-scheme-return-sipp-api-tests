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

import uk.gov.hmrc.api.service.PensionSchemeReturnSippPUTRequestService

class PensionSchemeReturnSIPPTangiblePUTRequestsSpec extends BaseSpec {

  val pensionSchemeReturnSippPUTServiceAPI: PensionSchemeReturnSippPUTRequestService =
    new PensionSchemeReturnSippPUTRequestService
  val authBearerToken: String                                                        = authHelper.getAuthBearerToken
  val payload: String                                                                =
    """
      {
      |  "reportDetails": {
      |    "pstr": "24000020IN",
      |    "version": "001",
      |    "status": "Compiled",
      |    "periodEnd": "2023-04-05",
      |    "periodStart": "2022-04-06",
      |    "schemeName": "Open Scheme 2"
      |  },
      |  "transactions": [
      |    {
      |      "totalCost": 3692.51,
      |      "isPropertyDisposed": "Yes",
      |      "nameDOB": {
      |        "firstName": "Udale",
      |        "lastName": "Basley",
      |        "dob": "1988-05-04"
      |      },
      |      "independentValuation": "No",
      |      "acquisitionDate": "1999-06-03",
      |      "row": 3,
      |      "costMarketValue": 5385.82,
      |      "acquiredFromName": "Udale Basley",
      |      "costOrMarket": "Cost Value",
      |      "totalIncomeOrReceipts": 7750.94,
      |      "nino": {
      |        "nino": "SH735042A"
      |      },
      |      "assetDescription": "Automated neutral open architecture",
      |      "disposalDetails": {
      |        "disposedPropertyProceedsAmt": 495.99,
      |        "purchasersNames": "Udale Basley",
      |        "propertyFullyDisposed": "Yes",
      |        "independentValuationDisposal": "Yes",
      |        "anyPurchaserConnectedParty": "Yes"
      |      }
      |    },
      |    {
      |      "totalCost": 3454.78,
      |      "isPropertyDisposed": "No",
      |      "nameDOB": {
      |        "firstName": "Celie",
      |        "lastName": "Cornwell",
      |        "dob": "1968-03-07"
      |      },
      |      "independentValuation": "No",
      |      "assetDescription": "User-friendly bi-directional system engine",
      |      "acquisitionDate": "1995-08-01",
      |      "row": 4,
      |      "costMarketValue": 9795.28,
      |      "acquiredFromName": "Celie Cornwell",
      |      "costOrMarket": "Cost Value",
      |      "totalIncomeOrReceipts": 4883.79,
      |      "nino": {
      |        "nino": "SH137044D"
      |      }
      |    }
      |  ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "tangible-moveable-property")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "tangible-moveable-property")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "tangible-moveable-property")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
