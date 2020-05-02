name := "zio-secp256k1"

organization := "org.scash"

version := "0.1.5"

lazy val scala212       = "2.12.10"
lazy val scala213       = "2.13.1"
lazy val supportedScala = List(scala212, scala213)

scalaVersion in ThisBuild := scala213

coverageEnabled := false //has to be turned off when publishing

resolvers ++= Seq(
  Resolver.bintrayRepo("scala-cash", "io")
)
crossScalaVersions := supportedScala

scmInfo := Some(
  ScmInfo(url("https://github.com/scala-cash/zio-secp256k1"), "git@github.com:scala-cash/zio-secp256k1.git")
)
licenses += ("MIT", url("http://opensource.org/licenses/MIT"))

bintrayPackageLabels := Seq("bitcoin", "bitcoin cash", "secp256k1", "zio", "blockchain")
bintrayOrganization := Some("scala-cash")
bintrayRepository := "io"

testFrameworks += new TestFramework("zio.test.sbt.ZTestFramework")

val zioVersion = "1.0.0-RC18-1"

libraryDependencies ++= List(
  "dev.zio"   %% "zio-test"     % zioVersion % "test",
  "dev.zio"   %% "zio-test-sbt" % zioVersion % "test",
  "dev.zio"   %% "zio"          % zioVersion,
  "org.scash" %% "secp256k1jni" % "1.1.3"
)
