import scala.annotation.tailrec

object BinarySearch extends App {
  def find(list: List[Int], target: Int): Option[Int] = {
    binarySearch(list, 0, list.size - 1, target)
  }

  @tailrec
  private def binarySearch(list: List[Int], left: Int, right: Int, target: Int): Option[Int] = {
    if (left > right) return None

    val middle = (right + left) / 2
    val current = list(middle)

    if (current == target) return Some(middle)
    if (current > target) binarySearch(list, left, middle - 1, target)
    else binarySearch(list, middle + 1, right, target)
  }
}
