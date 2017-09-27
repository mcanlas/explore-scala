package com.htmlism

/**
  * A pattern that has two elements can be called infix style.
  */
object InfixPatternMatch {
  object CharDouble {
    def unapply(a: Int): Option[(Char, Double)] = Some('z', 3.2)
  }

  /**
    * The symbolic name helps emulate an infix operator in patterns.
    */
  object :: {
    def unapply(a: Int): Option[(Char, Double)] = Some('z', 3.2)
  }

  def main(args: Array[String]): Unit = {
    val someNumber = 142

    someNumber match {
      case CharDouble(c, d) =>
        println(c, d)
    }

    someNumber match {
      case c CharDouble d =>
        println(c, d)
    }

    someNumber match {
      case ::(c, d) =>
        println(c, d)
    }
    someNumber match {
      case c :: d =>
        println(c, d)
    }
  }
}

/**
  * The alternative pattern operator `|` is supported natively in Scala. The statement matches if either sub-pattern
  * is true.
  */
object BooleanPatterns extends RootDependency {
  object & {
    def unapply(n: Int) = Some((111, 222))

//    def unapply[A](a: A): Option[(A, A)] = Some(a, a)
  }

  object IsEven {
    def unapply(n: Int): Boolean = n % 2 == 0
  }

  object GreaterThanZero {
    def unapply(n: Int): Boolean = n > 0
  }

  object WithSeven {
    def unapply(n: Int): Option[Int] = Some(n + 7)
  }

  object WithEight {
    def unapply(n: Int): Option[Int] = Some(n + 8)
  }

  def main(args: Array[String]): Unit = {
    2468 match {
      case IsEven() =>
        println("it's even")
    }

    3 match {
      case IsEven() | GreaterThanZero()  =>
        println("either qualify")
    }

    44 match {
      case &(WithSeven(n), WithEight(m)) =>
        println(s"both qualify $n $m")
    }

    44 match {
      case WithSeven(n) & WithEight(m) =>
        println(s"both qualify $n $m")
    }
  }
}

object PatternConjunction extends DependsOn(BooleanPatterns) {
  /**
    * This pattern emulates a logical AND. It will always pass and project the expression being matched against to the
    * two sub-patterns.
    */
  object & {
    def unapply[A](a: A): Option[(A, A)] = Some((a, a))
  }

  object IsEven {
    def unapply(n: Int): Boolean = n % 2 == 0
  }

  object GreaterThanZero {
    def unapply(n: Int): Boolean = n > 0
  }

  object WithSeven {
    def unapply(n: Int): Option[Int] = Some(n + 7)
  }

  object WithEight {
    def unapply(n: Int): Option[Int] = Some(n + 8)
  }

  def main(args: Array[String]): Unit = {
    4 match {
      case IsEven() & GreaterThanZero() =>
        println("both qualify")
    }

    4 match {
      case WithSeven(n) & WithEight(m) =>
        println(s"$n $m")
    }
  }
}
