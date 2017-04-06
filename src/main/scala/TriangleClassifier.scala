trait Triangle {
  def side1: Int
  def side2: Int
  def side3: Int
}

case class Isosceles(side1: Int, side2: Int, side3: Int) extends Triangle
case class Equilateral(side1: Int, side2: Int, side3: Int) extends Triangle
case class Scalene(side1: Int, side2: Int, side3: Int) extends Triangle

object TriangleClassifier extends App {
  case class Sides(s1: Int, s2:Int, s3:Int)

  private def invalidSideValue(s: Any): Boolean = s match { case i: Int => i <= 0 }
  private def atLeastTwoSidesEqual(t: Sides): Boolean = (t.s1 == t.s2 || t.s2 == t.s3 || t.s1 == t.s3)
  private def invalidSideExists(t: Sides): Boolean = t.productIterator.exists(invalidSideValue)

  def classify(t: (Int, Int, Int)): Triangle = {
    val sides = Sides(t._1, t._2, t._3)

    sides match {
      case s: Sides if(invalidSideExists(s)) => throw new IllegalArgumentException("All sides must be greater than 0")
      case Sides(s1, s2, s3) if(s1 == s2 & s2 == s3) => Equilateral(s1, s2, s3)
      case s: Sides if(atLeastTwoSidesEqual(s)) => Isosceles(s.s1, s.s2, s.s3)
      case _ => Scalene(sides.s1, sides.s2, sides.s3)
    }
  }
}