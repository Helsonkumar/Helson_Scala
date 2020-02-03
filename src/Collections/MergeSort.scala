package Collections

//Demo of MergeSort : nlog(n)
// Split the input List into 2 and then sort the splitted array and merge them together
// Tips : For algorithms which needs comparison of elements we need a comparator
// e.g Max, Min , Sort : all needs a compartor
object MergeSort extends App {
  def msort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
    def merge(xs: List[T], ys: List[T]): List[T] =
      (xs, ys) match {
        case (Nil, _) => ys
        case (_, Nil) => xs
        case (x :: xs1, y :: ys1) =>
          if (less(x, y)) x :: merge(xs1, ys)
          else y :: merge(xs, ys1)
      }
    val n = xs.length / 2
    if (n == 0) xs
    else {
      val (ys, zs) = xs splitAt n
      merge(msort(less)(ys), msort(less)(zs))
    }
  }
  val list1 = List(23, 12, 2, 11, 1, 674, 231, 21, 228)
  println(msort((x: Int, y: Int) => x < y)(list1))
  
  //The above method is perfect match for Currying
  //Note  : We have not used the List parameter
  //But we had passed a different (reverse order)function type alone as parameter . 
  //Watch  " _ " as param in place of List
  //So the behavior of the code is changed during the runtime by passing different function type
  
  //So think of passing in different way to Order elements in the list
  //The outer fucntion can be used to change the behaviour we need 
  val ReverseSort = msort((x: Int, y: Int) => x > y)_
  println(ReverseSort(list1))  
  val StringOrder = msort((x:String , y :String) => x(4) < y(4)) _
  val String_List = List("Helson", "Gladys", "Naveena" ,  "Melinda")
  println(StringOrder(String_List))
}
   