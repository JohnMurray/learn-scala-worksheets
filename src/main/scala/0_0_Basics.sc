
/*
 * Immutable and Mutable data
 */
// will fail
val immutableInt = 5
// immutableInt += 1


// will not fail
var mutableInt = 5
mutableInt += 1



/*
 * 'val' is not magic. Eg. immutable reference to a mutable
 * data-structure will not make the data-structure immutable.
 *
 * A few things to notice:
 *   - scala collections are immutable by default
 */
import scala.collection.mutable

val map = mutable.WeakHashMap[String, Int]()
map.put("one", 1)
map.put("two", 2)

println(map)


/*
 * Types
 *
 * A few things to notice:
 *   - Scala is a statically, strongly typed language
 *   - Scala makes heavy use of type inference to make the code more readable
 *   - Types are specified after the name of the variable/function
 */

var x = 5
var y : Int = 5

def helloTo(name: String): Unit = println("hello " + name)
helloTo("API Team")
