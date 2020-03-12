package TypeClass

sealed trait Equals[A] {
  def equals(x: A, y: A): Boolean
}

// This is a simple companion object which hold the syntactic apply method.
object Equals {
  def apply[A](implicit instance: Equals[A]) = {
    instance
  }
}

object EqualsInstances {

  // Look we have created the instances of our Type Class Equals as val (using new Equals[String]) and also as an object
  // Thus it looks like we can treat Type Class as normal class

  implicit val stringInstance = new Equals[String] {
    def equals(x: String, y: String) = {
      x == y
    }
  }

  implicit object intInstance extends Equals[Int] {
    def equals(x: Int, y: Int) = {
      x == y
    }
  }

  implicit class EqualsCheck[A](x: A) {
    def ===(y: A)(implicit Instance: Equals[A]) = {
      Instance.equals(x, y)
    }
  }
}




