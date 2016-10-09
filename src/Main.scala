/**
  * Created by neo on 08.10.16.
  */
object Main extends App {

  val problem1Dimensions = Seq(2, 10, 50, 100, 150, 200)
  val problem1Precision = 1000

  /**Problem 1**/

  /*problem1Dimensions.foreach { dimension =>
    val (ev1, var1) = RNG.getRandomPointWithVertexDiffEvAndVariance(dimension, problem1Precision)
    println(s"Diff from zero vertex: dimension: $dimension. EV: $ev1. StdDev: ${Math.sqrt(var1)}. Var: $var1")
    val (ev2, var2) = RNG.get2RandomPointsDiffEvAndVariance(dimension, problem1Precision)
    println(s"Diff between 2 random points: dimension: $dimension. EV: $ev2. StdDev: ${Math.sqrt(var2)}. Var: $var2")
  }*/

  val problem2Precision = 1500

  /**Problem 2**/

  val problem2ADimensions = Seq(10, 50, 100, 150, 200)

/*  val problem2BDimensions = 2 to 200
  problem2BDimensions.foreach { dimension =>
    val ev2BHyperCube = RNG.getRandomPointDistanceEvInHyperCube(dimension, problem2Precision)
    val ev2BHyperBall = RNG.getRandomPointDistanceEvInHyperBall(dimension, problem2Precision)
    println(s"Dimension: $dimension. Distance from (0, 0, ..., 0) point EV in: HyperCube: $ev2BHyperCube. HyperBall: $ev2BHyperBall")
  }*/

  val problem2CDimensions = Seq(10, 50, 75, 100, 150, 200)
  problem2CDimensions.foreach { dimension =>
    RNG.getRandomPointDistanceEvInHyperCube(dimension, problem2Precision)
    RNG.getRandomPointDistanceEvInHyperBall(dimension, problem2Precision)
  }


}
