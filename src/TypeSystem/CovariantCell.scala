

package TypeSystem

object CovariantCell extends App{
  
  
  // The below code throws error as follows if field current is a mutable var.
  // Mutable fields makes the type unsound
  
  // General rule : A type parameter of a class or trait should not be a type of a method's parameter
  
  // Other words, there should not be any method within a class or trait with type parameter T
  // with a function that takes T as one of its method parameter type
  
  
  // Look below set method  : Type parameter T is used as method Parameter type.
  // This voilates the covariant rule
  // So overcome this we have made the method set as polymorphic by making T as lower bound to U
  // We always have to create a new Object of the polymorphic type and return that
  // Since we cannot change the type of an object which is already created.
  
  //*********** Type Checker Rules**************************************************************
  // 1. A Covariant type parameter should not appear as argument type of any method within the class or trait
  //    If that occurs make polymorphic using the LOWER BOUND
  //
  // 2. There should not be any Reassignment field with Covariant Type as its Type
  //    if so, then make that variable as object Private using Private[this] modifier
  // eg : var sample => would throw error if that is not private[this]
  //    private[this] modifier makes that Object Private
  //********************************************************************************************
  class Cell[+T](init:T) {
    private[this]  var current = init  
    private[this]  var sample = init
    def get = current
    // Here we do 2 changes :
    // 1. Using Lower bound and change the type of returned cell as U
    // 2. Making x type as U (But we can still pass T since Super and Sub types are reflexive
    // ie. A Type is both Super type and subtype by itself). 
    // So we can add only elements whose super class is U
    def set[U >: T](x:U) = new Cell[U](x)
  }
  
  
  val cell_int = new Cell[Int](10)
  val cell_string:Cell[Any] = cell_int
  val cell_with_insert = cell_string.set("Helson")
  println(cell_with_insert.getClass)
  

  
}