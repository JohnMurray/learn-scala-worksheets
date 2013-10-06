object _2_0_Functions {
  /*
  * A few things to notice:
  *   - Types come after declaration
  *   - Scala makes use of pattern matching (will see more of that later)
  *   - The use of '_' represents Scala's wildcard to mean 'everything'
  */
  def fib(n: Int): Int = n match {
    case 0|1 => n
    case _ => fib(n - 1) + fib(n - 2)
  }

  fib(3)
  fib(10)


  /*
  * A few thing to notice:
  *   - Lambdas are typed as (parameter list) => returnType
  *   - Our return type is a lambda of no parameters yielding an Int
  *       () => Int
  */
  def fibGenerator(): () => Int = {
    var a: Int = 0
    var b: Int = 1

    () => {
      val res = a + b
      a = b
      b = res
      res
    }
  }
  val fib = fibGenerator
  for (i <- 1 to 10) { println(fib()) }



  /*
  * A few things to notice:
  *   - Scala supports pass by value and pass by name (default by value)
  *   - '=>' operator in parameter list means pass by name
  */
  def log(msg: => String, doLog: Boolean) = {
    if (doLog) {
      println(msg)
    }
  }

  val doLog = false
  log("some stuff" + (1 / 0), doLog)

}
