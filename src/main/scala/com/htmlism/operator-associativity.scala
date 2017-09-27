package com.htmlism

case class Lefty(n: Int) {
  def +(that: Int) = Lefty(n + that)
}

case class Righty(n: Int) {
  def +:(that: Int) = Righty(n + that)
}

/**
  * Operators that end in a colon are right-associative.
  */
object OperatorAssociativity {
  Lefty(1) + 2

  // right-associative infix notation
  3 +: Righty(4)

  // traditional method call
  Righty(4).+:(3)
}
