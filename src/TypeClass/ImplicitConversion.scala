package TypeClass


// This is a demo to show the usuage of Implicit Conversion Pattern
// We have seen Type Enrichment(using Implicit Class) and Type Class(by defining implicit values and have them used as implicit parameters to type class interface)
// Implicit Conversion is the third pattern
// But its usage is highly discouraged.

// Implicit conversion pattern is used to convert one type to another type.

object ImplicitConversion {
   
  // Here the Type A does not have a method called adder. So we have used Implicit convcerion to convert A to B and call method adder from B
  // So this pattern needs a single argument method with implicit keyword as follows
  
  implicit def AtoB(inp :A) =  new B(20)
  
  // The idea is all about do Type Enrichment : So always try to use Type Enrichment pattern instead of implicit conversion
  new A().adder
}

class B (x:Int) {
  def adder= x + 20
}

class A

