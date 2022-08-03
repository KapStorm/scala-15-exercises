object LargestSeries {
  def largestProduct(n: Int, str: String): Option[Int] = {
    if (n > str.length || n < 0 || !str.forall(_.isDigit)) return None

    if (n == 0) return Some(1)

    // It's easier just doing
    // Some(str.map(_.asDigit).sliding(n).map(_.product).max)
    val maxProduct = (for {
      i <- 0 to str.length - n
    } yield str.slice(i, i + n).map(_.toInt - '0').product).max

    Some(maxProduct)
  }
}