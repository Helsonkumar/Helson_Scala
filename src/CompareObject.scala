
// This program shows the usage of compare interface
// Here we use Ordered[T] trait to inherit the methods for comparing objects
// Compare is different than equal.
// Remember  : Java's Comparable interface

// Noet : We have 2 Traits for ordering:
// Ordered[T]  : Like Java Comparable interface : Gives a sinlge way to order element in the collection 
//               Gives the natural ordering
// Ordering[T] : Like Java Comparator interface : Gives multiple ways to order elements in the collection
//               Generally used when we dont have access to the class file of the type
 //               Java : Collection.sort(arr, new comparator[T](T x , T y){ compareTo(x,y)}) 



// How to implement the Ordered trait and sort an array of objects
// 
object CompareObject {
  
  def main(args : Array[String]): Unit = {
    
     val OrderedClass1 = new OrderedClass(10,10)
     val OrderedClass2 = new OrderedClass(40,20)
     val OrderedClass3 = new OrderedClass(70,30)
     val OrderedClass4 = new OrderedClass(30,40)
     val OrderedClass5 = new OrderedClass(80,50)
     val OrderedClass6 = new OrderedClass(5,10)
     val OrderedClass7 = new OrderedClass(50,80)
     val OrderedClass8 = new OrderedClass(50,80)
     
     val compArray = Array(OrderedClass1,OrderedClass2,OrderedClass3,OrderedClass4,OrderedClass5,OrderedClass6,OrderedClass7,
                            OrderedClass8) 
                            
     
     
     //Sorting based on natural oder (Ordered Trait)                       
     //scala.util.Sorting.quickSort(compArray)
     
     
     //Sorting based on Custom Ordering (Ordering Trait)
     scala.util.Sorting.quickSort(compArray)(CustomOrder2)
     
     // Reversed Order Trait
     scala.util.Sorting.quickSort(compArray)(CustomOrder2.reverse)
     
     
     //Sorting based on the member variable . This simply overrides the natural ordering defined in T
     // If both y are equal then sort based on the value of x
     scala.util.Sorting.quickSort(compArray)(Ordering[(Int, Int)].on(x => (x.y, x.x)))
     
//     /println(CustomOrder1.equiv(OrderedClass8, OrderedClass7))
     
     for(items <- compArray)
       println(items)
                            
     /*println(">" +  (OrderedClass1 > OrderedClass2))
     println("<" +  (OrderedClass1 < OrderedClass2))
     println(">=" + (OrderedClass1 >= OrderedClass2))
     println("<=" + (OrderedClass1 <= OrderedClass2))
     println("==" + (OrderedClass1 == OrderedClass2))*/
     
}
}

// Ordered Trait usage
// Ordered trait uses the compare method to define the  <, >, = , <= ,>= methods
// Gives the natural ordering
class OrderedClass(val x : Int , val y : Int) extends Ordered[OrderedClass]{
   override def compare(that: OrderedClass) : Int  = {
     (this.x - that.x) + (this.y - that.y)
   }
   
   override def toString(): String = s"[ ${this.x} , ${this.y} ]"
  
}


// Ordering is basically used for custom ordering.
// Like Ordered traits  : Ordering Trait has lot of concrete methods for equiv, gt, lt,etc
// Each of these concrete methods depend on abstract compare method
object CustomOrder1 extends Ordering[OrderedClass] {
    def compare(x : OrderedClass , y: OrderedClass) =  x.x - y.x
}

object CustomOrder2 extends Ordering[OrderedClass]  {
  def compare(x: OrderedClass , y : OrderedClass) = x.y - y.y
}



