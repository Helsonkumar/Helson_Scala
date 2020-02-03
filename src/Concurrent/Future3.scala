package Concurrent

import scala.concurrent.{Future , Promise}
import scala.concurrent.ExecutionContext
import scala.concurrent._
import scala.util._
import scala.concurrent.duration._

object Future3 extends App{
  implicit val ec = ExecutionContext.global
  
  val future1 = Future {
    println("This is future 1 :  1")
    println("This is future 1 :  2")
    Thread.sleep(10000)
    21
  }
  
  
  val future2 = Future {
    println("This is future2 : 1")
    println("This is future2 : 2")
    future1 foreach { x => println(x) }
  
  }
  Thread.sleep(15000)
  //Await.ready(future2,2000 seconds)
  println("End of result")
  
}