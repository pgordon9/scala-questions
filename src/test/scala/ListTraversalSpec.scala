import org.scalatest.{FunSpecLike, Matchers}

class ListTraversalSpec extends FunSpecLike with Matchers {
  describe("The ListTraversal utility") {
    describe("when determining the 5th element from the end of a list") {
      it("should throw an IllegalArgumentException when Lists with less than 5 elements are passed in") {
        val l = List(4,3,2,1)

        a [IllegalArgumentException] should be thrownBy {
          val elem = ListTraversal.fifthElement(l)
        }
      }

      it("should determine the 5th element from the end of the list") {
        val l = List(7,6,5,4,3,2,1)
        val elem = ListTraversal.fifthElement(l)

        elem shouldBe 5
      }
    }

    describe("when determining if one list is an exclusive subset of another"){
      it("should return true when all elements in the child list exist in parent list"){

      }

      it("should return false when an element is missing in the parent list"){

      }

      it("should return treu when the child list is empty, and the parent list is not empty"){

      }

      it("should return false when either of the lists are empty"){

      }
    }
  }
}
