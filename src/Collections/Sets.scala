package Collections
import scala.math.Ordering
import scala.util.Sorting
import scala.collection.immutable._
//This is to show the demo that how the Set are handled in Scala
// Sets contains non-duplicate elements .
// No methods to replace elements in Set
// Mutable : HashTable        Immutable : Object (if n < 4) else Hash Tries

object Sets extends App{
  
  val set  = Set("Apple", "Mango" , "Orange","Willow" ,"Helson" ,"Bananna" ,"Cool" ,"Chill" ,"Cool")
  val set2 = Set("Helson", "Naveena", "Assberry")
  
  //Immutable Methods : Hash Tries or Object implementation
  // Similar methods for remove is also there -, --
  println(set2 + "Melinda")
  println(set2 + ("Jilla", "Milan"))
  println(set ++ set2)
  println(Set empty)
  
  println(set contains "Jira")
  println(set intersect set2)
  println(set union set2)
  println(set2 diff set)
  
  //Mutable : HashTable
  val mset  = scala.collection.mutable.Set("Apple", "Mango" , "Orange","Willow" ,"Helson" ,"Bananna" ,"Cool" ,"Chill" ,"Cool")
  mset += "Guru"
  mset += ("h","j","k")
  mset ++= set2
  println(mset)
  
  println(mset add ("Love"))
  println(mset)
  println(mset remove ("Love1"))

  //Retains only the items satifying the condition. This is filter in place)
  /*mset retain (x => x == "Apple")
  println(mset)*/
  
  
  //Adds and removes the items based on the flag
  println(mset("Kevin") = true)
  println(mset)
  println(mset("Kevin") = false)
  println(mset)
 
  //Subset  :
  println(Set("Helson","Naveena") subsetOf (mset))
  
  
  // Sub Traits  : SortedSet and BitSet
  // Immutable SortedSet   : Immutable TreeSet (implemented with RedBalck Tree to maintain the balance and Order)
  //Ordering companion object has Sorting rules for Primitives. By default these are used
  
  // Sorting based on sub elements in the collection : Here we are sorting Array
  //This shows how to use the Ordering directly 
  //Ordering instance is created by extending Ordering[T] and providing implementation of the abstract compare method of the Ordering Trait 
  val pairs = Array(("a", 5, 2), ("c", 1, 5), ("c", 1, 3))
  Sorting.quickSort(pairs)(Ordering.by[(String,Int,Int), Int](_._3))
  for(x <- pairs) println(x)
  Sorting.quickSort(pairs)
  for(x <- pairs) println(x)
  
  //or
  //Sorting on one and then on another element
  
  Sorting.quickSort(pairs)(Ordering[(String, Int)].on(x => (x._1 , x._2)))
  //for(x <- pairs) println(x)
  
  //Usage of ordering trait to sort Set
  // scala.util.Sorting class is used to sort arrays and sequence and not list
  // the ordering trait must be given to the set while  creating it and it cannot be applied after creating the Set
  
  //This uses the natural ordering of the element to Sort
  var treeset1  = TreeSet("elson", "Ac", "Bala" , "Adam", "Kevin")
  treeset1 += "Arun"
  println(treeset1)
  
  
  //This uses the natural ordering in reverse order
  var treeset2  = TreeSet("eelson", "Ac", "Bala" , "Adam", "Kevin")(Ordering[String].reverse)
  treeset2 += "Arun"
  println(treeset2)
  
  
  //Multiple Ordering
  // Shows how to sort the given collection with its sub elements using Ordering trait
  //We define a Ordering object and have the compare function do multiple ordering
  //Note  : We ascendingly order the second element first and then descendingly order on first element
  //***** The order of elements passed into the Compare method does matter****
  object multiOrder1 extends Ordering[Tuple3[String,Int,Int]] {
    override def compare (i : Tuple3[String,Int,Int] , j : Tuple3[String,Int,Int]) :Int = {
      val x =  i._2 compare j._2
      if (x != 0) x else (j._1 compare i._1)
    }
  }
  
  //We can pass multiple sorting order for Sequence but not for SortedSets
  var treeset3  = TreeSet(("Helson",32,1),("Naveena",30,1),("Melinda",2,2),("Ju",30,2),("Jose",60,1))(multiOrder1)
  println(treeset3)
  
  
  
  
  
  
  
  
   
  
  
  
  
  
  
  
  
  
  
  
}