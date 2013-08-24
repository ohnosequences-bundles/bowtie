package ohnosequences.statika

import ohnosequences.statika._
import sys.process._

case object Bowtie extends Bundle(Boost :: HNil) {

  val metadata = generated.metadata.Bowtie

  def install[D <: DistributionAux](distribution: D): InstallResults = {
    val results = List(
      "mkdir -p /opt/bowtie"
    , "cd /opt/bowtie"
    , "wget http://sourceforge.net/projects/bowtie-bio/files/bowtie2/2.1.0/bowtie2-2.1.0-linux-x86_64.zip/download -O bowtie2-2.1.0-linux-x86_64.zip"
    , "unzip bowtie2-2.1.0-linux-x86_64.zip"
    , "cd bowtie2-2.1.0"
    , "cp bowtie2 bowtie2-* /usr/bin/"
    ).foldLeft(List[InstallResult]()){ (acc, cmd) => 
      if (acc exists (_.isLeft)) acc
      else if (cmd.! != 0) acc ::: failure(cmd)
      else acc ::: success(cmd)
    }
    if (results exists (_.isLeft)) results
    else success("%s is installed" format metadata)
  }

}
