package Concurrent
import scala.util._
import scala.concurrent.ExecutionContext
import scala.concurrent._

object Future2 extends App {

  implicit val ec = ExecutionContext.global

  val Future1 = Future {
    2 / 2
  }

  Future1 map {
    x => println(x)
  }recover {
    case _ => println("Error")
  }
  
  
//   Future1 onComplete {
//    case Success(x) => println(x)
//    case Failure(t) => println(t.getMessage)
//  }

  //  Future1 foreach {x =>
  //    println(x)
  //  }

  Thread.sleep(5000)

}