object _2_2_Functions {
  /*
   * A few things to notice:
   *   - Variable Arguments
   *   - Generics
   */
  def newList[T](items: T*): List[T] = {
   var list : List[T] = Nil
   for(item <- items) {
     list = item :: list
   }

   return list.reverse
 }


  val myNewList = newList(1, 2, 3, 4, 5)
  println(myNewList)

  val mySecondNewList = newList('a', 'b', 'c', 'd', 'e')
  println(mySecondNewList)

}
