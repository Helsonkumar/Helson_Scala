

package PatternCaseClass

object CaseClass extends App{
  
  abstract class Expr
  case class Var(x:String)  extends Expr
  case class BinOp(op:String , left :Expr, right :Expr) extends Expr
   
  //Notes:
  // No need ot "new" whilst constructing case class
  val x = Var("Helson")
  val y = Var("Helson")
  
  //hashCode, ToString, equals are auto added like other objects
  println(x.hashCode)
  println(y.hashCode)
  
  //Even for different object, if theyr are structrally equal then they have same hashCode 
  //Thus treated equal . 
  //ie "==" always does the structural comparison
  println(x == y)
  
  
  //Whereas in normal class, different objects with same structure are not treated same
  class one[T](x:T)
  
  val one1 = new one(10)
  val one2 = new one(10)
  
  println(one1.hashCode)
  println(one2.hashCode)
  println(one1 == one2)
  
  
  // Implicit Copy  method is added to generate a copy of an object with diff parameters if needed
  val i = BinOp("+", Var("Helson"), Var("Kumar"))
  val j = i.copy(left = Var("Sathish"))
  println()
  println(i)
  println(j)
  println(i.hashCode)
  println(j.hashCode)
  println(i == j)
  
  
  
}

