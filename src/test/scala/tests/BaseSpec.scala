package tests

import java.net.URL

import org.openqa.selenium.remote.{DesiredCapabilities, RemoteWebDriver}
import org.scalatest._
import org.scalatest.selenium.{Chrome, WebBrowser}
/**
  * Created by sogoyal on 10/25/17.
  */
class BaseSpec
  extends AsyncFlatSpec
  with WebBrowser
  with GivenWhenThen
  with BeforeAndAfterEach
  with Matchers
  with ParallelTestExecution {

  val capability = DesiredCapabilities.chrome()
  implicit val webDriver = new RemoteWebDriver(new URL("http://172.17.137.155:4444/wd/hub"), capability)
  val home = "http://expedia.com/"
  override def afterEach() {
    quit()
  }
}
