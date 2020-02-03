package Collections.Immutable.Seq.LinearSeq
import scala.collection.immutable._

object Queues extends App{
 
  val queue1 = Queue()
  val queue2  = queue1 enqueue 23
  val queue3 = queue2 enqueue 45
  println(queue1)
  
  println(queue3 dequeue)
  
  
  
}