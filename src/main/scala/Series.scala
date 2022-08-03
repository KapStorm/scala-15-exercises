object Series {
  def slices(size: Int, num: String): List[List[Int]] = {
    (for {
      i: Int <- 0 to (num.length - size)
    } yield num.slice(i, size + i).toList.map(_ - '0')).toList
  }
}
