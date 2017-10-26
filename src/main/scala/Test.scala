/**
  * Created by sogoyal on 10/26/17.
  */
import scala.util.{Failure, Random, Success}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

object Test extends App{
  val result2 = Future{
    for( _ <- 1 to 100) {
      val l = for (i <- 1 to 5000)
        yield Random.nextInt() % 10000
      l.sortBy(x => x)
    }
    "done2"
  }

  val result1 = Future{
    val l = for(i <- 1 to 5000 )
      yield Random.nextInt()%10000
    l.sortBy(x => x)
    "done"
  }



  result2.map{s => print(s)}
  result1.map{s => print(s)}
  /*
  result1 onComplete {
    case Success(s) => print(s)
    case Failure(t) => print(t.getMessage())
  }
  result2 onComplete {
    case Success(s) => print(s)
    case Failure(t) => print(t.getMessage())
  }
  */
  Thread.sleep(1000)
}
