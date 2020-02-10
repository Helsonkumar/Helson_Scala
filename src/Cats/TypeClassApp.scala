package Cats

// The TypeClass instances are auto imported since we have declared them  within the companion object of the TypeClass
//import JsonWriterInstances._

object TypeClassApp {
  def main(args: Array[String]): Unit = {

    // Usage of TypeClass Interface Object
    println(JsonObject.toJson(Person("Helson", "helsonkuamr@gmail.com")))

    //Usage of TypeClass Syntax
    //Here we simply pass in the vale of Type A and compiler auto detects the implicits
    //Simply import the Object which contains the Implicit class which holds the "toJson" method
    //Note : It feels like we are extending the existing types (like Person) with new functionality(methods) though
    //it is not obviously defined in the Person class.
    //Traditionally this is acheived by extending the Person class with Interface. But Scala does this with Implicits
    //This is very powerful feature of scala
    import JsonSyntax._
    println(Person("Naveena", "naveena@yahoo.com").toJson)

  }
}

