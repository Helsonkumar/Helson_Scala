package Cats

//import cats._
import cats.Show
//import cats.instances.all._
import cats.instances.int._
import cats.instances.list._
///import scala.collection.immutable.List
//import cats.syntax.all._
import cats.syntax.show._
//import cats.implicits._
//import cats.instances._
import java.util.Date

object ShowEQ extends App {

  // Creating instance of Show TypeClass with A => Int
  val showInt: Show[Int] = Show.apply[Int]
  println(showInt.show(123))

  val showList: Show[List[Int]] = Show.apply[List[Int]]
  println(showList.show(List(1, 2, 3, 4, 928, 22, 10)))

  //The Show is used to define custom print methods for our own type
  //Traditionally we use to do this by getting into the Type and overriding the default toString() method
  //But using cats we can define via function
  /*implicit val showDate : Show[Date] = new Show[Date] {
      def show(value :Date) : String = {
        s"${value.getMonth} ${value.getSeconds}"
      }
    }*/

  //The above method can be otherwise defined
  implicit val showdate2: Show[Date] = Show.show(date => s"${date.getMonth} ${date.getTime}")

  println(showdate2.show(new Date()))

  //********************************* Equals ************************************
  //Normally if we compare objects of different types the compiler would not throw any error
  //Instead we would always get 'false' during the run time.
  //So in order to check if we compare 2 objects of same type for equality we can use cats 'Eq[A]' TypeClass
  import cats.Eq
  import cats.instances.all._
  import cats.syntax.eq._
  val eqInt: Eq[Int] = Eq[Int]
  //Below statement would give error if we try to compre 2 irrelevant types for equality check
  //eqInt.eqv(102,"abc")

  println(eqInt.eqv(2333, 455))

  //Defining Equality check for custom type: For the Eq[A] which is not defined
  final case class Cat(name: String, age: Int)
  val eqCat: Eq[Cat] = Eq.instance((cat1, cat2) => (cat1.name === cat2.name))

  val cat1 = Cat("Helson", 67)
  val cat2 = Cat("Helson", 78)
  println(eqCat.eqv(cat1, cat2))

}