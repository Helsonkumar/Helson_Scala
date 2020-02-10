package Cats


sealed trait Json 
final case class JsString(get:String) extends Json
final case class JsObject(get :Map[String, Json]) extends Json
final case class JsNumber(get : Double) extends Json
case object JsNull extends Json

final case class Person(name:String, email :String)


//This is a demo to show the Type Class and the power of Implicits
// Type class is just a trait with altteast one type parameter some methods defined to be implemented 
// Implicits are defined for : val , def , class
object TypeClass {
  
}

//**************************************************************************************************

//Type Class
trait JsonWriter[A] {
  def write(j :A):Json
}

//Type Class instance
// Implementation of TypeClass with an "Implicit val " is called Type Class Instance
// This can be given in a seperate object with different name or given as part of companion object.
// If it is given as part of companion object then scala automatically import them when the Type Class is referred.
object JsonWriter {
  
  implicit val stringWriter : JsonWriter[String] = new JsonWriter[String] {
    def write(value:String) : Json = {
      JsString(value)
    }
  }
    
  implicit val personWriter : JsonWriter[Person] = new JsonWriter[Person] {
    def write(value:Person) : Json = {
      JsObject(Map("name" -> JsString(value.name),
                   "email" -> JsString(value.email)))
    }
  }
  
}
//**************************************************************************************************


// TypeClass Interface:  This is Interface Object
// It is simply a method which receives a Type Class Instance as an "implicit parameter"
object JsonObject {
  def toJson[A](value:A)(implicit w : JsonWriter[A]):Json = {
    w.write(value)
  }
}

// TypeClass Interface : This is Interface Syntax (another easy to use TypeClass Interface)
// Check out the "implicit class" here.
// This is easy to use. An instance of the implicit class is auto created which extracts all the necessary implicits.
// Check for its usage in the relevant Application.
object JsonSyntax {
  implicit class JsonSyntaxClass[A](value : A) {
    def toJson(implicit w : JsonWriter[A]) : Json = {
      w.write(value)
    }
  }
}
//**************************************************************************************************
