package Collections

import scala.collection.immutable._
object ListClass extends App{
  
  val list = List(30,15,10,2,1,28,98,103,21)
  println(list)
  println("")
  println(isort(list))
  println(isort2(list))

  
  // Insertion Sort : Basic and Easy Sort
  // Idea is to insert an item into a sequence which is partially sorted into its appropriate spot.
  // But this can be achieved in any way
  
  // Important : Watch these method carefully
 
  def isort(xs:List[Int]) :List[Int] = {
    if (xs.isEmpty) Nil
    else
      insert(xs.head , isort(xs.tail))
  }
  
  // Insert an item in its appropriate spot within a sequence which is sorted already
  def insert(x :Int , xs : List[Int]) :List[Int] = {
     if (xs.isEmpty || x <= xs.head ) x :: xs
     else xs.head :: insert(x , xs.tail)
  }
  
  
  // Below redefines the above two methods using "Pattern Matching"
  def isort2(xs :List[Int]) :List[Int] = xs match{
    case List() => List()
    case x :: xs =>  insert2(x , isort2(xs))
  }  

  def insert2(x:Int , xs:List[Int]) :List[Int] = xs match{
    case List()  => List(x)
    case y :: ys => if ( x <= y) x :: xs else y :: insert(x,ys) 
  }
  
}


