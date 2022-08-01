object ArmstrongNumbers extends App {
  def isArmstrongNumber(n: Int): Boolean = {
    n == powAndSum(n / 10, n % 10, sizeOfInt(n))
  }

  def powAndSum(n: Int, mod: Int, size: Int): Int = {
    if (n == 0) {
      pow(mod, size)
    } else {
      pow(mod, size) + powAndSum(n / 10, n % 10, size)
    }
  }

  def sizeOfInt(n: Int): Int = {
    if (n == 0) {
      0
    } else {
      sizeOfInt(n / 10) + 1
    }
  }

  def pow(n: Int, count: Int): Int = {
    if (count == 1) n
    else n * pow(n, count - 1)
  }
}
