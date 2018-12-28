package year2018.day5

import java.io.File

fun reactor(polymer: String): String {
  val size = polymer.length
  if (size < 2) {
    return polymer
  }

  val marked = mutableSetOf<Int>()

  var previous = 0
  var current = 1
  while (current < size) {
    val previousChar = polymer[previous]
    val currentChar = polymer[current]
    val diff = currentChar - previousChar
    if (diff == 32 || diff == -32) {
      // collapse
      marked.add(current)
      marked.add(previous)
      current += 1
      previous -= 1
    } else {
      previous = current
      current += 1
    }
  }

//  if (current - previous == 1) {
//    remains.append(polymer.last())
//  }

  val remains = StringBuffer()
  for (i in 0 until size) {
    if (!marked.contains(i))
      remains.append(polymer[i])
  }

  return remains.toString()
}
