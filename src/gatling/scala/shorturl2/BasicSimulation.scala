package shorturl2

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class BasicSimulation extends Simulation {

  val httpProtocol = http
    .baseUrl("http://localhost:8080/") // Here is the root for all relative URLs
    .acceptHeader("text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8") // Here are the common headers
    .acceptEncodingHeader("gzip, deflate")
    .acceptLanguageHeader("en-US,en;q=0.5")
    .userAgentHeader("Mozilla/5.0 (Macintosh; Intel Mac OS X 10.8; rv:16.0) Gecko/20100101 Firefox/16.0")

  val scn = scenario("Scenario Name")
    .exec(http("request_1")
      .get("/"))
    .pause(1)
    .exec(http("request_2")
      .post("/shortUrl/save")
      .formParam("""url""", """https://t4w4n3.github.io/"""))
    .pause(2)
    .exec(http("request_3")
      .get("/t4w4n3"))


  //  setUp(scn.inject(atOnceUsers(4)).protocols(httpProtocol))
  val duringSeconds: Integer = Integer.getInteger("duringSeconds", 10)
  val constantUsers: Integer = Integer.getInteger("constantUsers", 10)
  setUp(scn.inject(constantConcurrentUsers(constantUsers) during (duringSeconds)).protocols(httpProtocol)).maxDuration(1800)
    .assertions(global.responseTime.max.lt(20000), global.successfulRequests.percent.gt(95))
}
