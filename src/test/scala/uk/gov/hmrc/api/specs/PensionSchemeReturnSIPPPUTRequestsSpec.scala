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

class PensionSchemeReturnSIPPPUTRequestsSpec extends BaseSpec {

  val pensionSchemeReturnSippPUTServiceAPI: PensionSchemeReturnSippPUTRequestService =
    new PensionSchemeReturnSippPUTRequestService
  val authBearerToken: String                                                        = authHelper.getAuthBearerToken
  val payload: String                                                                =
    """
      {
      |  "reportDetails": {
      |    "pstr": "24000020IN",
      |    "status": "Submitted",
      |    "periodStart": "2023-01-01",
      |    "periodEnd": "2023-12-31",
      |    "schemeName": "Sample Scheme Name",
      |    "version": "1.0"
      |  },
      |  "transactions": [
      |      {
      |        "nameDOB": {
      |          "firstName": "John",
      |          "lastName": "Doe",
      |          "dob": "1980-01-01"
      |        },
      |        "nino": {
      |          "nino": "AB123456C",
      |          "reasonNoNino": null
      |        },
      |        "acquisitionDate": "2023-05-15",
      |        "assetDescription": "Real Estate",
      |        "acquisitionOfShares": "No",
      |        "shareCompanyDetails": null,
      |        "acquiredFromName": "Jane Smith",
      |        "totalCost": 250000.00,
      |        "independentValuation": "Yes",
      |        "tangibleSchedule29A": "No",
      |        "totalIncomeOrReceipts": 5000.00,
      |        "isPropertyDisposed": "Yes",
      |        "disposalDetails": {
      |          "disposedPropertyProceedsAmt": 300000.00,
      |          "purchasersNames": "Buyer Inc.",
      |          "anyPurchaserConnectedParty": "No",
      |          "independentValuationDisposal": "Yes",
      |          "propertyFullyDisposed": "Yes"
      |        },
      |        "disposalOfShares": "No",
      |        "noOfSharesHeld": null
      |      },
      |      {
      |        "nameDOB": {
      |          "firstName": "Alice",
      |          "lastName": "Johnson",
      |          "dob": "1975-03-22"
      |        },
      |        "nino": {
      |          "nino": null,
      |          "reasonNoNino": "Not applicable"
      |        },
      |        "acquisitionDate": "2023-07-10",
      |        "assetDescription": "Company Shares",
      |        "acquisitionOfShares": "Yes",
      |        "shareCompanyDetails": {
      |          "companySharesName": "Tech Corp",
      |          "companySharesCRN": "123456789",
      |          "reasonNoCRN": null,
      |          "sharesClass": "A",
      |          "noOfShares": 100
      |        },
      |        "acquiredFromName": "Bob Brown",
      |        "totalCost": 50000.00,
      |        "independentValuation": "No",
      |        "tangibleSchedule29A": "Yes",
      |        "totalIncomeOrReceipts": 2000.00,
      |        "isPropertyDisposed": "No",
      |        "disposalDetails": null,
      |        "disposalOfShares": "No",
      |        "noOfSharesHeld": 100
      |      },
      |      {
      |        "nameDOB": {
      |          "firstName": "John",
      |          "lastName": "Doe",
      |          "dob": "1980-01-01"
      |        },
      |        "nino": {
      |          "nino": "AB123456C",
      |          "reasonNoNino": null
      |        },
      |        "acquisitionDate": "2023-07-10",
      |        "assetDescription": "Company Shares",
      |        "acquisitionOfShares": "Yes",
      |        "shareCompanyDetails": {
      |          "companySharesName": "Tech Corp",
      |          "companySharesCRN": "123456789",
      |          "reasonNoCRN": null,
      |          "sharesClass": "A",
      |          "noOfShares": 100
      |        },
      |        "acquiredFromName": "Bob Brown",
      |        "totalCost": 50000.00,
      |        "independentValuation": "No",
      |        "tangibleSchedule29A": "Yes",
      |        "totalIncomeOrReceipts": 2000.00,
      |        "isPropertyDisposed": "No",
      |        "disposalDetails": null,
      |        "disposalOfShares": "No",
      |        "noOfSharesHeld": 100
      |      },
      |    {
      |        "nameDOB": {
      |          "firstName": "John",
      |          "lastName": "Doe",
      |          "dob": "1980-01-01"
      |        },
      |        "nino": {
      |          "nino": "AB123456C",
      |          "reasonNoNino": null
      |        },
      |        "acquisitionDate": "2023-07-10",
      |        "assetDescription": "Company Shares",
      |        "acquisitionOfShares": "Yes",
      |        "shareCompanyDetails": {
      |          "companySharesName": "Tech Corp",
      |          "companySharesCRN": "123456789",
      |          "reasonNoCRN": null,
      |          "sharesClass": "A",
      |          "noOfShares": 100
      |        },
      |        "acquiredFromName": "Bob Brown",
      |        "totalCost": 50000.00,
      |        "independentValuation": "No",
      |        "tangibleSchedule29A": "Yes",
      |        "totalIncomeOrReceipts": 2000.00,
      |        "isPropertyDisposed": "No",
      |        "disposalDetails": null,
      |        "disposalOfShares": "No",
      |        "noOfSharesHeld": 100
      |      }
      |    ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "assets-from-connected-party")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "assets-from-connected-party")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "assets-from-connected-party")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
