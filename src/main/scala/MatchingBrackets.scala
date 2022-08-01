import scala.collection.mutable.Stack

object MatchingBrackets extends App {
  def isPaired(txt: String): Boolean = {
    val expectedStack = Stack[Char]()
    var response = true

    txt.foreach { c =>
      if (response) {
        c match {
          case '[' => expectedStack push ']'
          case '{' => expectedStack push '}'
          case '(' => expectedStack push ')'
          case c@(']' | '}' | ')') =>
            response = if (expectedStack.nonEmpty) {
              expectedStack.pop() == c
            } else {
              false
            }
          case _ =>
        }
      }
    }

    expectedStack.isEmpty && response
  }
}

