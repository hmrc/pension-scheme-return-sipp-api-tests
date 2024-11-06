lazy val root = (project in file("."))
  .settings(
    name := "pension-scheme-return-sipp-api-tests",
    version := "0.1.0",
    scalaVersion := "3.3.3",
    libraryDependencies ++= Dependencies.test,
    (Compile / compile) := ((Compile / compile) dependsOn (Compile / scalafmtSbtCheck, Compile / scalafmtCheckAll)).value
  )
