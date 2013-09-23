object _2_1_Functions {
  /*
   * A few things to notice:
   *   - JVM does not optimize for tail recursion
   *   - The scala compiler however will attempt if you give it a tail-recursive annotation
   *   - Functions can be defined within functions
   *   - List processing via x::xs (pattern matching)
   */
  import scala.annotation.tailrec
  def listLength(list: List[_]): Int = {
    @tailrec
    def listLengthAcc(list: List[_], length: Int = 0): Int = {
      list match {
        case Nil => length
        case x::xs => listLengthAcc(xs, length + 1)
      }
    }

    listLengthAcc(list)
  }
  listLength(List[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10))



  /*
   * A few things to notice
   *   - Scala has named parameters
   *   - Scala has optional parameters
   */
  def printMsg(message : String = "hello") = {
    println(message)
  }
  printMsg()
  printMsg("stuff")
  printMsg(message = "custom message")
}
