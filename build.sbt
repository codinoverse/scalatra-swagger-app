val ScalatraVersion = "3.1.0"
ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.3"

lazy val root = (project in file("."))
  .settings(
    name := "scalatra-swagger-app",
    libraryDependencies ++= Seq(
      "org.json4s" %% "json4s-native" %"4.0.6",
      "org.scalatra"%% "scalatra-swagger-jakarta" % ScalatraVersion,
      "org.scalatra" %% "scalatra-jakarta" % ScalatraVersion,
      "org.scalatra" %% "scalatra-scalatest-jakarta" % ScalatraVersion % "test",
      "ch.qos.logback" % "logback-classic" % "1.5.6" % "runtime",
      "org.eclipse.jetty.ee10" % "jetty-ee10-webapp" % "12.0.10" % "container",
      "jakarta.servlet" % "jakarta.servlet-api" % "6.0.0" % "provided"
    ),
  )

enablePlugins(SbtTwirl)
enablePlugins(JettyPlugin)
Jetty / containerLibs := Seq("org.eclipse.jetty.ee10" % "jetty-ee10-runner" % "12.0.10" intransitive())
Jetty / containerMain := "org.eclipse.jetty.ee10.runner.Runner"
