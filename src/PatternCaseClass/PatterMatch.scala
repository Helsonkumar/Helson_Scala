
// This is a demo to show various patterns in pattern matching feature

//Key Notes:
// Only Case class can be used for patter matching
// Case to Case inheritance is prohibited (a case class cannot extend another case class)

//**********  We use VALUES and not TYPES in pattern match ******************
package PatternCaseClass

object PatterMatch extends App{

  abstract  class Animal(x:String, y:Int)
  case class Dog(name:String, Age :Int) extends Animal(name,Age)
  
  val d:AnyRef = new Dog("Jillu",10)
  val d_var  = new Dog("Jillu", 10)
  
  d match {
	  //WildCard pattern : '_' denotes any single argument 
    case Dog(_,_) => println("This is wildcard pattern")
    
    //Constant Pattern : literal , constants, Integer, Variable, Objects can be considered for this pattern
    //Check for the back ticks  ``: used to denote a local variable (obj.varname  is also possible)
    // Variables with UpperCase first letter is considered as constants
    case `d_var` => println("10")
    
    // Literal match
    case "Kill" => println("kill")
   
    case List(_,_) => println("This is List or Array pattern")
    
    case (a,b,c) => println("this is $a $b $c : tuple pattern")
    
    case x:Dog => println("this is Typed Pattern to check the type of the object")
    
    case _:Map[_,_] => println("Note we cannot check for the type parameter : Due to Type Erasure")
    
    // This is additional to Variable patten , when a pattern match we can catch them in variable
    case Dog(x @ "Jilla", 10) => println(x)
   
    case _ => println("default")
  }
  
  
  
  //Partial Function;
  // Partial function is the one which does not cover all the possible cases.
  // A case sequence can be replaced in place of a function literal
  // Here all possible case patterns are not validated. ie Nil
  // So this would give us a warning message during compilation
  // So avoid that use the PartialFunction.
  // Each Partial Function is interpreted with "isDefinedAt" method to check if the specific case is evaluated.
  // Without this method check you might get runtime Match Error when a unevaluated case is passed in runtime
  
  //Function to print the second element of the given list
  val fun : List[Int] => Int = {
    case x :: y :: _ => y
  }
  
  val fun_par : PartialFunction[List[Int],Int] = {
    case x :: y :: _ => y
  }
  
  println(fun(List(2,15,7,17)))
  
  
  
}