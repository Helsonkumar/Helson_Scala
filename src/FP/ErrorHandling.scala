package FP


//** Demo to show how errors are handled in FP
//** General Style : Avoid throwing exception for following reason .
//**  Exceptions are not Referntialy transparent They are context bound
//**  Exceptions are not Type Safe  : Compiler would not lets us know abt the possible exception which can be thrown by a functional argument
//** Using Sentinel values would force cleint to handle the value correctly with large boiler plate code
//** So we have Option[A] to rescue
object ErrorHandling {

  def main(args: Array[String]): Unit = {

    println(FuncErr())

    //** Look the compiler does not alerts us to handle the exceptin which can possibly be thrown by the errFunc
    //** The exception is thrown only during the runtime. This is a proble whilst using Exception in functional program
    println(func1(5)(errFunc))

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

}

case object None extends HelOption[Nothing]

case class Some[+A](a: A) extends HelOption[A]



