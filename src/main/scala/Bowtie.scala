package ohnosequences.statika

import ohnosequences.statika._
import sys.process._
import java.io.File
import java.net.URL

case object Bowtie extends Bundle(Boost :: HNil) {

  val metadata = generated.metadata.Bowtie

  def install[D <: DistributionAux](distribution: D): InstallResults = {
    val trace = List[ProcessBuilder](
      // dowloading archive
      new URL("http://sourceforge.net/projects/bowtie-bio/files/bowtie2/2.1.0/bowtie2-2.1.0-linux-x86_64.zip/download") #> 
        new File("bowtie2-2.1.0.zip")
      // extracting archive
      // (with assumption that it contains bowtie2-2.1.0 folder inside)
    , Seq("unzip", "bowtie2-2.1.0.zip")
      // copying binaries to PATH
      // (this call is made through bash to expand * wildcard)
    , Seq("sh", "-c", "cp bowtie2-2.1.0/bowtie2* /usr/bin/")
    // folding this list of commands accumulating results
    // is something failed, we have the trace of successfull commands before 
    // and the last which failed
    ).foldLeft(List[InstallResult]()){ (acc, cmd) => 
      if (acc exists (_.isLeft)) acc
      else if (cmd.! != 0) acc ::: failure(cmd.toString)
      else acc ::: success(cmd.toString)
    }

    if (trace exists (_.isLeft)) trace
    else success("%s is installed" format metadata)
  }

}
