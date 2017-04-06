
trait Triangle {
  def side1: Int
  def side2: Int
  def side3: Int
}

case class Isoscelese(side1: Int, side2: Int, side3: Int) extends Triangle
case class Equilateral(side1: Int, side2: Int, side3: Int) extends Triangle
case class Scalene(side1: Int, side2: Int, side3: Int) extends Triangle

object TriangleClassifier extends App {
  type Sides = (Int, Int, Int)

  def classify(t: Triangle): Triangle = {
    def twoSidesEqual(t: Sides):Boolean = (t._1 == t._2 || t._2 == t._3 || t._1 == t._3)
    val sides = (t.side1, t.side2, t.side3)

    sides match {
      case (s1, s2, s3) if(s1 == s2 && s2 == s3) => Equilateral(s1,s2,s3)
      case (s1, s2, s3) if(twoSidesEqual(s1,s2,s3)) => Isoscelese(s1,s2,s3)
      case _ => Scalene(sides._1, sides._2, sides._3)
    }
  }
}



