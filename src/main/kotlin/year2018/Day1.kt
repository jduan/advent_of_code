package year2018

import java.io.File

fun calculateFrequency(inputFile: String): Long {
  var frequency = 0L
  File(inputFile).forEachLine {
    frequency += it.toInt()
  }
  return frequency
}