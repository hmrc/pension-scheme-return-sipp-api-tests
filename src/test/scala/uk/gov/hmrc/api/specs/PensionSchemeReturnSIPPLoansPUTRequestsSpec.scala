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

class PensionSchemeReturnSIPPLoansPUTRequestsSpec extends BaseSpec {

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
      |      "row": 3,
      |      "dateOfLoan": "2024-02-24",
      |      "repayDate": "2005-02-09",
      |      "outstandingYearEndAmount": 688668.58,
      |      "arrearsOutstandingPrYears": "Yes",
      |      "interestRate": 6.12,
      |      "amountOfLoan": 8168912.9,
      |      "loanSecurity": "Yes",
      |      "nino": {
      |        "nino": "EP200893B"
      |      },
      |      "loanRecipientName": "Humberto Kop",
      |      "arrearsOutstandingPrYearsAmt": 250,
      |      "loanConnectedParty": "No",
      |      "capitalRepayments": 796691.4,
      |      "nameDOB": {
      |        "firstName": "Humberto",
      |        "lastName": "Kop",
      |        "dob": "1928-03-13"
      |      }
      |    },
      |    {
      |      "row": 4,
      |      "dateOfLoan": "2021-10-12",
      |      "repayDate": "2020-06-02",
      |      "outstandingYearEndAmount": 186769.32,
      |      "arrearsOutstandingPrYears": "Yes",
      |      "interestRate": 16.68,
      |      "amountOfLoan": 9231508.47,
      |      "loanSecurity": "No",
      |      "nino": {
      |        "nino": "AA716047A"
      |      },
      |      "loanRecipientName": "Raddie O'Hagirtie",
      |      "arrearsOutstandingPrYearsAmt": 100,
      |      "loanConnectedParty": "No",
      |      "capitalRepayments": 267262.08,
      |      "nameDOB": {
      |        "firstName": "Raddie",
      |        "lastName": "O'Hagirtie",
      |        "dob": "1987-03-04"
      |      }
      |    }
      |  ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "outstanding-loans")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "outstanding-loans")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "outstanding-loans")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
