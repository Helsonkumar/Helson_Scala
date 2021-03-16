package FP

sealed trait HelList[+A]

//** Possible constructors for the given type
//** "Nothing" subclass to all types
case object Nil extends HelList[Nothing]

case class Cons[A](head: A, tail: HelList[A]) extends HelList[A]

//** Scala provides def toString & hashCode impl for any case class and object

//Companion object to hold some valuable functions for the given type(static methods)
object HelList {

  def sum(a: HelList[Int]): Int = a match {
    case Nil => 0
    case Cons(x, xs) => x + sum(xs)
  }

  def product(a: HelList[Long]): Long = a match {
    case Nil => 1L
    case Cons(x, xs) => x * product(xs)
    case Cons(0, xs) => 0
  }

  //** apply is a "Variadic Function" : meaning it accepts zero
  //or more arguments of type A
  //** The argument with A* is bound to Seq[A] which has head and tail methods: _* allows us to pass Seq[A] to a Variadic Function
  def apply[A](as: A*): HelList[A] = {
    if (as.isEmpty) Nil
    else
      Cons(as.head, apply(as.tail: _*))

  }
}


//** In the above companion object method sum and product we have room for abstraction.
//** The only diff between those 2 function  : What value in Nil condition and what operator must be used for each function.
//** Convert the subexpression as function in argument
//** Try making this tail recursive
object folder {

  def foldRight[A, B](xs: HelList[A], z: B)(f: (A, B) => B): B = xs match {
    case Nil => z
    case Cons(x, xs) => f(x, foldRight(xs, z)(f))
  }

}


object FPRunner {

  def main(args: Array[String]): Unit = {
    val helson = HelList("Helson", "Kumar", "Melinda", 23)
    println(helson)

    val helson_int = HelList(1, 2, 3, 4, 5, 6)
    val helson_double = HelList(1.2, 2.3, 3.4, 4.5)

    println(folder.foldRight(helson_int, 0)(_ + _))
    println(folder.foldRight(helson_int, 1.0)(_ * _))

  }

}



