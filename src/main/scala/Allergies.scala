import Allergen.{Allergen, Cats, Chocolate, Eggs, Peanuts, Pollen, Shellfish, Strawberries, Tomatoes}

object Allergies {
  def allergicTo(allergen: Allergen, score: Int): Boolean = {
    /*
    * This could be easier with the operator &:
    *
    * allergen.id & score == allergen.id
    */
    val allergenBits = getBits(allergen.id).reverse
    val scoreBits = getBits(score).reverse

    if (allergenBits.length > scoreBits.length) return false

    val iteration = for {
      i <- 0 until allergenBits.length
      if allergenBits(i) == '0' ||
        allergenBits(i) == '1' &&
        allergenBits(i) == scoreBits(i)
    } yield true

    allergenBits.length == iteration.size
  }

  def list(score: Int): List[Allergen] = {
    val allAllergies = List(Eggs, Peanuts, Shellfish, Strawberries, Tomatoes, Chocolate, Pollen, Cats)
    allAllergies.filter(a => allergicTo(a, score))
  }

  private def getBits(score: Int): String = {
    if (score == 0) return ""

    if (score % 2 == 0) getBits(score / 2) + "0"
    else getBits(score / 2) + "1"
  }
}

object Allergen extends Enumeration {
  type Allergen = Value

  val Eggs: Allergen          = Value(1)
  val Peanuts: Allergen       = Value(2)
  val Shellfish: Allergen     = Value(4)
  val Strawberries: Allergen  = Value(8)
  val Tomatoes: Allergen      = Value(16)
  val Chocolate: Allergen     = Value(32)
  val Pollen: Allergen        = Value(64)
  val Cats: Allergen          = Value(128)
}
