package year2018.day4

import year2018.findAllCoveredSquares
import java.io.File

data class Sleep(
    // The minute the sleep starts
    val start: Int,
    // The minute the sleep ends
    val end: Int
)

data class GuardSleep(
    val guardId: Int
) {
  private val sleeps = mutableListOf<Sleep>()

  fun addSleep(sleep: Sleep) {
    sleeps.add(sleep)
  }
}

sealed class Event(open val hour: Int, open val minute: Int)

data class ShiftStarts(
    val guardId: Int,
    override val hour: Int,
    override val minute: Int
) : Event(hour, minute)

data class FallAsleep(
    override val hour: Int,
    override val minute: Int
) : Event(hour, minute)

data class WakesUp(
    override val hour: Int,
    override val minute: Int
) : Event(hour, minute)

fun parseLine(line: String): Event {
  val shiftStartsRegex = """\[\d{4}-\d{2}-\d{2} (\d{2}):(\d{2})\] Guard #(\d+) begins shift""".toRegex()
  val fallAsleepRegex = """\[\d{4}-\d{2}-\d{2} (\d{2}):(\d{2})\] falls asleep""".toRegex()
  val wakesUpRegex = """\[\d{4}-\d{2}-\d{2} (\d{2}):(\d{2})\] wakes up""".toRegex()
  return when {
    shiftStartsRegex.matches(line) -> {
      val (_, hour, minute, guardId) = shiftStartsRegex.find(line)!!.groupValues
      ShiftStarts(hour.toInt(), minute.toInt(), guardId.toInt())
    }
    fallAsleepRegex.matches(line) -> {
      val (_, hour, minute, guardId) = fallAsleepRegex.find(line)!!.groupValues
      FallAsleep(hour.toInt(), minute.toInt())
    }
    wakesUpRegex.matches(line) -> {
      val (_, hour, minute, guardId) = wakesUpRegex.find(line)!!.groupValues
      WakesUp(hour.toInt(), minute.toInt())
    }
    else -> throw Exception("Unexpected line: $line")
  }
}

//fun parseFile(path: String): Map<Int, List<GuardSleep>> {
//  File(path).forEachLine { line ->
//
//  }
//}

// Find the guard that spent the most minutes asleep.

// Find the minute the guard that was asleep the most.
