object ProteinTranslation {
  val proteinMap = Map(
    "AUG" -> "Methionine",
    "UUU" -> "Phenylalanine",
    "UUC" -> "Phenylalanine",
    "UUA" -> "Leucine",
    "UUG"	-> "Leucine",
    "UCU" -> "Serine",
    "UCC" -> "Serine",
    "UCA" -> "Serine",
    "UCG" -> "Serine",
    "UAU" -> "Tyrosine",
    "UAC" -> "Tyrosine",
    "UGU" -> "Cysteine",
    "UGC" -> "Cysteine",
    "UGG" -> "Tryptophan",
    "UAA" -> "STOP",
    "UAG" -> "STOP",
    "UGA" -> "STOP"
  )

  def proteins(str: String): Seq[String] = {
    (for {
      i <- 0 to (str.length - 3) by 3
    } yield str.slice(i, i + 3))
      .map(proteinMap)
      .takeWhile(_ != "STOP")
  }
}
