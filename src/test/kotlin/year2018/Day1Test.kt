package year2018

import kotlin.test.assertEquals
import org.junit.Test

class Day1Test {
  @Test fun f() {
    val inputFile = System.getProperty("user.dir") + "/src/test/kotlin/year2018/Day1Input.txt"
    assertEquals(510, calculateFrequency(inputFile))
  }
}