
package TypeSystem

object MaxInList extends App{
  
  val maxList =  List(23,67,89,102,10,1,83,12)
  val nilList = Nil
//  val ordering = new Ordering[Int] {
//    override def compare(x :Int , y :Int) = {
//      x compare y
//    }
//  }
  
  println(maxInList(maxList)) 
  
// This is a demo to show how to find a maximum element from a given List
// To find maximum element we need to do comparison of items in the List
// The idea is to use the Ordering Trait defined in Scala.Math.* (Here is defined as Implicit param - so it is fetched from default imports during the runtime)
  
  def maxInList[T](list : List[T])(implicit ordering :Ordering[T]): T = list match {
    
    // If the list is empty then throw exception
    case Nil => throw new IllegalArgumentException("Empty List is give")
    
    //If the lIst contains only one item then retrun that value as the max value
    case List(x) => x
    
    // For non-empty list : We have composed a function and passed in that 
    // function as parm to the method gt(T,T)
    // Here function is passed in as object as first class citizen.
    // This function is then recursively called
    case ( x :: rest) => {
      val maxInRest = maxInList(rest)(ordering)
      if (ordering.gt(x , maxInRest)) x else maxInRest
    }

  }
  
  def fun2{
	  val list  = List(1,2,35,12,6,712,78)
			  
			  val tuple_list = List(("e","f","g"),("a","b","g"),("x","y","z"),("a","d","c"))
			  val tuple_list_sorted = tuple_list.sorted
			  for (x <- tuple_list_sorted) println(x)
    
  }
  
  
  
  
  // This is a demo to show how a List[Tuple] is sorted.
  // A tuple is an immutable collection of different or similar data types.
  // When we sort a list of tuples of different types , then the natural ordering of each element is identified
  // Here when 2 int of similar value is identified then the next elements natural ordering is identified
  
  // In general, a tuple is used when we need to pass more that one value from a method.
  // Tuple is immutable.
  // Tuple can be replaced with case class when we need the named parameter
  
  // That natural ordering is passed as implicit parameter to the method Sorted called over the tuple
  def fun3{
    
    case class item(a :Int, b :obj1)
    
	  val item2 = new obj1(20,12,"helson2")  
	  val item1 = new obj1(10,11,"helson1")
		val item4 = new obj1(40,14,"helson4")
		val item3 = new obj1(30,13,"helson3") 
									  
    val list_tuple = List((10,item1) , (30,item4) , (20,item2) , (30,item3))
    
    val list_tuple_sorted = list_tuple.sorted
    
    for(x <- list_tuple_sorted) println(s" ${x._1} ${x._2}")
    
  }
  
  class obj1(val x :Int, val y :Int, val z :String) extends Ordered[obj1]{
      override def compare(that: obj1):Int = {this.y - that.y}
      override def toString() = s"${this.x}  and ${this.z}"
    }
  
  
  
}