import org.scalatest.{FunSpecLike, Matchers}

class ListUtilsSpec extends FunSpecLike with Matchers {
  describe("The ListUtils utility") {
    describe("when determining the 5th element from the end of a list") {
      it("should throw an IllegalArgumentException when Lists with less than 5 elements are passed in") {
        val l = List(4,3,2,1)

        a [IllegalArgumentException] should be thrownBy {
          val elem = ListUtils.fifthElement(l)
        }
      }

      it("should determine the 5th element from the end of the list") {
        val l = List(7,6,5,4,3,2,1)
        val elem = ListUtils.fifthElement(l)

        elem shouldBe 5
      }
    }

    describe("when determining if one list is an exclusive subset of another"){
      it("should return true when all elements in the child list exist in parent list") {
        val uniqueSubList = List(2, 3, 4)
        val duplicateSubList = List(2, 2, 3, 3, 4)
        val parentList = List(1, 2, 3, 4, 5, 6)

        val uniqueResult = ListUtils.isSubset(uniqueSubList, parentList)
        val duplicateResult = ListUtils.isSubset(duplicateSubList, parentList)

        uniqueResult shouldBe true
        duplicateResult shouldBe true
      }

      it("should return false when an element is missing in the parent list"){
        val uniqueSubList = List(2, 3, 4, 8)
        val duplicateSubList = List(2, 2, 3, 3, 4, 8, 8)
        val parentList = List(1, 2, 3, 4, 5, 6)

        val uniqueResult = ListUtils.isSubset(uniqueSubList, parentList)
        val duplicateResult = ListUtils.isSubset(duplicateSubList, parentList)

        uniqueResult shouldBe false
        duplicateResult shouldBe false
      }

      it("should return true when the child list is empty, and the parent list is not empty"){
        val uniqueSubList = List()
        val parentList = List(1, 2, 3, 4, 5, 6)

        val uniqueResult = ListUtils.isSubset(uniqueSubList, parentList)

        uniqueResult shouldBe true
      }

      it("should return false when either of the lists are empty"){
        val uniqueSubList = List(1, 2, 3)
        val parentList = List()

        val uniqueResult = ListUtils.isSubset(uniqueSubList, parentList)

        uniqueResult shouldBe false
      }
    }
  }
}
