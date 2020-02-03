package Concurrent
import scala.concurrent._
import scala.util._

// Promise is treated as one time writable container
// Promise is another way to create a Future object
// Think of Promise as Pub/Sub modeller where clients are given wit a promised item when the item is asigned to the promise object
// Clients do not have to wait for the future to complete if the value for promise is assigned within another Future.
// Promise has  : Success and Failure methods
object Promises extends App {

  implicit val ec = ExecutionContext.global

  val p = Promise[BigInt]()
  val f = p.future

  val Future1 = Future {
    val fib_num = fib(20)
    p success fib_num
    fib(fib_num)
  }

  f foreach { x => println("This is the value of First Fib: " + x) }

  Future1 onComplete {
    case Success(x) => println("This is the value of Future1: " + x)
    case Failure(t) => println("This is the value on failure: " + t)
  }

  Thread.sleep(5000)
  println("This is end of the main thread")

  def fib(n: BigInt): BigInt = {

    def fibInt(prev0: BigInt, prev1: BigInt, curr: BigInt): BigInt = {
      if (n < curr)
        prev1
      else
        fibInt(prev1, prev1 + prev0, curr + 1)
    }
    fibInt(0, 1, 2)
  }

}