object _3_6_Classes {
  /*
   * A few things to notice:
   *   - class prefixed with 'case'
   *   - export constructor parameters
   */

  case class Height(feet: Int, inches: Int)
  case class Person(name: String, age: Int, height: Height)


  val john = new Person("John", 23, new Height(5, 9))

  john match {
    case Person(name, age, Height(feet, inches)) => {
      println(name)
      println(age)
      println(feet)
    }
    case _ => println("idk?")
  }


}
