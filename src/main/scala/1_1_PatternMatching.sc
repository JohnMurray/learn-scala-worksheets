/*
 * Take it a step further and use pattern-matching and recursion to
 * process lists. This is a very common pattern in scala
 */

val myList = 1 :: 2 :: 3 :: 4 :: 5 :: 6 :: 7 :: 8 :: 9 :: 10 :: Nil

def doWithList(list: List[Int]): Unit = {
  list match {
    case x :: xs => {
      println(xs)
      doWithList(xs)
    }
    case Nil =>
  }
}
doWithList(myList)



















