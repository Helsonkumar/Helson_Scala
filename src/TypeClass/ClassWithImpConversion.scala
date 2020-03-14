package TypeClass

// We usually define Implicit Class for Type Enrichment
// We can get the same functionality by defining an implicit conversion with a normal class

object ImplicitConverter {
  //Here we have removed the Implicit keyword from the class
  class IntOps(x: Int) {

    def yeah() = times(_ => println("Yeah!"))

    def times(func: Int => Unit) = {
      for (i <- 0 until x) func(i)
    }

  }

  //Thats the implicit converter for U
  implicit def intToIntOps(x: Int) = {
    new IntOps(x)
  }

}

object ClassWithImpConversion extends App {

  import ImplicitConverter._
  5.yeah()
}
