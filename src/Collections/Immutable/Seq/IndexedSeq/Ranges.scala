package Collections.Immutable.Seq.IndexedSeq

object Ranges extends App{
  
  //Range inclusive
  val r1 = 1 to 5
  println(r1)
  
  val r2 = 5 to 20 by 4
  println(r2)
  
  //Range exclusive
  val r3 = 10 until 20
  for (t <- r3) println(t)
}