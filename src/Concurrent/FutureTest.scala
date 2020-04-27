import scala.concurrent._
import scala.concurrent.ExecutionContext
import scala.util._


object fibnocci extends App {
  
  implicit val ec = ExecutionContext.global
  
  val future1 = Future {
    fib(100)
  }
  
  def fib(n:BigInt) : BigInt = {
    
    def fibInt(prev0 :BigInt , prev1 :BigInt , curr :BigInt) :BigInt = {
      if (n < curr) 
       prev1
      else
       fibInt(prev1 , prev1 + prev0 , curr + 1)   
    }
    
    fibInt(0,1,2)
  }
  
  future1 onComplete {
    case Success(x) =>  println(x)
    case Failure(t) => println(t.printStackTrace)
  }
  
   println("This is main Thread1")
   println("This is main Thread1")
   println("This is main Thread1")
   Thread.sleep(5000)
   println("This is main Thread1")
   println("This is main Thread1")
   println("This is main Thread1")
}

