import scala.annotation.tailrec

object NthPrime {
  def prime(n: Int): Option[Int] = {
    if (n == 0) None
    else solve(n)
  }

  @tailrec
  private def solve(n: Int, current: Int = 2): Option[Int] = {
    if (n == 1) return Some(current)

    if (isPrime(current + 1)) {
      solve(n - 1, current + 1)
    } else {
      solve(n, current + 1)
    }
  }

  private def isPrime(n: Int): Boolean = {
    // [math.sqrt(n).toInt] is better than [n / 2]
    (2 to n / 2).forall(n % _ != 0)
  }
}
