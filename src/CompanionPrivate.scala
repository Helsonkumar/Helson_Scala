
//This demo is to show how private members from a companion items are accessible

// A companion class or object can access their private member interchangeably

object CompanionPrivate extends App{
  
  CompanionPrivateClass.objectFunction
  
}


class CompanionPrivateClass {
    
  private var className  = "helson"
  
  private var title = "Mr."
  
  private def classFunction = {
       CompanionPrivateClass.supportFunction + CompanionPrivateClass.objectName + className
  }
}


object CompanionPrivateClass {
  
// Private[This] would not expose this member to other instance of the same type to which this memebr belong  
//  private[this] var objectName = "KumarObj"
  private var objectName = "Kumar"
  
  private def supportFunction = s"hi"
  
  def objectFunction = println(new CompanionPrivateClass().title + new CompanionPrivateClass().classFunction)
  
}