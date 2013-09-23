object _3_2_Classes {
  /*
   * A few things to notice:
   *   - call methods and set values in top-level of class
   */
  class API {
    val defaultProtocol = "http"
    val defaultPort = 8080
    val defaultEnvironment = "development"
    val defaultHost = "localhost"

    override def toString() = {
      "protocol: %s\n" +
        "port: %d\n" +
        "env: %s\n" +
        "host: %s" format(defaultProtocol, defaultPort, defaultEnvironment, defaultHost)
    }
  }

  val hbapi = new API()




}
