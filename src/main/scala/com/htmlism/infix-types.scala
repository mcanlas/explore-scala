package com.htmlism

class Or[A, B]

object ThisOrThat {
  val a = ??? : Or[Or[Int, String], Char]
  val b = ??? : Int Or String Or Char

  val something = List(a, b)
}
