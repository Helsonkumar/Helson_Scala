package GenericAndFunction

object FunctionType extends App {

  // Functions are : Abstraction over methods or computation or Operation.

  // Function Type : (A,B) =>  C : Generalized type used to represent computation of any Type
  // Function Literal : val x = (j:Int) => {j +2}

  // Look at the IntList in The 'GenericType' Object we have created. We have duplicates
  // in the code base with pattern matching.
  // We use functions to abstract away the common computational patterns in each method and reduce duplicates.
  // Methods double,Length, sum, product each takes the member of the list and does some computation on them.
  // So lets us define an abstraction of those methods.

  //This is very important to understand this implementation
  val funlist1 = FunIntPair(23, FunIntPair(45, FunIntPair(6, FunIntPair(78, FunIntPair(9, FunIntEnd)))))
  println(funlist1.length)
  println(funlist1.sum)
  println(funlist1.double)
  println(funlist1.product)
}

// Redefined version of LinkedList
// Here we have used the Generic type apram at the method level alone:
// We have 2 types to be handled : Int and Double
sealed trait FunIntList {

  // end is the identity element of each operation
  def fold[A](end: A, f: (Int, A) => A): A = {
    this match {
      case FunIntEnd => end
      case FunIntPair(head, tail) => f(head, tail.fold(end, f))
    }
  }

  //Look deep at how we have implemented the methods in terms of fold
  def length: Int = fold[Int](0, (_, tl) => 1 + tl)
  def product: Int = fold[Int](1, (hd, tl) => hd * tl)
  def sum: Int = fold[Int](0, (hd, tl) => hd + tl)
  def double: FunIntList = fold[FunIntList](FunIntEnd, (hd, tl) => FunIntPair(hd * 2, tl))
}
case class FunIntPair(head: Int, tail: FunIntList) extends FunIntList
//Objects cannot have Type Parameters because we need to instantiated version of a Generic class
case object FunIntEnd extends FunIntList




