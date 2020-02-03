// This is a demo to show how a super clas with custom contructor is constructed when a child class
// is instantiated
// We use the child class constructor variable to construct the super class

object SuperConstructor extends App{
  val helson = new Helson(32)
  println(helson.helson_age)
}


class Human(age: Int) {
  override def toString = s"$age"
}


class Helson(age: Int) extends Human(age) {
  var helson_age :Int = {age + 1}
  override def toString  = s"$helson_age"
}