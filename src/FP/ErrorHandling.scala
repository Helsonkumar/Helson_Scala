package FP


//** Demo to show how errors are handled in FP
//** General Style : Avoid throwing exception for following reason .
//**  Exceptions are not Referntialy transparent They are context bound
//**  Exceptions are not Type Safe  : Compiler would not lets us know abt the possible exception which can be thrown by a functional argument
//** Using Sentinel values would force cleint to handle the value correctly with large boiler plate code
//** So we have Option[A] to rescue : But simply represents either a Some(a) for success or None for exception.
//** It does not give detailed explaination of the exception if occurs.


//** The idea behind Error Handling in FP relies on the principle  : """Effects As Values"""
object ErrorHandling {

  def main(args: Array[String]): Unit = {

    println(FuncErr())

    //** Look the compiler does not alerts us to handle the exceptin which can possibly be thrown by the errFunc. So this is not TYPE-SAFE
    //** The exception is thrown only during the runtime. This is a proble whilst using Exception in functional program
    // println(func1(5)(errFunc))

    val a: HelOption[Int] = Some(24)

    val b: Seq[Double] = Seq(1, 3, 5, 6, 8)

    val c : HelList[HelOption[Int]] = HelList(Some(10), Some(15), Some(17))

    //** experiment the below funtions
    println(a.map(x => x + 2).getOrElse(9999))

    def flat_func(a: Int) = {
      if (a < 20) Some(4444) else None

    }

    println(a.flatMap(flat_func).getOrElse(8888))

    println(a.getOrElse(7777))

    println(None.orElse(Some(6666)).getOrElse(5555))

    println(a.filter(_ > 50).getOrElse(3333))

    println(HelOption.mean(b) getOrElse (3453))

    println(HelOption.variance(b).getOrElse(2222))

    println(HelOption.map2(Some(42), Some(22))(_ + _))

    println(HelOption.map2_for(Some(42), Some(52))(_ + _))

    println(HelList.sum(HelOption.sequence(c).getOrElse(HelList(99))))

    println(HelEither.safeDiv(15, 0))



  }

  //** The meaning of Excepin in this function is context dependent at each point where it is decalred.
  //** So it is not Referentially transparent as it has diff meaning at diff point of the program
  //** This makes it difficult to reason about
  def FuncErr() = {

    //val x  = throw new Exception("Err in the FuncErr")

    try {
      val y = 32 + ((throw new Exception("Err in the FuncErr")): Int)
    } catch {
      case e: Exception => 45
    }

  }

  //** A HIGH ORDER function which takes another function as an argument

  def func1(x: Int)(f: Int => Int): Int = {
    f(x)
  }

  //** This is akind of partial function which is undefined for some of the inputs
  def errFunc(x: Int): Int = {
    if (x > 3)
      throw new Exception("x greater than 3")
    else
      x + x
  }


}

//** Option defines None(used to define an exception condition) or Some(x)
sealed trait HelOption[+A] {

  //** The Option class has many useful HIGH ORDER functions which is defined within the trait
  //** these functions can be used instead of using pattern matching in our various tranformation

  //** Maps the valid value to another value thru function "f" which would not fail at all
  def map[B](f: A => B): HelOption[B] = this match {
    case Some(x) => Some(f(x))
    case None => None
  }


  //** Similar to map except the mapping function could fail
  def flatMap[B](f: A => HelOption[B]): HelOption[B] = this match {
    case Some(x) => f(x)
    case None => None
  }


  //** Filters the value and checks if it pass the condition else None
  def filter(f: A => Boolean): HelOption[A] = this match {
    case Some(x) if f(x) => this
    case _ => None
  }


  //** Check for a valid value if not present then return default value
  def getOrElse[B >: A](default: => B): B = this match {
    case Some(x) => x
    case None => default
  }


  //** Check if valid value else return another Optional value
  def orElse[B >: A](oper: => HelOption[B]): HelOption[B] = this match {
    case Some(x) => this
    case None => oper
  }


}

case object None extends HelOption[Nothing]

case class Some[+A](a: A) extends HelOption[A]


object HelOption {

  //**Fucntion to calculate the mean of the given Optional Value
  def mean(xs: Seq[Double]): HelOption[Double] = {
    if (xs.isEmpty) None else Some(xs.sum / xs.length)
  }


  //** Variance : Calculate the mean of the variance of each value in the given Sequence
  def variance(xs: Seq[Double]): HelOption[Double] = {
    mean(xs) flatMap (m => mean(xs.map(x => math.pow(x - m, 2))))
  }


  //** map2 which converts Option[A] + Option[B] to Option[C] => Mapping 2 diff types to another type
  def map2[A, B, C](a: HelOption[A], b: HelOption[B])(f: (A, B) => C) = {
    a flatMap (aa => b map (bb => f(aa, bb)))
  }

  //** Implementing map2 in for-comprehension
  //** for-comp uses bindings inside and followed by yield outside for-comp
  //** the compiler desugars these bindings into flatMap Calls
  def map2_for[A,B,C](a: HelOption[A], b: HelOption[B])(f: (A, B) => C) = {
    for{
      aa <- a
      bb <- b
    } yield f(aa,bb)

  }


  //** Sequence function : List[Option[A]] => Option[List[A]]
  def sequence[A](a : HelList[HelOption[A]]) : HelOption[HelList[A]] =
    a match {
      case Nil => Some(Nil)
      case Cons(h,t) => h flatMap(hh => sequence(t) map (Cons(hh,_)))
  }




}

//** Option[A] would simply lets us know if an exception has occured or not
//** But we need some clear text or vlaue which gives more information on the actual exception which has occured
trait HelEither[+E, +A]

//** left is reserved for the exceptional case
case class Left[+E](value: E) extends HelEither[E, Nothing]

//** Right is reserved for valid result
case class Right[+A](value: A) extends HelEither[Nothing, A]

object HelEither {

  //** We use String to represent an error condition
  def mean(xs: Seq[Double]): HelEither[String, Double] = {
    if (xs.isEmpty) Left("Seq is empty") else Right(xs.sum / xs.length)
  }


  //** Represent exception as "Exception" object
  def safeDiv(x: Int, y: Int) = {

    try Right(x / y)
    catch {
      case (e: Exception) => Left(e)
    }

  }


}





