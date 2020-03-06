package TypeClass

import Ordering._
//This is a demo to show how Type class works.
// Type class helps to define different implementation of a functionality for a type outside the scope of that type (no need to touch the class file off that type)
// E.g we can define different Implementation of Sort functionality for type A in Type class Ordering[A]

// Implicits can be defined for a  *** var,val,object,def(with zero parameter) ****

// Search of Implicits  : Local Scope => Defined within the enclosing class or trait or objects
//                        Outside Scope : Defined within the companion object of the type [A] or objects defined outside the scope of main object

//An object cannot contain more than one TypeClass Instances. If so it gives conflicts on which instances to refer would arise.
//Even in  local scope there cannot be more than one Type Class Instance.

//Priority : The TypeClass instance defined within the local scope would take precedence.

object Implicits extends App {

  val order1 = Order(10, 105)
  val order2 = Order(210, 95)
  val order3 = Order(310, 85)
  val order4 = Order(410, 75)
  val order5 = Order(510, 65)
  val order6 = Order(610, 55)
  val order7 = Order(710, 45)
  val order8 = Order(810, 35)
  val order9 = Order(910, 25)
  val order10 = Order(1010, 15)

  val list1 = List(order10, order1, order9, order8, order6, order4, order3, order1, order5, order4, order2)

  //No local Type Class instance is present so far. Thus the Default TypeClass instance from companion object of the type Order is used.
  println(list1.sorted)

  //Here We have imported an object with a type class instance.
  //By using the name of the type class instance explicitly we have it imported into the local scope
  import UnitOrder._
  println(list1.sorted(orderOnUnit))

  //Here We have imported an object with a type class instance.
  //If the name of the type class instance is not given then the current instance within the local scope (which is orderOnUnit in this case ) is used.
  import UnitPriceOrder._
  println(list1.sorted(orderOnPrice))

}

object UnitOrder {
  implicit val orderOnUnit = Ordering.fromLessThan[Order] { (x, y) => x.units > y.units }
}

object UnitPriceOrder {
  implicit val orderOnPrice = Ordering.fromLessThan[Order] { (x, y) => x.unitPrice < y.unitPrice }
}