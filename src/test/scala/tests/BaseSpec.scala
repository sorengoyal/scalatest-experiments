package tests

import org.scalatest._
import org.scalatest.selenium.Chrome
/**
  * Created by sogoyal on 10/25/17.
  */
class BaseSpec
  extends AsyncFlatSpec
  with Chrome
  with Matchers
  with ParallelTestExecution {

}
