package Collections.Immutable.Seq.LinearSeq

import scala.collection.immutable.Stream.consWrapper
import scala.math.BigInt.int2bigInt


// STreams are immutable and lazily evaluated . 
//Only the first element of the Stream evaluated first rest are evaluated on request (when Action is applied on the Stream)
object Streams extends App{
  
  //Similar to List but the values are evaluated lazily and appended using '#::'
  val stream1 = 'a' #:: 'b' #:: 'c' #:: 'd' #:: Stream.empty
  println(stream1.take(4).toList)
  
  
  //Here the fibnocci series is not evaluated until the action is applied on the same
  def fibFrom(a : BigInt , b : BigInt) : Stream[BigInt] = a #:: fibFrom(b , a + b)
  println(fibFrom(1,1))
  println(fibFrom(1,1).take(100).toList)
  
  
  
  
  
}
