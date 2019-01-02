package year2018.day7

import java.io.File
import java.lang.RuntimeException

class Node(val name: String) {
    var nexts: MutableList<Node> = mutableListOf()
    var incoming: Int = 0

    fun addNext(next: Node) {
        nexts.add(next)
        next.incoming += 1
    }
}

// Return a list of nodes with no incoming edges
//fun parseFile(path: String): List<Node> {
//   var nodes: MutableList<Node> = mutableListOf()
//    File(path).forEachLine { line ->
//
//    }
//}

// Step A must be finished before step L can begin.
fun parseLine(line: String): Pair<String, String> {
    val regex = """Step (\S+) must be finished before step (\S+) can begin.""".toRegex()
    if (regex.matches(line)) {
        val (_, name1, name2) = regex.find(line)!!.groupValues
        return Pair(name1, name2)
    } else {
        throw RuntimeException("Invalid input line: $line")
    }
}
