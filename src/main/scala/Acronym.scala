object Acronym {
  def abbreviate(phrase: String): String = {
    phrase.split("[ |-]+")
      .toList
      .map(_.head.toUpper)
      .mkString("")
  }
}
