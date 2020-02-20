package FunctionsClosures

object Closures extends App {

  //A Closure is a function which consist of external variable other than the function parameter itself
  var more = 900
  def closure1 = (x: Int) => x * more

  println(closure1(10))

  more = 50

  println(closure1(10))

  //Look a function returns another function as value
  // Here even though 'p' is the function param it is held in Heap instead of Stack since it is supposed to be retained even after the function execution
  def closure2(p: Int) = (x: Int) => x * p
  val c2 = closure2(30)
  println(c2(4))

}