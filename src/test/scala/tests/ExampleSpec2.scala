package tests

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ExampleSpec2 extends BaseSpec{

  def expediaTaapHome(url: String) = Future {
    print("Going to:" + url + " ")
    go to(url)
    "pageloaded"
  }

  "2 The sandbox webpage" should "have the element log in" in {
    val home = expediaTaapHome("https://wwwexpediacom.trunk.sb.karmalab.net/")
    home.map(s => {
      println(s)
      //val e:Option[Element] = find("search-button-hp-package")
      pageTitle should be("Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares")
    })
  }

  "2 The prod webpage" should "have the correct title" in {
    val home = expediaTaapHome("http://expedia.com/" + "TAAP-Info")
    home.map(s => {
      println(s)
      pageTitle should be("Travel Agent Affiliate Program")
    })
  }
}