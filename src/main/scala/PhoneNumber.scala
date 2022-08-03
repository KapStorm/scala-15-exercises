object PhoneNumber {
  val phoneRegex = "1?([2-9][0-9]{2}){2}[0-9]{4}"

  def clean(phone: String): Option[String] = {
    val filteredPhone = phone.filter(_.isDigit)
    if (filteredPhone.matches(phoneRegex))
      if (filteredPhone.length == 11) Some(filteredPhone.tail)
      else Some(filteredPhone)
    else None
  }
}
