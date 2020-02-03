
// This is a demo to show that a private memeber is accessible only with the class scope
// Also it can be accessed by the instance of the same type.
// Private var in Human1 is accessed by the Human2, since both are of same type.

// Note:
// If you want to restrict it then use private[this] : This will not let the private member of be access by another member of the same class type

// Generally : Private members can be accessed by the companion object  or class
// private[this]  : also restricts this value to be accessed by its companion class

object PrivateModifier extends App{
  
  class Human(x: Int) {
    //private[this] var age : Int = x
    private  var age : Int = x
    var age_mixed = 0
    def mixing(h :Human) = {
       //age +=  h.age
       age_mixed = h.age
    }
    
  }
  
  
  
  
  val human1 = new Human(10)
  val human2 = new Human(20)
  human2.mixing(human1)

  println(human2.age_mixed)
  
}