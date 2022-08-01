object PythagoreanTriplet {
  def isPythagorean(x: (Int, Int, Int)): Boolean = {
    val a :: tailA = List(x._1, x._2, x._3).sorted
    val b :: tailB = tailA
    val c :: _ = tailB

    a * a + b * b == c * c
  }

  def pythagoreanTriplets(x: Int, y: Int): Seq[(Int, Int, Int)] = {
    for {
      a <- x to y
      b <- a to y
      c <- b to y
      if isPythagorean((a, b, c))
    } yield (a, b, c)
  }
}
