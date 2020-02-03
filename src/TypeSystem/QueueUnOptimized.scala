
// This is a demo to show how we can hide the implementation of a Type from Client using Private modifiers
// The apply method lets you handover the client an object of the syntax : Object(item, item)
// This also shows the implementation of queue
package TypeSystem

object QueueUnOptimized extends App {

  val queue = Queue(2, 4, 6, 22, 10)

  class Fruit(x: String)
  class Apple(x: String) extends Fruit(x)
  class Orange(x: String) extends Fruit(x)
  class NonFruit(x: String)

  val AppleQueue: Queue[Apple] = Queue(new Apple("1"), new Apple("3"), new Apple("4"))

  val x: Queue[Fruit] = AppleQueue.enqueue(new Orange("29"))
  val x2: Queue[AnyRef] = AppleQueue.enqueue(new NonFruit("292"))

}

trait Queue[+T] {
  def head: T
  def tail: Queue[T]
  // Here even though T is lower bound to U, we have still passed T to enqueue. Due to reflexive
  def enqueue[U >: T](x: U): Queue[U]
}

object Queue {
  def apply[T](x: T*) = new QueueImpl(x.toList, Nil)

  class QueueImpl[+T](
    private val leading: List[T],
    private val trailing: List[T]) extends Queue[T] {

    private def mirror = {
      if (leading.isEmpty)
        new QueueImpl(trailing.reverse, Nil)
      else
        this
    }

    def head: T = mirror.leading.head

    def tail = new QueueImpl(mirror.leading.tail, trailing)

    def enqueue[U >: T](x: U) = new QueueImpl[U](leading, x :: trailing)

  }
}