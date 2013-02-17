name := "IntensityPalette"

version := "1.0.0"

organization := "de.sciss"

scalaVersion := "2.10.0"

crossPaths := false

autoScalaLibrary := false

description := "Color palette for displaying intensities, optimized for perceptual uniformity"

homepage <<= name { n => Some(url("https://github.com/Sciss/" + n)) }

licenses <<= name { n => Seq("BSD-style" -> url("https://raw.github.com/Sciss/" + n + "/master/LICENSE")) }

retrieveManaged := true

scalacOptions ++= Seq("-deprecation", "-unchecked", "-feature")

// ---- publishing ----

publishMavenStyle := true

publishTo <<= version { (v: String) =>
  Some(if (v endsWith "-SNAPSHOT")
    "Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
  else
    "Sonatype Releases"  at "https://oss.sonatype.org/service/local/staging/deploy/maven2"
  )
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra <<= name { n =>
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

