object _3_5_Classes {
  /*
   * A few things to notice:
   *   - Companion object acts as a static-method container
   */
  class Car(make: String, model: String) {
    override def toString = "%s %s".format(make, model)
  }

  object Car {
    def getMakes = List("Honda", "Ford", "Chevy")
    def getModels = Map[String, List[String]](
      "Honda" -> List("Accord", "ZEST", "Fit"),
      "Ford"  -> List("F-150", "Taurus", "Marauder"),
      "Chevy" -> List("Volt", "Celta", "Impala")
    )
  }


  val allCars: List[Car] = Car.getMakes.map(make => {
    Car.getModels(make).map(model => {
      new Car(make, model)
    })
  }).flatten


  allCars.map(println)

}
