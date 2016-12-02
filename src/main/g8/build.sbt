organization := "com.example"

name := "$name$"

scalaVersion := "$scala_version$"

version := "0.1.0"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-netty-websockets" % "$unfiltered_version$"
)
