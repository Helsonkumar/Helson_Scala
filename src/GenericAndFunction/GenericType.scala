package GenericAndFunction

import scala.annotation._
object GenericType extends App {

  val list1 = LinkedPair("Helson", LinkedPair("Naveena", LinkedPair("Melinda", LinkedEnd())))
  println(list1 length)
  println(list1 contains "Naveena")
  println(list1(2))

  val list2 = LinkedPair(30, LinkedPair(21, LinkedPair(89, LinkedEnd())))
  println(list2 length)
  println(list2 contains 31)
  println(list2(2))

}

// This is a simple trait which has default methods implemented
// This trait has lots of method defined with duplication and restricted to Int alone.
// Lets try to define this same trait more Generic
trait IntList {
  def length: Int = {
    this match {
      case End => 0
      case Pair(head, tail) => head + tail.length
    }
  }

  def double: IntList = {
    this match {
      case End => End
      case Pair(head, tail) => Pair(2 * head, tail.double)
    }
  }

  def product: Int = {
    this match {
      case End => 1
      case Pair(head, tail) => head * tail.product
    }
  }

  @tailrec
  final def sum(acc:Int, rest : IntList): Int = {
    this match {
      case End => 0
     // case Pair(head, tail) => head + tail.sum
      case Pair(head,tail) => sum(acc + head, tail)
    }
  }
}

case object End extends IntList
case class Pair(head: Int, tail: IntList) extends IntList

// Generic : They are the abstraction over classes.
// They have Type parameter : [A]
// The type parameter can be defines at class level / trait level so it it applicable for all members of the class
// Or even a method level so it is restricted to the method alone.

sealed trait Result[A]
case class Success[A](result: A) extends Result[A]
case class Failure[A](result: String) extends Result[A]
// The Type parameter must be passed from the extending class to the class being extended.
// So we need to pass the type parameter in the class whichever is there in the class being extended.

//If the IntList is made generic using the type param, this is how it would be:
//See we have are passing [A] from subclass to super class / trait.
//Look like concrete types there is no concrete types to define the operation available in a generic type like [A].
//We will come to know about the actual A only during the instantiation of the Generic Type which is too late for us to use the definition of the actual type we pass in during instantiation.
//So in generic class definition there would not be any reference like accessing methods in the Generic type [A].
//***If U need so then we have to make that generic Parameter as Contravariant [-A]
sealed trait LinkedList[A] {

  //Here Generic type is given as Parameter
  def contains(x: A): Boolean = {
    this match {
      case LinkedPair(head, tail) => {
        if (head == x)
          true
        else
          tail.contains(x)
      }
      case LinkedEnd() => false
    }
  }

  //Generic type is given for return type.
  def apply(Index: Int): A = {
    this match {
      case LinkedEnd() => throw new Exception()
      case LinkedPair(head, tail) => {
        if (Index == 0)
          head
        else
          tail(Index - 1)
      }
    }
  }

  //Find the length of the List
  def length: Int = {
    this match {
      case LinkedEnd() => 0
      case LinkedPair(head, tail) => 1 + tail.length
    }

  }
}
final case class LinkedEnd[A]() extends LinkedList[A]
final case class LinkedPair[A](head: A, tail: LinkedList[A]) extends LinkedList[A]
