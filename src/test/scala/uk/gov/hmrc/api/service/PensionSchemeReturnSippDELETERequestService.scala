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

package uk.gov.hmrc.api.service

import play.api.libs.ws.StandaloneWSRequest
import uk.gov.hmrc.api.client.HttpClient
import uk.gov.hmrc.api.conf.TestConfiguration

import scala.concurrent.Await
import scala.concurrent.duration._

class PensionSchemeReturnSippDELETERequestService extends HttpClient {
  val host: String   = TestConfiguration.url("pension-scheme-return-sipp")
  val psrURL: String = s"$host/psr"

  def deleteStandardPSR(authToken: String, payload: String, action: String): StandaloneWSRequest#Self#Response =
    Await.result(
      put(
        s"$psrURL/$action/24000020IN?fbNumber=000000021224&journeyType=Standard",
        payload,
        ("Authorization", authToken),
        ("Content-Type", "application/json"),
        ("srn", "S2400000020")
      ),
      10.seconds
    )

  def deleteAsset(authToken: String, payload: String, action: String): StandaloneWSRequest#Self#Response =
    Await.result(
      put(
        s"$psrURL/$action/24000020IN?fbNumber=000000021224&journeyType=Standard&journey=ArmsLengthLandOrProperty",
        payload,
        ("Authorization", authToken),
        ("Content-Type", "application/json")
      ),
      10.seconds
    )
}
