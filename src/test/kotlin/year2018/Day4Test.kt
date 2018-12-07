package year2018.day4

import kotlin.test.assertEquals
import org.junit.Test

class Day4Test {
  @Test fun test1() {
    assertEquals(ShiftStarts(23, 59, 1559), parseLine("[1518-02-07 23:59] Guard #1559 begins shift"))
  }
}
