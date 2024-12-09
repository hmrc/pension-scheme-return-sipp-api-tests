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

class PensionSchemeReturnSIPPUnquotedSharesPUTRequestsSpec extends BaseSpec {

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
      |    "schemeName": "Open Scheme 2",
      |    "memberTransactions": "Yes"
      |  },
      |  "transactions": [
      |    {
      |      "nino": {
      |        "nino": "RC256097C"
      |      },
      |      "totalCost": 998112.43,
      |      "totalDividendsIncome": 8814140.31,
      |      "sharesDisposed": "Yes",
      |      "nameDOB": {
      |        "firstName": "Berkley",
      |        "lastName": "Fawley",
      |        "dob": "1997-11-07"
      |      },
      |      "independentValuation": "Yes",
      |      "row": 3,
      |      "sharesCompanyDetails": {
      |        "companySharesName": "Kayveo",
      |        "sharesClass": "Streamlined holistic hierarchy",
      |        "noOfShares": 759509,
      |        "companySharesCRN": "JP396032"
      |      },
      |      "acquiredFromName": "Flashpoint",
      |      "sharesDisposalDetails": {
      |        "disposedShareAmount": 447823.48,
      |        "purchasersNames": "Twitterworks",
      |        "independentValuationDisposal": "Yes",
      |        "noOfSharesSold": 15,
      |        "disposalConnectedParty": "Yes",
      |        "noOfSharesHeld": 1
      |      }
      |    },
      |    {
      |      "nino": {
      |        "nino": "CX813530D"
      |      },
      |      "totalCost": 406269.83,
      |      "totalDividendsIncome": 5268250.83,
      |      "sharesDisposed": "No",
      |      "nameDOB": {
      |        "firstName": "Gerladina",
      |        "lastName": "Tuckwood",
      |        "dob": "1998-01-05"
      |      },
      |      "independentValuation": "No",
      |      "row": 4,
      |      "sharesCompanyDetails": {
      |        "companySharesName": "Bubblemix",
      |        "sharesClass": "Automated neutral secured line",
      |        "noOfShares": 622,
      |        "companySharesCRN": "XS405832"
      |      },
      |      "acquiredFromName": "Browsezoom"
      |    }
      |  ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "unquoted-shares")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "unquoted-shares")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "unquoted-shares")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
