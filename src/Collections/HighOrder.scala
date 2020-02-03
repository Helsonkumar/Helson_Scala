package Collections

object HighOrder extends App{
  
  val list  = List(22,33,52,12,78,432,7,98)
  
  //map : Simply T => U
  println(list map (x => x + 2))
  
  //flatMap : takes a function which converts the elements to List Type (T => List[T])
  // And then concatenate the result of each mapped result  into a final List
  println(list flatMap (x => List(x,x+1)))
  
  println(List.range(1,5) flatMap ( i => List.range(1,i) map (j => (j,i))))
 
    
  //foreach : Takes a procedure (function witn Unit as result type)
  //No list of result is assembled
  var sum = 0
  list foreach (sum += _)
  println(sum)
  
  
  //filter
  println(list filter (_ > 50))
  
  
  //partition : Tuple of 2 list with one list with satisfying predicate and other with non-satisfying
  println(list partition (_ > 30))
  
  //find : finds the first element which satisfies the predicate : Gives the Option output
  println(list find (_ > 100))
  
  
  //takeWhile : takes the elements until the predicate is satisfied
  println(list takeWhile ( _ > 20))
  
  //dropWhile : drops the elements until the predicate is satisfied
  println(list dropWhile ( _ > 20))
  
  //span : combines takeWhile and dropWhile operation together
  println(list span (_ > 20))
  
  
  //forall : checks if all elements in the list satisfies the given predicate. 
  //exists : returns true if there is alteast one element which satisfies the given predicate
  //Checks if there is atleast one row with all zeros in a 2D list
  def function(x :List[List[Int]])  = x exists (_ forall (_ == 0))
     
  
  val list2D = List(List(1,2,3),List(4,5,6), List(0,0,0) , List(7,8,9))
  println(function(list2D))
  
  
  
  //foldLeft : " /: "
  // (z /: xs ) (op)
  // z : Identity or initial value
  // xs : List of elements
  // op : operation to be applied on the elements of the list
  //eg : (z /: List(a,b,c)) ( _  + _ ) equals (op(op(op(z,a),b),c))
  val total = (1 /: list) ( _  + _ )
  println(total)
  
  
  //foldRight : " :\ "
  // (List(a, b, c) :\ z) (op) equals op(a, op(b, op(c, z)))
  val str_list  = List("this" ,"is", "wild" ,"world")
  
  val right_flat = (str_list :\ "") ( _ + " : " + _ )
  println(right_flat)
  
  val left_flat = ("" /: str_list) ( _ + " : "  + _ )
  println(left_flat)
  
  
  //some more example : Think of flatten operation on list[list]
  //Note : The identity element is of the same type of the list elements
  def flattenLeft[T](xs : List[List[T]]) = {
    (List[T]() /: xs ) ( _ ::: _ )
  }
  
  def flattenRight[T](xs :List[List[T]]) = {
    (xs :\ List[T]()) ( _ ::: _ )
  }
  
  println(flattenLeft(list2D))
  println(flattenRight(list2D))
  
  //We have Equivalent foldLeft and foleRight methods in List
  println(list.foldLeft(1)(_+_))
  println(list.foldRight(2)(_+_))
  
  
  // Implementation of Reversal of List using foldLeft
  // Watch the implementation : Key is to decide the Initial value and the Operation to be applied
  // Here we have used List[T]() instead of List()  or Nil : Due to type inference does not work here
  // Time Complexity  : Linear (:: is applied for n times . n =  no of List elements)
  // :: takes conatant time
  
 def reverseLeft[T](xs:List[T]) :List[T] = {
    (List[T]() /: xs) {(ys,y) => y :: ys}
  }
  
  println(reverseLeft(list))
  
  // In the below implementation of the reverse List the complexity is Quadratic
  // Note : init and last takes time proportional to the length of  List
  //        head and tail take constant time
  // Since we call the last on the given list for n time proportional to list elements it makes
  // complexity n * n = 2 ^ n
  def rev(xs:List[Int]) : List[Int] = xs match {
    case List()    => Nil
    case List(x)   => xs 
    case (x :: ys) => ys.last :: rev(x :: ys.init)
  }
  println(rev(list))
  
  
  
  // Sorting List
  // list sortWith comparator
  // Understand the comparator operator used here
   println(list sortWith ( _ > _ ))
   println(str_list sortWith ( _.length > _.length))
  
  
  
  
  
}