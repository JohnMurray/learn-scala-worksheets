/*
 * Null/Nil/Empty Values
 */

val emptyList = Nil


// TODO figure out of Unit is an object/class/etc
def doNothing() : Unit = { }
// TODO figure out how to use null
// def javaDoNothing() : null = { return null }


/*
 * A few things to notice:
 *   - Option has two implementations, Some and None
 *   - This can be pattern matched against
 *   - Used as Scals's null
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













