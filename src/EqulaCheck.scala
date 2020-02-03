

// This is a sample prgram to see how to override the Equals and hashcode methods of an object
// By def : We must implement both the methods if needed
// Objects passing Equals check must have the same hashcode

//**** Scala by default : Checks the object location equality and the hashcode for being equal

//**** if 2 object ref point to the same object of type Point2D thn they are evaluated to AnyRef
// if first encountered in the pattern matching
object EqulaCheck extends App{
  
  val Point1 = new Point2D(1,3)
  val Point2 = new Point2D(1,4)
 
 println(Point2.equals(Point1))
 println(Point1.##)
 println(Point2.##)
  
}

case class Point(var x :Int, var y :Int)

class Point2D(var x :Int , var y:Int) {
  
 def move(i :Int , j :Int):Unit ={
    x =x +i
    y =y +j
  }
  
  override def hashCode:Int = y + (31 * x)
  
  def canEqual(x : Any) :Boolean = x match {
    case a : Point2D => true
    case _ => false
  }
  
  override def equals(that:Any) :Boolean = {
    def strictEquals(other:Point2D) :Boolean = other.x == this.x && other.y == this.y
   
    that match {
      case q : Point => println("this is Point");false
      case a : AnyRef if this eq a => println("this is Anyref");true
      case p : Point2D => println("this is Point2D");(p canEqual this) && strictEquals(p)
      case  _ => false
    }
    
  }
  
  
}