package FP


//** Experiments various list functions

object ListClass {

  val list1 = List(1,2,3,4,5)
  val list2 = List(6,7,8,9,10)

  def main(args: Array[String]) : Unit =  {

    //* ::
    println(25::list1)

    //* :::
    println(list1 ::: list2)

    //* reverse
    println(list1.reverse)

    //* reverse_:::
    println(list1.reverse_:::(list2))

    //* prepend
    println(45+:list1)

    //* prependall
    println(list1++:list2)

    //* append
    println(list1:+45)

    //* concat
    println(list1++List(34,45,36))

    //* addString : Formats the list while printing
    println(list1.addString(new StringBuilder() , "ListClass(", "*" ,")"))

    //* andThen  : treats list as a partital function
    val list3  = list1.andThen(x => x*2)
    println(list3(3))

    val x:HelOption[Int] = Some(5)
    println(x)


  }


}
