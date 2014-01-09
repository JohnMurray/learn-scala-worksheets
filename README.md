# Scala - Learning Worksheets

This project contains some worksheets to walk you through the introductory
principles in Scala. The worksheets were written using the facilities available
within IntelliJ, but they should work just as well with eclipse.

## General Setup

+ Ensure that you have Java avaialble on your machine (`java -version`). Version 1.7 is preferred, but 1.6 will work as well. If you would like to upgrade to 1.7, you can download it from Oracle [here][2].
+ Install SBT
  + SBT (Scala Build Tool) is very easily installed with `brew`. If you do not have [brew][3] installed, I recommend you do or install SBT [manually][4].
  + `brew install sbt`
  + Already installed?  `brew upgrade sbt`

## Setup with IntelliJ

+ [Download IntelliJ][1] if needed (version 13 Community Edition recommended)
+ Install `scala` plugin (Preferences -> Plugins -> Browse Repositories -> install `Scala`)
+ Install Scala & SBT support
  + Add Repository: (Preferences -> Plugins -> Browse Repositories -> Manage Repositories)
    + `http://www.jetbrains.com/idea/plugins/scala-nightly-cardea.xml`
  + Install Plugin: (Preferences -> Plugins -> Browse Repositories -> install `scala-intellij-bin`)
+ `git clone git://github.com/JohnMurray/learn-scala-worksheets.git $CHECKOUT_DIR`
+ Import Project from `$CHECKOUT_DIR`
+ Select `Import from External Model` and `SBT project` as your import options
+ Check `Use auto-import`

Depending on if you have setup IntelliJ for scala development before, you may
need to specify a JDK for your project. Once you have the project open, you
can do this buy:

+ Open your project preferences
  + Mac: `Command` + `;`
  + Windows: `ctrl` + `shift` + `alt` + `s`
+ Go to 'Project' and ensure that you have a 'Project SDK' defined
+ If not, create a new one and select the JDK directory (should open up there by default)
+ Go to 'Modules' and ensure that all modules have a JDK defined under the 'Dependencies' tab
+ If not, set to same one as project settings
+ Click 'Apply' and 'OK'
+ Try to run worksheet again

## Setup with Eclipse

When you import worksheets into Eclipse, it doesn't seem to recognize them as
worksheets. You'll notice that, with eclipse, when you create a new worksheet
it creates a copy in the .worksheet directory containing a modified source. I'm
not certain how to convince Eclipse to generate this folder on import. If you
know a way, please send a pull-request.


## Running the Worksheets

Once you open up your project, you should be able to open a worksheet (eg. 
`src/main/scala/worksheet/0_0_Basics.sc`) and click the green play button directly
above the file-window (not the same as the play/run button for the project).

## Running the Future / Akka Examples

If you make it to the end of the worksheets, you'll notice that there is a
seperate directory containing examples of Scala Futures and Akka Actors. These
cannot (or more likely should not) be run within the context of the worksheets.
That being said, you can easily run these by using the `run` command in the root
directory (`./run`) or by entering the sbt console and issuing the `run` command:

    $learn-scala-worksheets $> sbt
    
    # starting sbt console . . . 
    sbt > run

Using the `run` script in the root directory will invoke SBT which has a pretty
decent start-up-time. To avoid that, you are better off using the `sbt` command
to enter into the interactive console. Note that when you are in the interactive
console, you don't need to issue any type of recompile command as SBT will already
see that files have changed and re-compile when you type `run`.



  [1]: http://www.jetbrains.com/idea/free_java_ide.html
  [2]: http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
  [3]: http://brew.sh/
  [4]: http://www.scala-sbt.org/release/docs/Getting-Started/Setup.html
