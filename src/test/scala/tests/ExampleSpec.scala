package tests

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ExampleSpec extends BaseSpec{



   def expediaTaapHome(url: String, id: Int) = Future {
     go to(url)
     print(id.toString() + " Going to:" + url + "\n")

   }

  "The trunk webpage" should "have the element log in" in {
    val home = expediaTaapHome("https://wwwexpediacom.trunk.sb.karmalab.net/", 1)
    home.map(s => {
      println(s)
      //val e:Option[Element] = find("search-button-hp-package")
      pageTitle should be("Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares")
    })
  }

  "The prod webpage" should "have the correct title" in {
    val home = expediaTaapHome("http://expedia.com/" + "TAAP-Info", 1)
    home.map(s => {
      println(s)
      pageTitle should be("Travel Agent Affiliate Program")
    })
  }
}