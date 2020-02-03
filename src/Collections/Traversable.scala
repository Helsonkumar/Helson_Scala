package Collections

//This is a demo to experiment all the common methods of a collection type.
//These methods are inherited from Traversable trait. This trait is not resurfaced from Scala 2.13
object Traversable extends App {

  val list1 = List(1,3,5,7,9,11,13,15)
  val list2 = List(2,4,6,8,10,12,14,16)
  val list_any = List(1,"Helson", 2, "Gladys", 3, "Naveena", 4 , 5, "Melinda")
  val empty_array = new Array[Int](20)
 
  
  //***********************************************************************************************
  //xs foreach f
  //Simply takes a function and apply it to the given collection. The return value of the function is ignored by foreach
  list1.foreach(println)

  //xs ++ ys
  val list3 = list1 ++ list2
  println(list3)
  
  //xs map f
  println(list1 map (_ * 2))
  
  //xs flatMap f
  println(list1 flatMap (x => List(x, x+3)))
  
  //xs collect f : f must be partial function
  // Partial function : is a case sequence with not all possible cases covered
  //Here we have not covered the Int values in the given list
  list_any collect{case x:String => x + 90}

  //***********************************************************************************************
  //Converison
  println(list1.toList)
  println(list1.toArray)
  println(list1.toSet)
  println(list1.toIndexedSeq)
  println(list1.toSet)
  println(list1.toIterable)
  println(list1.toStream)
  //println(list1.toMap)
  
  //***********************************************************************************************
  
  //Copying
  //copytoBuffer
  list1.copyToArray(empty_array,0,3)
  println(empty_array)
  
  //***********************************************************************************************
  //sizeInfo
  //xs.isEmpty / xs.nonEmpty / xs.size / xs.hasDefiniteSize
  println(list1.toStream hasDefiniteSize)
  
  //***********************************************************************************************
  //Element Retrieval
  //xs.head / xs.headOption / xs.last / xs.lastOption /  xs find (prdicate)
  println(list1 head)
  println(empty_array headOption)
  println(list1 find (_ > 10))
  
  //***********************************************************************************************
  //SubCollection
  //xs.tail/ xs.init / xs slice (from , to) / xs take n / xs drop n / xs takeWhile p
  // xs dropWhile p / xs filter p /
  // xs withFilter p  : subsequent call to map or flatmap etc will apply function only to the filtered items
  val helson = list1 withFilter (_ > 10) map (println)
  println(helson)
  
  //filterNot p
  println(list1 filterNot (_ > 12))
  
  //***********************************************************************************************
  //Subdivision
  //splitAt n / partition p / span p (xs takeWhile p) (xs dropWhile p) / xs groupBy f
  println(list1 splitAt 3)
  println(list1 span (_ % 3 == 0))
  println(list1 dropWhile (_ % 1 == 3))
  println(list1 partition (_ % 3 == 0))
  
  val func1 : Any => Boolean =  {
    case i:Int => true
    case i:String => false
  }
  
  println(list_any groupBy (func1))
  
  //***********************************************************************************************
  //Element Condition
  //xs count p / xs forall p / xs exists p
  println(list1 count ( _ > 10))
  println(list1 forall (_ % 2 == 0))
  println(list1 exists ( _ % 2 == 0))
  
  //***********************************************************************************************
  
  //Folds
  //FoldLeft
  println((1 /: list1)(_ + _ + 2))
  println(list1.foldLeft(1)(_ + _ + 2))
  
  //FoldRight
  println((list1 :\ 1) (_ +_+ 2))
  println(list1.foldRight(1)(_+_+2))
  
  //reduceLeft
  println(list1 reduceLeft (_ + _ + 2))

  //reduceRight
  println(list1 reduceRight ( _ + _ + 2))
  
  
  //Specific Folds
  //xs.sum / xs.product / xs.min / xs.max
  println(list1 sum)
  println(list1 product)
  println(list1 min)
  println(list1 max)
  
  
  //Strings
  println(list1.stringPrefix)
  println(list1 mkString ("[", " : " , "]"))
  
  
  //Views
  println(list1 view)
  list1 view (3,5) map (println)
  println(list1 view (3, 5))
  
  //sortWith
  val sort_list  = List(3,1,6,32,12,34,2,3,14)
  println(sort_list sortWith(_ > _))
  println(sort_list)
  
  
  
  
  
  
  
}