package TypeSystem

object TypeClass1 extends App{
  
  val list1  = List(3,7,10,20,2)
  val list2  = list1 ::: List(120)
  
  for(x <- list1.reverse) println(x)
  for(x <- list1) println(x)
  
  
}



class SampleQueue1[T](list :List[T]) {
  def head = list.head
  def tail = new SampleQueue1(list.tail)
  def enqueue(x : T):List[T] = list ::: List(x)
}




class FunctionalQueue[T] private (leading :List[T], trailing: List[T]) {
  
  def head:T = ???
  def tail = ???
  def enqueue(x:T) = ???
  
}


