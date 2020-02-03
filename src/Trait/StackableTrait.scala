
package Trait

import scala.collection.mutable.ArrayBuffer


// This is the demo of how traits work
// Traits are similar to Java Interface , but with below exceptions
// Traits can have default methods which makes a thick interface into thin (think if Ordered trait)
// In Traits the Super call is Dynamically bound . ie The super call is decided during the runtime
// Traits can have state variables
// Traits cannot have constructor argument

// Interesting fact : Tratis can help us to achieve stackable modification
// Means : We can mixin a functionality into an object based on the order in which the traits are mixed in to the object
// This is called Class Linearization : The Hierarchy in which on object extends it super classes


object StackableTrait {

  def main(args:Array[String]): Unit = {
    
    // This is called as stackable modification
    // The modification of a method is bounded dynamically during runtime
    // Note : traitWithNoPush does have push method but, still super.push call in Doubling invokes the push method in Increment.
    // So the super call mixin in trait would always check for the immediate method availability in the linearization chain.
    
    // When we call a method in a class with mixins, then that method's availability is checked in the last trait(right most).
    // If it is not there in the trait then 
   // val queue = new BasicQueue with traitWithNoPush 
    val queue = new BasicQueue with filter with Increment
         
    for(item <- 5 until 10) queue.push(item)
    for(x <- 0 until queue.size) println(queue.pop) 
    
  }
}


class BasicQueue extends IntQueue{
  
  private val queue = new ArrayBuffer[Int]
  var size : Int = 0
  def push(x : Int) = {size += 1;queue += x }
  def pop : Int = {size -= 1;queue.remove(0)}
}


trait IntQueue {
  def push (x : Int)
  def pop : Int 
}


// Note : extends [T] means that this trait can be mixed in only into the class/trait which is of type [T]
// abstract override : this modifier means that this trait can be mixed in only after the class which provides the concrete implementation of the method
// Note we have not overridden or implemented the put method into this trait
trait Increment extends IntQueue{
    abstract override def push(x : Int) = super.push(x  + 1) 
}


trait Doubling extends IntQueue{
   abstract override def push (x :Int) = super.push( x * 2)
}


trait filter extends IntQueue{
  abstract override def push (x : Int) = if (x % 2 == 0) super.push(x)
}


//trait traitWithNoPush extends filter {
//  def simple(x: Int) : Unit = println(x)
//  abstract override def push (x : Int) =  super.push(x+x)
//}


class NonIntQueue {
  val queue = new ArrayBuffer[Int]
  def push(x : Int) = queue += x
}
