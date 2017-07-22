name := "play-blog"

scalaVersion in ThisBuild := "2.11.11"

scalaSource in Compile := baseDirectory.value / "src" / "main" / "scala"

scalaSource in Test := baseDirectory.value / "src" / "test" / "scala"

resourceDirectory in Compile := baseDirectory.value / "src" / "main" / "resources"

resourceDirectory in Test := baseDirectory.value / "src" / "test" / "resources"

libraryDependencies ++= Seq(
  "redis.clients" % "jedis" % "2.1.0",
  "com.typesafe.play" % "play_2.11" % "2.5.15",
  "nl.grons" %% "metrics-scala" % "3.5.9",
  "com.lambdaworks" % "scrypt" % "1.3.3",
  "org.apache.httpcomponents" % "httpcore" % "4.1.2",
  "org.apache.httpcomponents" % "httpclient" % "4.1.2",
  "org.scalaz.stream" % "scalaz-stream_2.11" % "0.8.6",
  "org.specs2" %% "specs2" % "3.3.1" % "test",
  "org.scalacheck" %% "scalacheck" % "1.10.0" % "test")

lazy val root = (project in file(".")).settings(
  scalacOptions := Seq("-deprecation", "-feature", "-unchecked", "-Ywarn-value-discard", "-Ywarn-adapted-args"),

  // Avoid running tests using both specs2 and junit runner.
  testFrameworks in Test := Seq(TestFrameworks.Specs2),

  // Override Play! defaults to enable parallel test execution
  testOptions in Test := Seq(Tests.Argument(TestFrameworks.Specs2, "junitxml", "console"))
)

