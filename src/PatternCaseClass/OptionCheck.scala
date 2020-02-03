
// Options are used to overcome the null check in Scala
// Some(x) or None => Possible values within a Option Container
package PatternCaseClass

object OptionCheck extends App{
  
  val capital = Map("TN" -> "Chennai" , "KN" -> "Blore", "KL" -> "Trivandrum")
 
  function(capital get "TN")
  
  
  // We cannot display None => None simply means a non-existing value
  val x1  = null
  val x :Option[String] = None
  x.toString
  
  //Will throw Null Pointer Exception
  //x1.toString
  
  def function(x:Option[String]) = x match {
    case Some(s) => println(s)
    case None => println("Key not found")
  }
  
}