object PrimeFactors {
  def factors(n: Long, factor: Long = 2, list: List[Long] = List()): List[Long] = {
    if (n == 1) {
      list
    } else {
      if (n % factor == 0) {
        factor +: factors(n / factor, factor)
      } else {
        factors(n, factor + 1)
      }
    }
  }
}
