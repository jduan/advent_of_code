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

  @Test fun test4() {
    val inputFile = System.getProperty("user.dir") + "/src/test/kotlin/year2018/Day4TestInput.txt"
    val expectedResult = mapOf<Int, GuardSleep>(
        1559 to GuardSleep(1559).addSleep(Sleep(16, 37)).addSleep(Sleep(44, 53)).addSleep(Sleep(56, 57)),
        71 to GuardSleep(71).addSleep(Sleep(6, 59)).addSleep(Sleep(49, 58)),
        2521 to GuardSleep(2521).addSleep(Sleep(30, 44)).addSleep(Sleep(49, 57)),
        211 to GuardSleep(211).addSleep(Sleep(45, 58)).addSleep(Sleep(33, 42)).addSleep(Sleep(53, 58)),
        829 to GuardSleep(829).addSleep(Sleep(1, 56)),
        1567 to GuardSleep(1567).addSleep(Sleep(46, 49)).addSleep(Sleep(28, 38))
    )
    assertEquals(expectedResult, parseFile(inputFile))
  }

}
