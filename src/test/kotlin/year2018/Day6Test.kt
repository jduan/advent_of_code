package year2018.day6

import com.sun.tools.corba.se.idl.constExpr.BooleanNot
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

  @Test fun test2() {
    val coords = listOf<Coordinate>(
        Coordinate(224, 153),
        Coordinate(176, 350),
        Coordinate(353, 241),
        Coordinate(207, 59),
        Coordinate(145, 203),
        Coordinate(123, 210),
        Coordinate(113, 203),
        Coordinate(191, 241)
    )
    assertEquals(Boundary(113, 59, 353, 350), getBoundary(coords))
  }
}
