package ohnosequences.statika.bundles

import ohnosequences.statika._
import sys.process._
import java.io.File
import java.net.URL

abstract class AbstractBowtie(bowtieN: String, version: String) extends Bundle() {

  val packageName: String = bowtieN + "-" + version

  override def install[D <: AnyDistribution](d: D): InstallResults = {
        // dowloading archive
     ( {new URL("http://sourceforge.net/projects/bowtie-bio/files/"+bowtieN+"/"+version+"/"+packageName+"-linux-x86_64.zip/download") #> new File(packageName+".zip")}
        // extracting archive (with assumption that it contains <packageName> folder inside)
    -&- Seq("unzip", packageName+".zip")
        // copying binaries to PATH
    -&- Seq("bash", "-c", "cp " + packageName+"/bowtie* /usr/bin/")
    ->- success(name + " is installed")
     )
  }

}

case object Bowtie  extends AbstractBowtie("bowtie", "1.0.0")
case object Bowtie2 extends AbstractBowtie("bowtie2", "2.1.0")
