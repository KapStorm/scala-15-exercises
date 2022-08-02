import scala.collection.mutable.Stack

object MatchingBrackets {
  def isPaired(txt: String): Boolean = {
    val expectedStack = Stack[Char]()

    val response = txt.forall({
      case '[' =>
        expectedStack push ']'
        true
      case '{' =>
        expectedStack push '}'
        true
      case '(' =>
        expectedStack push ')'
        true
      case c@(']' | '}' | ')') =>
        if (expectedStack.nonEmpty) {
          expectedStack.pop() == c
        } else {
          false
        }
      case _ => true
    })

    expectedStack.isEmpty && response
  }

  println(isPaired("{a}([bdbb bdf])"))
  println(isPaired("[}"))
}

