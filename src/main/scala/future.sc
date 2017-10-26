import scala.util.Random
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future






val result1 = Future{
  val l = for(i <- 1 to 1000 )
    yield Random.nextInt()%1000
  l.sortBy(x => x)
  "done"
}

val result2 = Future{
  for( _ <- 1 to 100) {
    val l = for (i <- 1 to 1000)
      yield Random.nextInt() % 1000
    l.sortBy(x => x)
  }
  "done2"
}

print(result1.map{s => s})
print(result2.map{s => s})
