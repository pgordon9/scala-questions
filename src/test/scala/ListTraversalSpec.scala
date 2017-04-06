import org.scalatest.{FunSpecLike, Matchers}

class ListTraversalSpec extends FunSpecLike with Matchers {
  describe("The ListTraversal utility") {
    describe("when determining the 5th from the last element") {
      it("should throw an IllegalArgumentException when Lists with less than 5 elements are passed in") {
      }

      it("should determine the 5th element from the end of the list") {

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
