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

class PensionSchemeReturnSIPPArmsPUTRequestsSpec extends BaseSpec {

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
      |      "totalCost": 18716.7,
      |      "isPropertyDisposed": "No",
      |      "noOfPersons": 10,
      |      "nameDOB": {
      |        "firstName": "Ruthann",
      |        "lastName": "McLewd",
      |        "dob": "2018-09-10"
      |      },
      |      "independentValuation": "Yes",
      |      "acquisitionDate": "1990-11-06",
      |      "row": 3,
      |      "registryDetails": {
      |        "registryRefExist": "Yes",
      |        "registryReference": "AB123456"
      |      },
      |      "landOrPropertyInUK": "Yes",
      |      "addressDetails": {
      |        "addressLine1": "Room 916",
      |        "addressLine4": "Quinta",
      |        "addressLine3": "17 Crownhardt Point",
      |        "ukPostCode": "HS499ZX",
      |        "countryCode": "GB",
      |        "addressLine2": "Room 1589"
      |      },
      |      "residentialSchedule29A": "No",
      |      "totalIncomeOrReceipts": 23370.2,
      |      "nino": {
      |        "nino": "SH538748B"
      |      },
      |      "acquiredFromName": "Ruthann McLewd",
      |      "lesseeDetails": {
      |        "numberOfLessees": 1,
      |        "anyLesseeConnectedParty": "No",
      |        "leaseGrantedDate": "2015-11-23",
      |        "annualLeaseAmount": 2175.35
      |      },
      |      "jointlyHeld": "Yes",
      |      "isLeased": "Yes"
      |    },
      |    {
      |      "totalCost": 23548.43,
      |      "isPropertyDisposed": "Yes",
      |      "nameDOB": {
      |        "firstName": "Lancelot",
      |        "lastName": "Sanderson",
      |        "dob": "2023-12-01"
      |      },
      |      "independentValuation": "No",
      |      "disposalDetails": {
      |        "disposedPropertyProceedsAmt": 18393.57,
      |        "purchasersNames": "Lancelot Sanderson",
      |        "propertyFullyDisposed": "No",
      |        "independentValuationDisposal": "No",
      |        "anyPurchaserConnectedParty": "Yes"
      |      },
      |      "acquisitionDate": "1991-09-18",
      |      "row": 4,
      |      "registryDetails": {
      |        "registryRefExist": "Yes",
      |        "registryReference": "CD123456"
      |      },
      |      "landOrPropertyInUK": "No",
      |      "acquiredFromName": "Lancelot Sanderson",
      |      "addressDetails": {
      |        "addressLine1": "PO Box 68389",
      |        "addressLine4": "97 Prairie Rose Junction",
      |        "addressLine3": "6 Harper Alley",
      |        "countryCode": "ID",
      |        "addressLine2": "Suite 60"
      |      },
      |      "residentialSchedule29A": "No",
      |      "totalIncomeOrReceipts": 19260.3,
      |      "nino": {
      |        "nino": "SH617878A"
      |      },
      |      "jointlyHeld": "No",
      |      "isLeased": "No"
      |    }
      |  ]
      |}
      |""".stripMargin
  Feature("PUT Request for Updating details for assets class") {

    Scenario("Verify 201 response when PUT request to Update Assets from connected party details") {
      Then("201 response is expected when updating details of asset class")
      PUTRequestsHelper.putFullBodyRequestEndpoint(authBearerToken, payload, "land-arms-length")
    }

    Scenario("401 Unauthorized error when PUT request to Update Assets from connected party details without token") {
      Then("401 response is expected when updating details of asset class")
      PUTRequestsHelper.putUnauthorizedRequestEndpoint("", payload, "land-arms-length")
    }

    Scenario("400 Server error when PUT request to Update Assets from connected party details without payload") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNoBodyRequestEndpoint(authBearerToken, "", "land-arms-length")
    }

    Scenario("404 error when PUT request to Update Assets from connected party details with invalid url") {
      Then("400 response is expected when updating details of asset class")
      PUTRequestsHelper.putNotFoundErrorRequestEndpoint(authBearerToken, payload, "")
    }
  }
}
