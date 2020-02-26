package GenericAndFunction

sealed trait Tree[A] {

  def fold[B](leaf: A => B, node: (B, B) => B): B = {
    this match {
      case Leaf(value) => leaf(value)
      case Node(left, right) => node(left.fold(leaf, node), right.fold(leaf, node))
    }
  }
}
final case class Node[A](left: Tree[A], right: Tree[A]) extends Tree[A]
final case class Leaf[A](value: A) extends Tree[A]

object GenericTree extends App {
  val tree: Tree[String] = Node(
    Node(Leaf("To"), Leaf("iterate")),
    Node(Node(Leaf("is"), Leaf("human,")), Node(Leaf("to"), Node(Leaf("recurse"), Leaf("divine")))))

  println(tree.fold[String](value => value, (val1, val2) => val1 + " " + val2))
  
  

}


