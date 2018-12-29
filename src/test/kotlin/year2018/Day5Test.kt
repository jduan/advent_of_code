package year2018.day5

import kotlin.test.assertEquals
import org.junit.Test
import java.io.File

class Day5Test {
  @Test
  fun test1() {
    assertEquals("dabCBAcaDA", reactor("dabAcCaCBAcCcaDA"))
    assertEquals("i", reactor("nVvNOoHhiJj"))
    assertEquals("p", reactor("nVvNOoHhiJjlLSuUvVsHhIp"))
  }

  @Test fun test2() {
    val inputFile = System.getProperty("user.dir") + "/src/test/kotlin/year2018/Day5Input.txt"
    assertEquals(11194, reactor(File(inputFile).readLines().first()).length)
  }
}
