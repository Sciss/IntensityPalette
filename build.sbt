lazy val commonSettings = Seq(
  name             := "IntensityPalette",
  version          := "1.0.2",
  organization     := "de.sciss",
  scalaVersion     := "2.13.3",
  crossPaths       := false,
  autoScalaLibrary := false,
  description      := "Color palette for displaying intensities, optimized for perceptual uniformity",
  homepage         := Some(url(s"https://github.com/Sciss/${name.value}")),
  licenses         := Seq("BSD-style" -> url(s"https://raw.github.com/Sciss/${name.value}/main/LICENSE")),
  scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature"),
  javacOptions in Compile ++= Seq("-g", "-target", "1.8", "-source", "1.8"),
  javacOptions in (Compile, doc) := Nil,  // does not understand 'target'
  scalacOptions in (Compile, compile) ++= (if (scala.util.Properties.isJavaAtLeast("9")) Seq("-release", "8") else Nil), // JDK >8 breaks API; skip scala-doc
)

lazy val root = project.in(file("."))
  .settings(commonSettings)
  .settings(publishSettings)
  .settings(
    mainClass in Test := Some("de.sciss.intensitypalette.Demo")
  )

lazy val publishSettings = Seq(
  publishMavenStyle := true,
  publishTo := {
    Some(if (isSnapshot.value)
      "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    else
      "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
    )
  },
  publishArtifact in Test := false,
  pomIncludeRepository := { _ => false },
  pomExtra := { val n = name.value
<scm>
  <url>git@github.com:Sciss/{n}.git</url>
  <connection>scm:git:git@github.com:Sciss/{n}.git</connection>
</scm>
<developers>
   <developer>
      <id>sciss</id>
      <name>Hanns Holger Rutz</name>
      <url>http://www.sciss.de</url>
   </developer>
</developers>
}
)
