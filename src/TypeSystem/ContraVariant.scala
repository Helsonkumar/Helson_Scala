
// This is a demo to show Contravariant types
// Contravariant  : Denoted by -[T] : Means that when T is sub type of S
// Then we can replace S in place where T is required. (Use Animal in place of Dog)
// This is helpful in certain conditions.
// Consider Array[AnyRef] and Array[String]
// Array{AnyRef] expects less: ie expects the items to be AnyRef
// Array[String] expects more : Expects the items to be AnyRef and String

// String actually can perform all of AnyRef and some extra functions

// Liskov Substitution Principle:
// When T is Subtype of U then T can be substituted in the place where U is expected.
// This holds true when T can perform all what U does and anything extra if allowed.

// T must EXPECT LESSS and PROVIDE MORE .

// Here [AnyRef] cab be replaced in place of [String] - Bcz whatever we can do with [String] can be done with [AnyRef] also
// But [String] cannot be replaced in place of [AnyRef] - Bcz String expects the object to be String strictly.Which is more
// Reason : AnyRef requires less
//          String requires more

// So here AnyRef can be treated as sub type of String, but not other way is true

package TypeSystem

object ContraVariant extends App {

  val anychannel: OutputChannel[AnyRef] = new AnyOutput

  //[AnyRef] in place of String
  val stringchannel: OutputChannel[String] = anychannel

  val stringchannel2: OutputChannel[String] = new StringOutput

  // [String] in place if [AnyRef] voilates the rule
  //val anychannel2:OutputChannel[AnyRef] = stringchannel2

  trait OutputChannel[-T] {
    def write(x: T)
  }

  class AnyOutput extends OutputChannel[AnyRef] {
    var channel = List[AnyRef]()
    override def write(x: AnyRef) = {
      x :: channel
    }

    def ::(x: AnyRef): List[AnyRef] = {
      x :: channel
      channel
    }

  }

  class StringOutput extends OutputChannel[String] {
    var channel = List[String]()
    override def write(x: String) = {
      x :: channel
    }

    def ::(x: String): List[String] = {
      x :: channel
      channel
    }
  }

}


