case class Triangle(val a: Double, val b: Double, val c: Double) {
  private val nonZeroValues = Set(0, a, b, c).size > 1
  private val validShapes = a + b > c && a + c > b && b + c > a
  private val isValid = nonZeroValues && validShapes
  def equilateral: Boolean = Set(a, b, c).size == 1 && isValid
  def isosceles: Boolean = Set(a, b, c).size == 2 && isValid || equilateral
  def scalene: Boolean = Set(a, b, c).size == 3 && isValid
}