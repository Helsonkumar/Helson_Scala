package Collections.Immutable.Seq.LinearSeq

import scala.collection.mutable.ListBuffer;

// Demo to show the implementation of Concatenation method in List

// Imp Note : List are constructed from Back towards Front
// So Nil is the first element of list and the later appends are from back towards front

// Most of the algorithm over list uses "Divide & Conquer" technique

// Divide  : First decide the shape go the desired output . So split the input into multiple cases using pattern match
// Conquer :Construct part of the output calling the same method recursively
object ListMethods extends App{
  
  val list1 =  List(10,20,3,45,"Helson",67,1,1,49)
  
  val list2 = 29 :: 30 :: 46 :: Nil
  
  val ConcatList  = list1 ::: list2
  
  println(ConcatList)
  
  val fruit = List("Apple", "Orange", "Mango")
  
  
  //Init and Last : takes O(n) time : n -> number of elements in the input list
  println(ConcatList.last)
  println(ConcatList.init)
  println(ConcatList.head)
  println(ConcatList.tail)
  println(ConcatList.reverse) 
  println(ConcatList.take(5))
  println(ConcatList.drop(5))
  println(ConcatList.splitAt(5))
  println(ConcatList(3))
  println(ConcatList.indices)
  
  //This works only on List of List elements
  println(fruit.map(_.toCharArray).flatten)
  
  //zip : Like Zip in Python : Takes 2 list an gives list of pairs
  println(ConcatList.indices zip ConcatList)
  
  //zipWithIndex
  println(ConcatList.zipWithIndex)
  
  //zip with Range gives Vector : Zip with List gives List of Tuple elements
  println(List("H","e","l","s","o","n") zip List(1,2,3,4,5,6))
  
  // List of Tuples can be changed to Tuple of List elements using UNZIP
  println((List("H","e","l","s","o","n") zip List(1,2,3,4,5,6)).unzip)
  
  // Custom way to print a List
  println(ConcatList mkString ("{", " : " ,"}"))
  
  println(ConcatList.toArray)
  
  println(ConcatList.toArray.toList)
  
  val Array1 = new Array[Int](6)
  val helson = List(1,2,3,4,5,6)
  helson copyToArray(Array1 ,0)
  println(Array1)
  
  
  //Iterator
  val itr  = ConcatList.iterator
  println(itr.next)
  
  //List of Range : Static method
  println(List.range(1,19))
  //This gives empty List
  println(List.range(1,1))
  
  println(List.range(1,10,3))
  
  println(List.fill(5)("a"))
  println(List.fill(2,3)("x"))
  
  println(List.tabulate(5)(_ + 2))
  println(List.tabulate(5,5)(_ *  _))
  
  //zipped version for multiple lists : This acts on the Tuple of List
  println((List("Helson","Naveena","Melinda") ,List(6,7,7,6)).zipped.forall( _.length == _))
  println((List(3,4,5), List(31,41,6)).zipped.exists( _ == _))
  
  
  
  
  
  //Range : includes the first but excludes the last
  println(List.range(3,10))
  
  
  //Exclusive
  for (x <- 3 until 10) println(x)
  
  //Inclusive :
  for (x <- 3 to 10) println(x)
  
  //For mismatched count the extras are ignored
  val listx = List(1,2,3)
  val ran = List(5,6,4,5)
  
  println(listx zip ran)
  
  // Implementation of concatenation
  // :::  (ie list1 ::: list2) on list takes time proportional to the no of elements in list1
  def concat(xs:List[Int] , ys:List[Int]) : List[Int] = xs match {
    case List() => ys
    case x :: xs1 => x :: concat(xs1 , ys)
  }
  
  //Implementation of reverse
  def rever(xs :List[Int]) : List[Int] = xs match {
    case List() => Nil
    case x :: xs1 => rever(xs1) ::: List(x)
  }
  
  
  // Increment the list elements : Efficient way
  // Use ListBuffer[T]. Listbuffer is used to accumulate the list elements into the buffer
  // We use += for this and then finally covert the buffer into list using toList method
  // Note : += and toList takes constant time irrespective of the length of the input list
  val list = List.range(1,11)
  val buff = new ListBuffer[Int]
  for (x <- list) buff += x * 2
  val incr_list = buff.toList
  println(incr_list)
  
  // List methods in general avoid recursion and use Loops instead.
  // Recursion of the method are not tail recursive and thus incur SatckOverFlow error
  // So watch carefully, to use loops in list instead of recursion whilst handling List as follows
  // So when you use loops think of using ListBuffers
   
  // This how map function in List class is implemented
  //Watch this method carefully. 
  //We get an idea about how to implement map function within the List object itself
  //Key #1 : How to iterate on List object itself. (create a separate reference "these" for current object) 
  //Key #2 : Keep mapping the element until iteration ends.
  //         Iteration ends when we hit Nil (List()). For Nil : isEmpty = true
  //Key #3 : Reset the these reference when an element is mapped
  /*def map[U](f : T => U) : List[U] = {
    var buff =  new ListBuffer[U]
    var these =  this
    while(!(these.isEmpty)) {
      buff += f(these.head)
      these = these.tail
    }
    buff.toList
  }
  */
  
  
  //List can be constructed by adding elements before using ::
  //(or) by adding elements at the end using ListBuffers
  val buff1 = new ListBuffer[Int]
  for (x <- list) buff1 += x
  println(buff1.toList)
  
  
  
  
  
  
  
}