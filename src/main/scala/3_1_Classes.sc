object _3_1_Classes {
  /*
   * A few things to notice:
   *   - Override methods must be marked explicitly as overrides
   *   - Our classes now have a body
   */
  class Height(val Feet: Int, val Inches: Int) {
    override def toString(): String = "%d' %d\"".format(Feet, Inches)
  }

  class Person(val Name: String, val Age: Int, val Height: Height) {
    override def toString(): String = {
      "Name:%s  Age:%d  Height:%s".format(Name, Age, Height)
    }
  }


  val person = new Person(Name = "John", Age = 23,
    Height = new Height(Feet = 5, Inches = 9))


  println(person)
}
