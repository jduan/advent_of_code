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

    fun decrement() {
        incoming--
    }

    override fun toString(): String {
        return "Node(name: $name, incoming: $incoming)"
    }
}

fun topsort(path: String): String {
    val nodes = parseFile(path).toMutableList()
    val order = StringBuffer()
    while (nodes.isNotEmpty()) {
        val node = nodes.sortedBy { it.name }.first()
        nodes.remove(node)
        order.append(node.name)
        for (next in node.nexts) {
            next.decrement()
            if (next.incoming == 0) {
                nodes.add(next)
            }
        }
    }

    return order.toString()
}

// Return a list of nodes with no incoming edges
fun parseFile(path: String): List<Node> {
   var nodes: MutableMap<String, Node> = mutableMapOf()
    File(path).forEachLine { line ->
        val pair = parseLine(line)
        val name1 = pair.first
        val name2 = pair.second
        val node1 = nodes.getOrDefault(name1, Node(name1))
        val node2 = nodes.getOrDefault(name2, Node(name2))
        node1.addNext(node2)
        nodes.put(name1, node1)
        nodes.put(name2, node2)
    }

    return nodes.values.filter { it.incoming == 0 }
}

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
