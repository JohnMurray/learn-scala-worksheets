object _0_1_Basics {
  /*
   * Null/Nil/Empty Values
   */
  val emptyList = Nil
  val bigListOfNothing : List[Nothing] = List()

  // checkout implementation
  scala.collection.immutable.Nil

  def doNothing() : Unit = { }

  /*
   * A few things to notice:
   *   - Option has two implementations, Some and None
   *   - This can be pattern matched against
   *   - Used typically instead of 'null' values
   */
  def maybeReturnInteger(): Option[Int] = {
    val randomNumber = new scala.util.Random().nextInt(100)

    if (randomNumber < 50) {
      Some(randomNumber)
    }
    else {
      None
    }
  }
  for (i <- Range(0, 5)) {
    maybeReturnInteger() match {
      case Some(x) => println(x)
      case None => println("nothing")
    }
  }

}
