package GenericAndFunction

sealed trait GenericList[A] {
  
  // Here we have mentioned B because for instance Int can be folded to give Long (A to B)
  // Fold does have to always return same type as result as its input
  // GenPair : head is of type A and tail is of type B because tail is recursive so head is not same type as tail
  // We will implement rest of the functions using this generic fold
  def fold[B](GenEnd:B,GenPair:(A,B) => B) : B = {
    this match {
      case GenericEnd() => GenEnd
      case GenericPair(head, tail) => GenPair(head, tail.fold(GenEnd, GenPair))
    }
    
  }

  //Here Generic type is given as Parameter
  def contains(x: A): Boolean = {
    this match {
      case GenericPair(head, tail) => {
        if (head == x)
          true
        else
          tail.contains(x)
      }
      case GenericEnd() => false
    }
  }

  //Generic type is given for return type.
  def apply(Index: Int): A = {
    this match {
      case GenericEnd() => throw new Exception()
      case GenericPair(head, tail) => {
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
      case GenericEnd() => 0
      case GenericPair(head, tail) => 1 + tail.length
    }

  }
}
final case class GenericEnd[A]() extends GenericList[A]
final case class GenericPair[A](head: A, tail: GenericList[A]) extends GenericList[A]
