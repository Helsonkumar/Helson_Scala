package Cats

import cats.Monoid
import cats.Semigroup
import cats.implicits._

//This is a demo show the use of Monoid of a Type.
//Informally a Monoid is a type class with 2 functions. (Combine and Empty)
//** Combine((A,A) => A)  : Must satisfy the Associative Law
//   (a + b) + c = a + (b + c)
// Any associative operation can be parallelized. So they can execute as independent unit of work

//** Empty : A : Must satisfy Identity Law
// id + A = A + id


case class People(name: String, age: Int)

object PeopleMonoid {
  implicit val monoidPeople: Monoid[People] = new Monoid[People] {
    def combine(x: People, y: People): People = People(x.name |+| y.name, x.age |+| y.age)
    def empty: People = People("", 0)
  }
}

object PeopleApp extends App {
  val people1 = People("Helson", 32)
  val people2 = People("Naveena", 30)
  val people3 = People("Melinda", 2)
  val people4 = People("Gladys", 36)
  val people5 = People("aachi", 67)
  
  import PeopleMonoid._
  println(List(people1,people2,people3,people4,people5).foldLeft(Monoid[People].empty)(Monoid[People].combine)) 
  //or
  println(List(people1,people2,people3,people4,people5).combineAll)
}
