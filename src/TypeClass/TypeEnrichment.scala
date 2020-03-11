package TypeClass

//This is demo to show the "Type Enrichment" pattern (Implicit Class usage).
// So far we have seen implicit values in the form of object, var, val , def .
// But  we can use implicit class to extend or define a new functionality for a type w/o altering the types definition

//W ehave defined an implicit class inside the HtmlifyInstances.
//We can only define an implicit class within another class or another object. Not as a standalone
object TypeEnrichment extends App {

  import HtmlifyInstances._

  // String does not have the method htmlWriterClassMethod.
  // But we have defined it as part of an implicit class which takes a string as constructor variable

  println("Melinda Marian".htmlWriterClassMethod)

}




