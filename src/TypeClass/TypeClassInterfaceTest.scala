package TypeClass

import HtmlifyInstances._
import EqualsInstances._

object Test1 extends App {
  //This uses the implicit instances we have  imported via HtmlifyInstances._
  println(TypeClassInterface_demo.htmlify(true))

  //This syntactic sugar. This simply invokes the apply method defixned in the companion object of Htmlify Type class
  println(Htmlify[Boolean].write(true))

  //Referred from EqualsTest file
  println("Helson" === "Gladys")
  println(23 === 234)

  //This uses the syntactic Equals Companion object's apply method
  println(Equals[String].equals("Melinda", "Melinda"))
}

//A simple object which expects an implicit parameter which is a type class instance.
//This is an example for type class interface

// But look, that the only functionality here is given by the type class instance alone and nothing else.
// So we can define an apply method inside the companion object of the type class itself to give us the required instance.
object TypeClassInterface_demo {
  def htmlify[A](inp: A)(implicit writer: Htmlify[A]) = {
    writer.write(inp)
  }
}
