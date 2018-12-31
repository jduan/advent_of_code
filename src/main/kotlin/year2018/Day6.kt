package year2018.day6

import java.io.File

// Manhattan Distance: https://en.wikipedia.org/wiki/Taxicab_geometry

data class Coordinate(val x: Int, val y: Int)

fun parseFile(path: String): List<Coordinate> =
    File(path).readLines().map { line ->
      val parts = line.split(",")
      Coordinate(parts[0].toInt(), parts[1].trim().toInt())
    }

data class Boundary(val minX: Int, val minY: Int, val maxX: Int, val maxY: Int)

fun getBoundary(coords: List<Coordinate>): Boundary {
  val xs = coords.map { coord -> coord.x }
  val ys = coords.map { coord -> coord.y }

  return Boundary(xs.min()!!, ys.min()!!, xs.max()!!, ys.max()!!)
}
