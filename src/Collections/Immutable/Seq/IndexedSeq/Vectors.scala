package Collections.Immutable.Seq.IndexedSeq

import scala.Vector


//Vectors are alternate to the List
// List is not good for random access. Head/tail/append other than these rest are linear times in List
// In vector almost all operations are constant timed (but slightly higher than List constant time
// Vector is represented in the form of Tree with 32 child nodes. 
//So the traversal time is lesser in Vector

// No mutable form of Vector is available 
//Vectors are immutable
object Vectors extends App{
  
  
  // Like List Nil but not at the last
  val empty  =  Vector.empty
  val vector1  = empty :+ 1 :+ 2 :+ 3 :+ 4
  println(vector1 head)
  
  val vector2 = Vector(5,6,7,8,9)
  println(vector2 take 4)
  
  println(vector2 updated (2,56))
  
}