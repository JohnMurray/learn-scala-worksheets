object _3_3_Classes {
  /*
   * A few things to notice:
   *   - Can create overloaded constructors (auxiliary constructors)
   */
  class Height(val Feet: Int, val Inches: Int) {
    override def toString(): String = "%d' %d\"".format(Feet, Inches)
  }

  class Person(val Name: String, val Age: Option[Int], val Height: Option[Height]) {

    def this(Name: String) = this(Name, None, None)
    def this(Name: String, Age: Int) = this(Name, Some(Age), None)
    def this(Name: String, Age: Int, Height: Height) = this(Name, Some(Age), Some(Height))

    override def toString(): String = {
      "Name:%s  Age:%s  Height:%s".format(
        Name,
        Age getOrElse "n/a",
        Height getOrElse "n/a")
    }
  }

  val person1 = new Person("John")
  val person2 = new Person("John", 23)
  var person3 = new Person("John", 23, new Height(5, 9))
}
