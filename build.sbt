name := "bowtie"

description := "A bundle for bowtie tool"

homepage := Some(url("https://github.com/ohnosequences/bowtie"))

organization := "ohnosequences"

organizationHomepage := Some(url("http://ohnosequences.com"))

licenses := Seq("AGPLv3" -> url("http://www.gnu.org/licenses/agpl-3.0.txt"))

bundleObjects := Seq("ohnosequences.statika.Bowtie")

libraryDependencies ++= Seq( "ohnosequences" %% "boost" % "0.2.0-SNAPSHOT" ) 
