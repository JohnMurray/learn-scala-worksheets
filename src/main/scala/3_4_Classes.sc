/*
 * A few things to notice:
 *   - apply method
 *   - companion object
 */
object _3_4_Classes {

  class Height(val Feet: Int, val Inches: Int) {
    override def toString = "%d' %d\"".format(Feet, Inches)
  }

  class Person(val Name: String, val Age: Option[Int], val Height: Option[Height]) {

    override def toString = {
      "Name:%s  Age:%s  Height:%s".format(
        Name,
        Age getOrElse "n/a",
        Height getOrElse "n/a")
    }
  }
  object Person {

    def apply(Name: String) = new Person(Name, None, None)
    def apply(Name: String, Age: Int) = new Person(Name, Some(Age), None)
    def apply(Name: String, Age: Int, Height: Height) = new Person(Name, Some(Age), Some(Height))
  }

}
import _3_4_Classes._


val person1 = Person("John")
val person2 = Person("John", 23)
var person3 = Person("John", 23, new Height(5, 9))

