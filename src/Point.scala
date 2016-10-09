import scala.util.Random

/**
  * Created by neo on 08.10.16.
  */
case class Point(dimension: Int, coordinates: List[Double]) {

  def normalize(radius: Double): Point = {
    val norm = Math.sqrt(coordinates.map(c => c*c).sum)
    val randomNorm = norm/Random.nextDouble()
    val newCoordinates = coordinates.map(c => c*radius/randomNorm)
    copy(coordinates = newCoordinates)
  }

  def diff(other: Point): Double = {
    if (dimension != other.dimension)
      throw new IllegalArgumentException("Different dimension of the other point.")
    val diffVector = (coordinates, other.coordinates).zipped map
      ((a,b) => (a - b) * (a - b))
    Math.sqrt(diffVector.sum)
  }

  override def toString = coordinates.toString
}

object Point {
  def apply(dim: Int) = new Point(dim, (1 to dim).map(_ => Random.nextDouble()).toList)
  def zero(dim: Int) = new Point(dim, (1 to dim).map(_ => 0.0).toList)
}

object PointInHyperCube {
  def apply(dim: Int): Point = new Point(dim, (1 to dim).map(_ => Random.nextDouble()-0.5).toList)
}

object PointInHyperBall {
  val radius = 0.5

  def apply(dim: Int): Point = {
    PointInHyperCube(dim).normalize(radius)
  }
}
