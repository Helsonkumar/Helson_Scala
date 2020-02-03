
// This is a demo to show how the SEALED CLASS
// If a class is sealed it can no longer be extendeb by any other subclass which is 
///declared outside the unit where the sealed class is declared


package PatternCaseClass

object SealedClass extends App{
  
  val bird:Bird = Peacock("Peacock")
  
  // NOte: Since the super class is sealed and a default case is missing
  // the compiler auto suggest the missing pattern
  
  bird match {
    case Crow(x) => println("This is Crow")
    //case _ => println("this is default")
  }
  
  // To overcome the warning message we can either add a default or @unchecked annotation
  // This is would suppress the warning message
  // We use unchecked when we know for sure that our object would not be anything other than the 
  // checked types.
  (bird: @unchecked) match {
    case Pigeon(x) => println("This is Pigeon")
    //case _ => println("this is default")
  }
  
}

sealed class Bird(name:String)
case class Peacock(name:String) extends  Bird(name)
case class Crow(name:String) extends  Bird(name)
case class Pigeon(name:String) extends  Bird(name)
