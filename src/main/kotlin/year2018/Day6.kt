package year2018.day6

import java.io.File

// Manhattan Distance: https://en.wikipedia.org/wiki/Taxicab_geometry

data class Coordinate(val x: Int, val y: Int)

fun parseFile(path: String): List<Coordinate> =
    File(path).readLines().map { line ->
      val parts = line.split(",")
      Coordinate(parts[0].toInt(), parts[1].trim().toInt())
    }
