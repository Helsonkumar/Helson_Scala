package TypeClass



final case class Order(units :Int , unitPrice :Double ) {
  val totalPrice = units * unitPrice
}

object Order {
   implicit val totalPriceOrdering =  Ordering.fromLessThan[Order]{(x,y) => x.totalPrice < y.totalPrice}   
}