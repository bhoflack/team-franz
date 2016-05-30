lazy val root = (project in file(".")).
    settings(
        name := "producer-streams",
        scalaVersion := "2.11.7",
        libraryDependencies ++= Seq(
            "org.apache.kafka" % "connect-runtime" % "0.10.0.0",
            "org.apache.kafka" % "connect-api" % "0.10.0.0",
            "org.apache.kafka" % "kafka-streams" % "0.10.0.0",
            "org.apache.kafka" %% "kafka" % "0.10.0.0"
          )
      )

