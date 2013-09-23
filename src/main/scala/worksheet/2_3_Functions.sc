object _2_3_Functions {
  /*
   * A few things to notice:
   *  - Types can be anonymous
   *  - No explicit inheritance
   */
  def withClose(closeAble: {def close(): Unit}, op: {def close(): Unit} => Unit) = {
                                                                                     try {
                                                                                     op(closeAble)
                                                                                     }
                                                                                     finally {
                                                                                     closeAble.close()
                                                                                     }
                                                                                     }




  class Connection {
    def close(): Unit = println("Connection closed.")
  }


  val conn = new Connection()
  withClose(conn, conn => println("attempting to close connection..."))
}
