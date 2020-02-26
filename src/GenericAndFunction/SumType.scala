package GenericAndFunction

// Sum ADT using Generic Type parameter
// Sum is an ADT with IS-A relationship. It cab be either success or failure
// However as Scala built-in we already have ***Either[A,B]*** as generic class of this nature (with Left, Right methods)
object SumTypeRun extends App {

  val sumSuccess: Sum[String, Int] = SumSuccess("Helson")
  println(sumSuccess.map(x => x + x))

  val sumFailure: Sum[String, Int] = SumFailure(34)
  println(sumFailure.map(x => x + 18))

}

//Note: Here Generic Type parameters [A,B] denotes the Generic Type of the Sub types of Sum
// Whereas for Product Type is denotes the Generic Type of the constructor parameter or the fields within it
sealed trait Sum[A, B] {
  // map would in generally take A => B function . But Sum has 2 generic type params.
  // So we need to fix one of these sub types and implement Map function accordingly.
  def map[C](fn: A => C): Sum[C, B] = {
    this match {
      case SumSuccess(value) => SumSuccess(fn(value))
      case SumFailure(value) => SumFailure(value) // Note : we are not mapping on Failure case
    }
  }

}
case class SumSuccess[A, B](value: A) extends Sum[A, B]
case class SumFailure[A, B](value: B) extends Sum[A, B]