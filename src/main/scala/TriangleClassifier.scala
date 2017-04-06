
trait Triangle {
  def side1: Int
  def side2: Int
  def side3: Int
}

case class Isosceles(side1: Int, side2: Int, side3: Int) extends Triangle
case class Equilateral(side1: Int, side2: Int, side3: Int) extends Triangle
case class Scalene(side1: Int, side2: Int, side3: Int) extends Triangle

object TriangleClassifier extends App {
  type Sides = (Int, Int, Int)
  private def twoSidesEqual(t: Sides): Boolean = (t._1 == t._2 || t._2 == t._3 || t._1 == t._3)
  private def allSidesEqual(t: Sides): Boolean = (t._1 == t._2 & t._2 == t._3)
  private def invalidSides(t: Sides): Boolean = (t._1 <= 0 || t._2 <= 0 || t._3 <= 0)

  def classify(t: Sides): Triangle = {
    t match {
      case s: Sides if(invalidSides(s)) => throw new IllegalArgumentException("All sides must be greater than 0")
      case s: Sides if(allSidesEqual(s)) => Equilateral(s._1, s._2, s._3)
      case s: Sides if(twoSidesEqual(s)) => Isosceles(s._1, s._2, s._3)
      case _ => Scalene(t._1, t._2, t._3)
    }
  }
}



