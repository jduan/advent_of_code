package year2018

import java.io.File

data class Rectangle(
    val x: Int,
    val y: Int,
    val width: Int,
    val height: Int
) {
  /**
   * Return a list of pairs (x, y) that are covered by this rectangle.
   */
  fun coveredCells(): List<Pair<Int, Int>> {
    val pairs = mutableListOf<Pair<Int, Int>>();
    for (i in 0 until width) {
      for (j in 0 until height) {
        pairs.add(Pair(x + i, y + j))
      }
    }

    return pairs
  }
}

fun findSquareInches(path: String): Int {
  val coveredTimes = mutableMapOf<Pair<Int, Int>, Int>()
  File(path).forEachLine {
    val rectangle = parseLine(it)
    val pairs = rectangle.coveredCells()
    for (pair in pairs) {
      if (pair in coveredTimes) {
        coveredTimes[pair] = coveredTimes[pair]!! + 1
      } else {
        coveredTimes[pair] = 1
      }
    }
  }

  var squareInches = 0
  for (pair in coveredTimes.keys) {
    if (coveredTimes[pair]!! > 1) {
      squareInches++
    }
  }

  return squareInches
}

/**
 * Parse a string like:
 * #16 @ 859,624: 21x19
 * and return a Rectangle object.
 */
fun parseLine(line: String): Rectangle {
  val re = """#\d+\s+@\s+(\d+),(\d+):\s+(\d+)x(\d+)""".toRegex()
  val parts = re.find(line)!!.groupValues
  return Rectangle(parts[1].toInt(), parts[2].toInt(), parts[3].toInt(), parts[4].toInt())
}
