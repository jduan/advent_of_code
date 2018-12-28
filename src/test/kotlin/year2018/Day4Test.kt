package year2018.day4

import kotlin.test.assertEquals
import org.junit.Test

class Day4Test {
  @Test fun test1() {
    assertEquals(ShiftStarts(1559, 23, 59),
        parseLine("[1518-02-07 23:59] Guard #1559 begins shift"))
  }

  @Test fun test2() {
    assertEquals(FallAsleep(0, 16),
        parseLine("[1518-02-08 00:16] falls asleep"))
  }

  @Test fun test3() {
    assertEquals(WakesUp(0, 37),
        parseLine("[1518-02-08 00:37] wakes up"))
  }
}
