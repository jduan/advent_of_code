package year2018.day7

import kotlin.test.assertEquals
import org.junit.Test

class Day7Test {
  @Test
  fun test1() {
    assertEquals(Pair("A", "L"),
            parseLine("Step A must be finished before step L can begin."))
  }
}
