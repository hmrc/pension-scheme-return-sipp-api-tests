lazy val root = (project in file("."))
  .settings(
    name := "pension-scheme-return-sipp-api-tests",
    version := "0.1.0",
    scalaVersion := "2.13.12",
    scalacOptions ++= Seq("-feature"),
    libraryDependencies ++= Dependencies.test,
    (Compile / compile) := ((Compile / compile) dependsOn (Compile / scalafmtSbtCheck, Compile / scalafmtCheckAll)).value
  )
