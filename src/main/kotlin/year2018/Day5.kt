package year2018.day5

import java.util.*

fun reactor(polymer: String): String {
  val stack = Stack<Char>()

  polymer.forEach { char ->
    if (stack.empty()) {
      stack.push(char)
    } else {
      val top = stack.peek()
      val diff = top - char
      if (diff == 32 || diff == -32) {
        stack.pop()
      } else {
        stack.push(char)
      }
    }
  }

  return stack.toList().joinToString(separator = "")
}
