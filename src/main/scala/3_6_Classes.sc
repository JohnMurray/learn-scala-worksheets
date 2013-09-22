/*
 * A few things to notice:
 *   - class prefixed with 'case'
 *   - export constructor parameters
 */

object _3_6_Classes {

  case class Height(feet: Int, inches: Int)
  case class Person(name: String, age: Int, height: Height)

}

import _3_6_Classes._


val john = new Person("John", 23, new Height(5, 9))

john match {
  case Person(name, age, height) => {
    println(name)
    println(age)
    println(height)
  }
  case _ => println("idk?")
}




