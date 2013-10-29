package ohnosequences.statika

import ohnosequences.statika._
import sys.process._
import java.io.File
import java.net.URL

case object Boost extends YumBundle("boost")

case object Bowtie extends Bundle(Boost :+: ∅) {

  def install[D <: AnyDistribution](distribution: D): InstallResults = {
        // dowloading archive
     ( {new URL("http://sourceforge.net/projects/bowtie-bio/files/bowtie2/2.1.0/bowtie2-2.1.0-linux-x86_64.zip/download") #> new File("bowtie2-2.1.0.zip")}
        // extracting archive (with assumption that it contains bowtie2-2.1.0 folder inside)
    -&- "unzip bowtie2-2.1.0.zip"
        // copying binaries to PATH
    -&- "cp bowtie2-2.1.0/bowtie2* /usr/bin/"
    ->- success(name + " is installed")
     )
  }

}
