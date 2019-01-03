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

// part 1
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

class Worker {
    var node: Node? = null
    var remaining_load: Int? = null

    fun start(node: Node) {
        this.node = node
        remaining_load = node.name.first().toUpperCase() - 'A' + 1
    }

    fun decrement() {
        if (remaining_load != null) {
            remaining_load = remaining_load!! - 1
        }
    }

    fun isDone() = remaining_load == 0
}

// part 2
fun topsort2(path: String, workerNum: Int): String {
    val nodes = parseFile(path).toMutableList()
    val order = StringBuffer()
    val busyWorkers = mutableListOf<Worker>()
    val idleWorkers = mutableListOf<Worker>()
    for (i in 0 until workerNum) {
        idleWorkers.add(Worker())
    }
    while (true) {
        assignWork(nodes, idleWorkers, busyWorkers)
        tick(nodes, idleWorkers, busyWorkers, order)
        println("tick, order: $order")
        if (nodes.isEmpty() && busyWorkers.isEmpty()) {
            break
        }
    }

    return order.toString()
}

// time passes by 1 second
fun tick(nodes: MutableList<Node>, idleWorkers: MutableList<Worker>,
         busyWorkers: MutableList<Worker>, order: StringBuffer) {
    for (i in 0 until busyWorkers.size) {
        val worker = busyWorkers.removeAt(0)
        worker.decrement()
        if (worker.isDone()) {
            println("worker is done: ${worker.node!!.name}")
            order.append(worker.node!!.name.first())
            for (next in worker.node!!.nexts) {
                next.decrement()
                if (next.incoming == 0) {
                    println("adding next ${next.name}")
                    nodes.add(next)
                }
            }
            idleWorkers.add(worker)
        } else {
            // add it back
            busyWorkers.add(worker)
        }
    }
    println("after tick, nodes: $nodes, idleWorkers: $idleWorkers, busyWorkers: $busyWorkers")
}

fun assignWork(nodes: MutableList<Node>, idleWorkers: MutableList<Worker>,
               busyWorkers: MutableList<Worker>) {
    nodes.sortBy { it.name }
    while (nodes.isNotEmpty() && idleWorkers.isNotEmpty()) {
        val node = nodes.removeAt(0)
        val worker = idleWorkers.removeAt(0)
        worker.start(node)
        busyWorkers.add(worker)
    }
    println("after assignWork, nodes: $nodes, idleWorkers: $idleWorkers, busyWorkers: $busyWorkers")
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
