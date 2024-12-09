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

class PensionSchemeReturnSIPPLandPUTRequestsSpec extends BaseSpec {

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
      |      "totalCost": 1038.09,
      |      "isPropertyDisposed": "No",
      |      "nameDOB": {
      |        "firstName": "Natale",
      |        "lastName": "Brodeau",
      |        "dob": "1964-12-10"
      |      },
      |      "independentValuation": "Yes",
      |      "acquisitionDate": "2008-05-16",
      |      "row": 3,
      |      "registryDetails": {
      |        "registryRefExist": "Yes",
      |        "registryReference": "AB123456"
      |      },
      |      "landOrPropertyInUK": "Yes",
      |      "acquiredFromName": "Natale Brodeau",
      |      "addressDetails": {
      |        "addressLine1": "6th Floor",
      |        "addressLine4": "Bendo",
      |        "addressLine3": "622 Daystar Point",
      |        "ukPostCode": "FJ678BX",
      |        "countryCode": "GB",
      |        "addressLine2": "Room 1504"
      |      },
      |      "residentialSchedule29A": "Yes",
      |      "totalIncomeOrReceipts": 4255.31,
      |      "nino": {
      |        "nino": "SH956162C"
      |      },
      |      "jointlyHeld": "No",
      |      "isLeased": "No"
      |    },
      |    {
      |      "totalCost": 7461.26,
      |      "isPropertyDisposed": "Yes",
      |      "noOfPersons": 6,
      |      "nameDOB": {
      |        "firstName": "Price",
      |        "lastName": "Shovelin",
      |        "dob": "2003-11-02"
      |      },
      |      "independentValuation": "Yes",
      |      "disposalDetails": {
      |        "disposedPropertyProceedsAmt": 4968,
      |        "purchasersNames": "Price Shovelin",
      |        "propertyFullyDisposed": "No",
      |        "independentValuationDisposal": "No",
      |        "anyPurchaserConnectedParty": "No"
      |      },
      |      "acquisitionDate": "1994-03-27",
      |      "row": 4,
      |      "registryDetails": {
      |        "registryRefExist": "Yes",
      |        "registryReference": "CD123456"
      |      },
      |      "landOrPropertyInUK": "No",
      |      "addressDetails": {
      |        "addressLine1": "16th Floor",
      |        "addressLine4": "4 Doe Crossing Avenue",
      |        "addressLine3": "9115 Thompson Road",
      |        "countryCode": "ID",
      |        "addressLine2": "3rd Floor"
      |      },
      |      "residentialSchedule29A": "No",
      |      "totalIncomeOrReceipts": 9355.27,
      |      "nino": {
      |        "nino": "SH584060B"
      |      },
      |      "acquiredFromName": "Price Shovelin",
      |      "lesseeDetails": {
      |        "numberOfLessees": 1,
      |        "anyLesseeConnectedParty": "No",
      |        "leaseGrantedDate": "2017-10-22",
      |        "annualLeaseAmount": 5679.04
      |      },
      |      "jointlyHeld": "Yes",
      |      "isLeased": "Yes"
      |    }
      |  ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "land-or-connected-property")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "land-or-connected-property")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "land-or-connected-property")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
