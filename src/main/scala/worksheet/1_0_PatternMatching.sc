object _1_0_PatternMatching {
  /*
   * A few things to notice:
   *   - Any method that ends in ':' applies to the right operand
   *   - Nil represents the empty list
   */

  1 :: 2 :: 3 :: 4 :: Nil
  1 :: 2 :: 3 :: 4 :: List()

  Nil.::(4).::(3).::(2).::(1)
  List().::(4).::(3).::(2).::(1)

  List(1, 2, 3, 4)


  /*
   * Pattern Matching
   *
   * Pattern matching involves matching data and objects to expected types
   * and extracting that data in a usable way. An easy way to illustrate this
   * is with lists
   */


  val myList = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: 10 :: Nil

  myList match {
    case x :: xs => {
      println(x)
      println(xs)
    }
    case Nil => println("empty list")
  }
}
