package year2018.day6

import kotlin.test.assertEquals
import org.junit.Test

class Day6Test {
  @Test fun test1() {
    val inputFile = System.getProperty("user.dir") + "/src/test/kotlin/year2018/Day6TestInput.txt"
    val expected = listOf<Coordinate>(
        Coordinate(224, 153),
        Coordinate(176, 350)
    )
    assertEquals(expected, parseFile(inputFile))
  }
}
