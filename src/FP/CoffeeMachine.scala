package FP

object CoffeeMachine {

  def main(args: Array[String]): Unit = {

    val coffees: List[(Coffe, Charge)] = List.fill(10)(makeCoffe(CreditCard("AMEX", 234567102)))

    val final_coffees = coffees ++ List.fill(10)(makeCoffe(CreditCard("VISA", 400053829)))

    //Insted of letting amount to be charged for each coffee , we make those charges one by accumulating all charges for a card
    val (coffees_list, charges_list) = final_coffees unzip
    val total_charge = charges_list.reduce(_.combine(_))

    println("%s %s".format(coffees_list, total_charge.price.amt))

  }


  // makeCoffe is pure fucntion with no side effects like State mutation or IO or Throwing exception
  def makeCoffe(creditCard: CreditCard): (Coffe, Charge) = {

    val coffe = Coffe()
    val charge = Charge(Price(15.00), creditCard)

    //** Below would do the IO (Side effects for every time we prepare a coffe)
    //** This makes he code difficult to test and reuse
    //** As it needs the charging system available for testing this code else creating a mokking of charging system
    //*******    charge.charge()

    //** So idea is to to abstract away the side effects from a function to make it pure function
    //** So the side effects would be performed outside the function body
    (coffe, charge)


  }

}


case class Coffe()

case class Price(amt: Double)

case class CreditCard(name: String, number: Int)

case class Charge(price: Price, cc: CreditCard) {
  def charge(): Unit = {
    //*Contacts the creditcard company and charge the given amt
  }

  def combine(x: Charge): Charge = {
    Charge(Price(this.price.amt + x.price.amt), cc)
  }

}

