package PatternCaseClass

//This is a demo to show how to use Scala Class in Pattern match
//Idea is to create a companion object of the given class with apply and unapply method

// Animal is a normal class but used in pattern matching by defining a companion object with
// apply and unapply method.
//
object Class2CaseClass extends App {

  def func(an: Animal) = an match {
    case Animal("Dog", a) => s"a"
    case Animal("Cat", a) => "Cat"
  }

}

class Animal(val name: String, val age: Int) {
  def getNameAge = s"$name and $age"
}

object Animal {
  def apply(name: String, age: Int): Animal = new Animal(name, age)
  def unapply(a: Animal): Option[(String, Int)] = Some(a.name, a.age)
}
