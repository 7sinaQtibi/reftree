organization := "org.stanch"

name := "reftree"

version := "0.5.0"

licenses := Seq(("GPL-3.0", url("http://www.gnu.org/licenses/gpl-3.0.en.html")))

scalaVersion := "2.11.8"

resolvers ++= Seq(
  Resolver.bintrayRepo("drdozer", "maven")
)

libraryDependencies ++= Seq(
  "com.chuusai" %% "shapeless" % "2.2.5",
  "com.lihaoyi" %% "sourcecode" % "0.1.2",
  "com.lihaoyi" %% "fastparse" % "0.4.1",
  "uk.co.turingatemyhamster" %% "gv-core" % "0.3.2",
  "org.scala-lang.modules" %% "scala-xml" % "1.0.5",
  "com.github.julien-truffaut" %% "monocle-macro" % "1.2.2",
  "com.softwaremill.quicklens" %% "quicklens" % "1.4.7" % Provided,
  "de.sciss" %% "fingertree" % "1.5.2" % Provided,
  "org.scalatest" %% "scalatest" % "3.0.0" % Test,
  "com.lihaoyi" % "ammonite" % "0.7.7" % Test cross CrossVersion.full
)

val predef = Seq(
  "import scala.collection.immutable._",
  "import de.sciss.fingertree._",
  "import reftree._",
  "import reftree.contrib.FingerTreeInstances._",
  "val diagram = Diagram()",
  "import diagram.{renderDefault ⇒ render}"
).mkString(";")

initialCommands in (Test, console) := s"""ammonite.Main("$predef").run(); System.exit(0)"""

addCommandAlias("amm", "test:console")

tutSettings

tutTargetDirectory := baseDirectory.value
