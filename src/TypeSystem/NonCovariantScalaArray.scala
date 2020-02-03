
// This is a demo to show that the Scala Arrays are not covariant by default unlike Java
package TypeSystem

object NonCovariantScalaArray extends App{
  
    val string_array : Array[String]  = Array("helson","Naveena","Melinda")
    
    // The below code not even compile unlike Java where it would throw Runtime error
    //  val any_array: Array[Any] = string_array
    
    // Below line would cast the Array[String] to Array[Any]. So this would skip the Compiler check
    // But , when we set an Integer value to this Array[String] it throws runtime Error
    
    // Even when U cast the same object is mirrored. But no new object is created
    val any_array : Array[Any] = string_array.asInstanceOf[Array[Any]]   
    any_array(1) = 24
    println(any_array.getClass)
    println(string_array.getClass)
    
  
}