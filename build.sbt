name := "bowtie"

description := "A bundle for bowtie tool"

homepage := Some(url("https://github.com/ohnosequences/bowtie"))

licenses := Seq("AGPLv3" -> url("http://www.gnu.org/licenses/agpl-3.0.txt"))

bundleObjects := Seq("ohnosequences.statika.Bowtie")

libraryDependencies ++= Seq( "ohnosequences" %% "boost" % "0.1.0-SNAPSHOT" ) 
