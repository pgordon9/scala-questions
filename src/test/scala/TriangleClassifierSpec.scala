import org.scalatest.{FunSpecLike, Matchers}

class TriangleClassifierSpec extends FunSpecLike with Matchers {
  describe("The TriangleCategorizer utility") {
    it("should throw an IllegalArgumentException when any sides are <= 0") {
      val sides = (0,1,1)

      a [IllegalArgumentException] should be thrownBy {
        val triangle = TriangleClassifier.classify(sides)
      }
    }

    it("should determine equilateral triangle types"){
      val sides = (1,1,1)
      val triangle = TriangleClassifier.classify(sides)

      triangle shouldBe Equilateral(1,1,1)
    }

    it("should determine isosceles triangle types"){
      val sides = (1,1,2)
      val triangle = TriangleClassifier.classify(sides)

      triangle shouldBe Isosceles(1,1,2)
    }

    it("should determine scalene triangle types"){
      val sides = (1,2,3)
      val triangle = TriangleClassifier.classify(sides)

      triangle shouldBe Scalene(1,2,3)
    }
  }
}
