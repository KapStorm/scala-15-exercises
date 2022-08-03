import scala.annotation.tailrec

object PascalsTriangle {
  def rows(n: Int): List[List[Int]] = {
    if (n <= 0) return Nil
    if (n == 1) return List(List(1))

    List(List(1)) ++ solve(n - 2, List(1, 1))
  }

  private def solve(n: Int, lastList: List[Int]): List[List[Int]] = {
    if (n == 0) return List(lastList)

    val newList = 1 +: (for {
      i <- 0 until lastList.size - 1
    } yield lastList(i) + lastList(i + 1)).toList :+ 1

    List(lastList) ++ solve(n - 1, newList)
  }
}
