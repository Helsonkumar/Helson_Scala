
// This is a demo to show the object oriented view of Scala

// The class has contructir paramteres like Python directly
//Any statement outside a method 'def' scope is considered as constructor statesments
class Rational(n :Int , d : Int) {
  
  
  //Precondition check : If fails throws illegal Argument exception
  require(d > 0)
  
  //Scala also has Private modifier
  private var g = gcd(n,d)
  
  //The constructor parameters are part of the class declared.
  // But to be referenced by the object instance we need to have them copied to relevant variables
  private var num = n / g
  private var den = d / g
  
  //Auxillary constructor : 
  def this(n : Int) = this(n , 1)
  
  def + (that : Rational) : Rational = {
    new Rational(this.num * that.den + that.num * this.den , this.den * that.den)
  }
  
  def * (that : Rational) : Rational = {
    new Rational(this.num * that.num , this.den * that.den)
  }
  
  //Demo for overloaded method
  def + (x :Int) : Rational = {
    new Rational (this.num + (x * this.den) , this.den) 
  }
  
  def * (x :Int) : Rational = {
    new Rational (this.num * x , this.den) 
  } 
  
  override def toString = s"$num / $den"
  
   def gcd(n: Int , d : Int) : Int = {
    if (d == 0) n else gcd(d, n % d)
  }
}


object RationalRun {
  def main(args : Array[String]) : Unit = {
    val a = new Rational(10,15)
    val b = new Rational(17,21)
    
    println(a + b)
    println( 170 % 21)
  }
}