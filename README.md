# Scala - Learning Worksheets

This project contains some worksheets to walk you through the introductory
principles in Scala. The worksheets were written using the facilities available
within IntelliJ, but they should work just as well with eclipse.

## Setup with IntelliJ

+ [Download IntelliJ][1] (if needed)
+ Install `scala` plugin (Preferences -> Plugins -> Browse Repositories -> install `Scala`)
+ Install `SBT support`
  + Add repository (Preferences -> Plugins -> Browse Repositories -> Manage Repositories)
    + `http://download.jetbrains.com/scala/sbt-nightly-leda.xml`
  + plugin (Preferences -> Plugins -> Browse Repositories -> install `sbt-intellij-bin`)
+ `git clone git://github.com/JohnMurray/learn-scala-worksheets.git $CHECKOUT_DIR`
+ Import Project from `$CHECKOUT_DIR`
+ Select `Import from External Model` and `SBT project` as your import options
+ Check `Use auto-import`

## Setup with Eclipse

When you import worksheets into Eclipse, it doesn't seem to recognize them as
worksheets. You'll notice that, with eclipse, when you create a new worksheet
it creates a copy in the .worksheet directory containing a modified source. I'm
not certain how to convince Eclipse to generate this folder on import. If you
know a way, please send a pull-request.


  [1]: http://www.jetbrains.com/idea/free_java_ide.html
