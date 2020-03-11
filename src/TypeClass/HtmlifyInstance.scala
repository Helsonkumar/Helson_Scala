package TypeClass

//A Type Class of generic type A
sealed trait Htmlify[A] {
  def write(inp: A): String
}

object Htmlify {
  implicit object defaultHtmlify extends Htmlify[String] {
    def write(inp: String) = s"This is the default instance ${inp}"
  }

  // This an apply emthod used to give us the instance of the required type
  def apply[A](implicit writer: Htmlify[A]) = {
    writer
  }

}

//List of type class instances
object HtmlifyInstances {

  implicit object HtmlifyString extends Htmlify[String] {
    def write(inp: String) = s"Html of String ${inp}"
  }

  implicit object HtmlifyDoble extends Htmlify[Double] {
    def write(inp: Double) = s"Html of Double ${inp + inp}"
  }

  implicit object HtmlifyBoolean extends Htmlify[Boolean] {
    def write(inp: Boolean) = s"Html of Boolean ${!inp}"
  }

  implicit class HtmlifyWriterClass[T](inp: T) {
    def htmlWriterClassMethod(implicit writer: Htmlify[T]) = {
      writer.write(inp)
    }
  }
}

