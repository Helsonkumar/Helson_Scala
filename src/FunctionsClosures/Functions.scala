package FunctionsClosures

//This is a demo to show what is a function in scala.
//** Functional Programming actually means to treat Functions as "First Class Member".ie To treat functions as free form values which cab be
//   passed around as parameter and cab be returned as value like any other Int,String,Object,etc.
//**Functions defined inside an object are called methods since they are always referred with their object reference.
//** Functions as individual blocks can be composed together to form bigger opeartions.

object Functions extends App {

  // A function literal is like Class.
  // A function value is the end result after applying arguments(Instantiating) to the function literal.
  // A functions is convereted into a class of Function trait (0 to 22) with apply methods in it.
  def sum(a: Int, b: Int, c: Int): Int = {
    (a + b + c) * 2
  }

  //Partially applied function with "_" or given only few of the params : Placeholder syntax
  val part_func = sum _
  val part_fucn2 = sum(2, _: Int, _: Int)

  println(part_fucn2(3, 5))

  //Application of list of arguments
  //Watch for the syntax
  // INternally it is interpreted as Array[String]
  def mulArg(args: String*): String = args(2)

  println(mulArg("helson", "Naveena", "Baskar", "Kumar", "Melinda"))

  //If we have an Array of any Seq of types then we can have them cracked and splitted up into to a Sequence of type as follows
  val arr = Array("Naveena", "Melinda", "Helson")
  println(mulArg(arr: _*))
}