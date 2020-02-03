

object Expression_Oriented1 extends App {
  
  def exp_type_pgm(x : Int) = x match {
    case 1 => "Network failure"
    case 2 => "this is awesome"
    case 3 => "This is Non-sense"
    case _ => "This is Nothing"  
  }
  
  println(exp_type_pgm(7))
  
  val x = new Vector2D(1.0, 1.0)
  val y = new Vector2D(-1.0, 1.0)
  
 // x.magnify(3.0) - (x - y).magnify(3.0)
  
  
  
  
  
}


class Vector2D(var x : Double , var y : Double){
  def magnify(u :Int): Vector2D ={
    x * u
    y * u
    this
  }
}