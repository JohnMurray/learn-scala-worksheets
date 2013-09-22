object _3_0_Classes {
  /*
   * A few things to notice:
   *   - The classes have no body (not necessary)
   *   - Constructor parameters are defined within the class signatures
   */
  class Height(val Feet: Int, val Inches: Int)
  class Person(val Name: String, val Age: Int, val Height: Height)

  val person = new Person(Name = "John", Age = 23,
    Height = new Height(Feet = 5, Inches = 9))

  println(person)
}
