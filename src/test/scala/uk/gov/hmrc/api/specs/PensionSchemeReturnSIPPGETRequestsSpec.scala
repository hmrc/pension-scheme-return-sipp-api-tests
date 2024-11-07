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

import uk.gov.hmrc.api.service.PensionSchemeReturnSippGETRequestService

class PensionSchemeReturnSIPPGETRequestsSpec extends BaseSpec {

  val pensionSchemeReturnSippGETServiceAPI: PensionSchemeReturnSippGETRequestService =
    new PensionSchemeReturnSippGETRequestService
  val authBearerToken: String                                                        = authHelper.getAuthBearerToken

  Feature("GET Request for pulling details for assets class") {

    // Land or Property

    Scenario("Verify 200 OK response when GET request for land or property details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "land-or-connected-property")
    }

    Scenario("401 Unauthorized error when GET request for land or property details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "land-or-connected-property")
    }

    Scenario("404 Unauthorized error when GET request for land or property details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Arms Length

    Scenario("Verify 200 OK response when GET request for Arms Length details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "land-arms-length")
    }

    Scenario("401 Unauthorized error when GET request for Arms Length details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "land-arms-length")
    }

    Scenario("404 Unauthorized error when GET request for Arms Length details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Outstanding Loans

    Scenario("Verify 200 OK response when GET request for Outstanding Loans details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "outstanding-loans")
    }

    Scenario("401 Unauthorized error when GET request for Outstanding Loans details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "outstanding-loans")
    }

    Scenario("404 Unauthorized error when GET request for Outstanding Loans details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Assets From Connected Party

    Scenario("Verify 200 OK response when GET request for Assets From Connected Party details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "assets-from-connected-party")
    }

    Scenario("401 Unauthorized error when GET request for Assets From Connected Party details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "assets-from-connected-party")
    }

    Scenario("404 Unauthorized error when GET request for Assets From Connected Party details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Tangible Property

    Scenario("Verify 200 OK response when GET request for Tangible Property details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "tangible-moveable-property")
    }

    Scenario("401 Unauthorized error when GET request for Tangible Property details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "tangible-moveable-property")
    }

    Scenario("404 Unauthorized error when GET request for Tangible Property details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Unquoted Shares

    Scenario("Verify 200 OK response when GET request for Unquoted Shares details") {
      Then("200 response is expected when getting details of asset class")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "unquoted-shares")
    }

    Scenario("401 Unauthorized error when GET request for Unquoted Shares details without token") {
      Then("401 response is expected when getting details of asset class")
      GETRequestsHelper.getUnauthorizedRequestEndpoint("", "unquoted-shares")
    }

    Scenario("404 Unauthorized error when GET request for Unquoted Shares details with invalid URL") {
      Then("404 response is expected when getting details of asset class")
      GETRequestsHelper.getNotFoundRequestEndpoint(authBearerToken, "")
    }

    // Assets Count

    Scenario("Verify 200 OK response when GET request for Assets count") {
      Then("200 response is expected when getting details of asset count")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "asset-counts")
    }

    // SIPP PSR with FB Number

    Scenario("Verify 200 OK response when GET request for full data") {
      Then("200 response is expected when getting details of psr data")
      GETRequestsHelper.getFullBodyRequestEndpoint(authBearerToken, "sipp")
    }
  }
}
