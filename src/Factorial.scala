
object Factorial extends App {
  
  def factorial(n:Int):Int ={
    @annotation.tailrec
    def factIn(accum:Int, x :Int):Int = {
      if(x < 1)
        accum
      else
        factIn(accum * x, x-1)
    }
    factIn(1,n)
  }
  
  println(factorial(4))
  
}