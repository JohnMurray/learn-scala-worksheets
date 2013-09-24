name := "Worksheets"

version := "0.0.1"

scalaVersion := "2.10.2"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

libraryDependencies += "com.typesafe.akka" %% "akka-actor" % "2.2.0"

libraryDependencies += "org.scalaj" %% "scalaj-http" % "0.3.10"

mainClass := Some("Actor_6_1")
