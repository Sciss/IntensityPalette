name             := "IntensityPalette"
version          := "1.0.1-SNAPSHOT"
organization     := "de.sciss"
scalaVersion     := "2.12.6"
crossPaths       := false
autoScalaLibrary := false
description      := "Color palette for displaying intensities, optimized for perceptual uniformity"
homepage         := Some(url(s"https://github.com/Sciss/${name.value}"))
licenses         := Seq("BSD-style" -> url(s"https://raw.github.com/Sciss/${name.value}/master/LICENSE"))
scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

// ---- publishing ----

publishMavenStyle := true

publishTo := {
  Some(if (isSnapshot.value)
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

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

