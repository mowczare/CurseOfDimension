/**
  * Created by neo on 08.10.16.
  */
object RNG {

  def getRandomPointDistanceEvInHyperCube(problemDimension: Int, problemPrecision: Int) = {
    getRandomPointDistanceEv(problemDimension, problemPrecision, PointInHyperCube.apply, "HyperCubeDistances")
  }

  def getRandomPointDistanceEvInHyperBall(problemDimension: Int, problemPrecision: Int) = {
    getRandomPointDistanceEv(problemDimension, problemPrecision, PointInHyperBall.apply, "HyperBallDistances")
  }

  def get2RandomPointsDiffEvAndVariance(problemDimension: Int, problemPrecision: Int) = {
    getDiffEvAndVariance(problemDimension, problemPrecision, Point.apply)
  }

  def getRandomPointWithVertexDiffEvAndVariance(problemDimension: Int, problemPrecision: Int) = {
    getDiffEvAndVariance(problemDimension, problemPrecision, Point.zero)
  }

  private def getDiffEvAndVariance(problemDimension: Int, problemPrecision: Int, pointMaker: (Int => Point)) = {
    //val writer = IO.createFileWriter(s"dimension-$problemDimension-diffs")
      val diffs = (1 to problemPrecision).map { _ =>
        val a = pointMaker(problemDimension)
        val b = Point(problemDimension)
        val diff = a.diff(b)
        //writer.println(diff)
        diff
      }
      //writer.close()
      //val writer2 = IO.createFileWriter(s"dimension-$problemDimension-stats")
    val ev = diffs.sum / problemPrecision
    val variance = diffs.map(d =>
    (d - ev) * (d - ev)
    ).sum
    //writer2.println(s"EV: $ev\nVariance: ${variance / problemPrecision}")
    //writer2.close()
    (ev, variance / problemPrecision)
  }

  private def getRandomPointDistanceEv(problemDimension: Int, problemPrecision: Int, pointMaker: (Int => Point), filename: String) = {
    val fw = IO.createFileWriter(s"$filename-dimension-$problemDimension")
    val zeroPoint = Point.zero(problemDimension)
    val diffs = (1 to problemPrecision).map { _ =>
      pointMaker(problemDimension).diff(zeroPoint)
    }
    diffs.sorted.zip(1 to problemPrecision).foreach{ case (r: Double, n: Int) =>
      fw.println(s"$r $n")
    }
    fw.close()
    diffs.sum / problemPrecision
  }
}
