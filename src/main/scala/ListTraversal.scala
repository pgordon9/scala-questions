import scala.annotation.tailrec

object ListTraversal {
  @tailrec
  def fifthElement[T](l: List[T]): T = {
    l match {
      case e5::e4::e3::e2::e1::Nil => e5
      case _::t => fifthElement(t)
      case _ => throw new IllegalArgumentException("list must contain at least 5 elements")
    }
  }
}
