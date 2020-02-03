
// This is a demo to show the usage of Case Sequence : Which is a sequence of Case Statements
// A case sequence can be replaced in a place where a function literal is expected
// Function Type : val x: String => Int 
// denotes that x is of type function which takes a String param and returns an Int

package PatternCaseClass

object CaseSequence extends App{
  
  // Here sequence of cases are passed in place where a function type(literal) is expected
  //Here we have not used the ""match"" clause
  
  // Partial Function : A partial function is the one which is not fully defined
  // Or the fone with not all cases covered for the evaluated type
  val receive: Any => Unit = {
    case "Helson" => println("Helson is good")
    case (10, 20) => println("He is great")
    case _ => println("No value is given")
  }
  
  def readmsg(func : Any => Unit, x:Any) = {
    func(x)
  }
  
  
  // This is a partial function and not all possible cases are covered
  // this is translated into an object with "isDefinedAt" Method
  val partialFunction : PartialFunction[List[Int],Int] = {
    case List(x) => x 
    case x :: xs => x + x
  }
  
  //Returns false since such case is not covered
  println(partialFunction.isDefinedAt(Nil))
  
  // Returns True since such cases is covered
  println(partialFunction.isDefinedAt(List(9)))
  
  //Here all possible cases of a list is covered
  // If some cases are not covered then compiler would give you some warning
  val noPartialFunction : List[Int] => Int = {
    case List(x) => x 
    case x :: xs => x + x
    case Nil => 0 
  }
  
  readmsg(receive,(10, 20) )
  
  
  //Example of variable pattern
  val input = ("Helson", 43, Nil)
  val (x, y, z) = input
  println(y)
  
  
  //Example of Map value Pattern
  val capital = Map("India" -> "Delhi" , "Russia" -> "Moscow" , "USA" -> "Washington")
   for ((country, caps) <-  capital) println(caps)
   
   //Important
   //Example of : Discard the value when it does not match the pattern given
   //See here since "None" does not match the pattern Some(x) : they are discarded
    val fruits:List[Option[String]] = List(Some("Banana"), None, Some("Orange"), None)
    for(Some(x) <- fruits) println(x)
    
    
    for (x <- 0 to 10) println(x)
}


