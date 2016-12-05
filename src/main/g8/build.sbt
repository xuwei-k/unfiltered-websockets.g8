organization := "com.example"

name := "$name$"

scalaVersion := "$scala_version$"

version := "0.1.0"

libraryDependencies ++= Seq(
  "net.databinder" %% "unfiltered-netty-websockets" % "$unfiltered_version$"
)

val unusedWarnings = (
  "-Ywarn-unused" ::
  "-Ywarn-unused-import" ::
  Nil
)

scalacOptions ++= PartialFunction.condOpt(CrossVersion.partialVersion(scalaVersion.value)){
  case Some((2, v)) if v >= 11 => unusedWarnings
}.toList.flatten

Seq(Compile, Test).flatMap(c =>
  scalacOptions in (c, console) --= unusedWarnings
)

scalacOptions ++= "-deprecation" :: "unchecked" :: "-feature" :: Nil
