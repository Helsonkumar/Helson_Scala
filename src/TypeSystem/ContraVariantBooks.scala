
// This is  a demo to show the contravariant understanding

// T => U gets interpretted by Scala as trait Fumction1[-S, +T]
// which is contraVariant in the Argument Type and Covariant in the result type

// This means that we can replace a function of type Function1 (ie Book => AnyRef) in our case
// with any function which is Contravariant in its argument type and Co-variant in its result type
// ie Publication => String  in our case

// The Method is ContraVariant in its argument Type (Publication is treated as sub class to Book)
// The Method is CoVariant in is result Type (String is SubClass to AnyRef)
// So this satisfies the type variance of Function1 trait[-S, +T]
// So this is substitutable

// BTW : The Variance feature of Scala represent the component Substitution


package TypeSystem

object ContraVariantBooks extends App{
  
  // this Publication => String
  def clientfun(x:Publication) = x.name
  BookListApp.printBooks(clientfun)

}

class Publication (val name:String)

class Book(val title:String) extends Publication(title + "Pub")

object BookListApp {
  
  val bookSet = Set (new Book("Jungle Book"), new Book("Sherlock Holmes") , new Book("Harry Potter"))
  
  // Here we need Book => AnyRef
  def printBooks(fun : (Book => AnyRef)) = {
    for(book <- bookSet) println(fun(book))
  }
  
}