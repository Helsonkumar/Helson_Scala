package Trait

// Traits are just like an abstraction over multiple classes having the common properties which can be
// shared across multiple classes like class being the abstraction over objects of similar type.
object FuncTrait extends App {

  def giveNextLight(light: trafficLight): String = light next

  println(giveNextLight(Red))

}

// Always prefer sealed trait  : Since this is compiler safe for suggestion during Pattern Matching
// This is an instance of adding methods in a functional style.
// If method to be added is dependent on the variables and method within the trait then add that methid inside the trait itself
// If it depends on the external variables then add it as part of external object.
// This is a polymorphic way of adding methods and types in functional programming.

// Pattern matching an object this is called "Structural Recursion"
sealed trait trafficLight {
  def next: String = this match {
    case Red => "The next is Yellow"
    case Yellow => "The next is Green"
    case Green => "Thee next is Red"
  }
}
case object Red extends trafficLight
case object Green extends trafficLight
case object Yellow extends trafficLight

// Below describes the PolyMorphic way of defining the same method.
// Here instead of defining the method inside the trait we have declared in each sub-types.
// There is a code duplication due to this.

sealed trait trafficLight2 {
  def nextLight: String
}

case object Red2 extends trafficLight2 {
  def nextLight = "The next is Yellow2"
}
case object Yellow2 extends trafficLight2 {
  def nextLight = "The next is Green2"
}
case object Green2 extends trafficLight2 {
  def nextLight = "The next is Red2"
}

// The take away point is all about trait extension (adding methods in a trait in a effective way)
