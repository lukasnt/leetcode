package minimum_genetic_mutation

class Solution {
    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        val bankMap = bank.withIndex()
            .associate { it.value to it.index + 1 }
            .plus( startGene to 0 )
        val edges = Array<MutableSet<Int>>(bank.size + 1) { HashSet() }
        for (b in 0 until bank.size) {
            val gene = bank[b]
            for (i in 0 until gene.length) {
                for (c in listOf('A', 'C', 'T', 'G')) {
                    if (c != gene[i]) {
                        val newGene = gene.substring(0, i) + c + gene.substring(i + 1)
                        if (bankMap.contains(newGene)) {
                            edges[b + 1].add(bankMap[newGene]!!)
                            edges[bankMap[newGene]!!].add(b + 1)
                        }
                    }
                }
            }
        }
        val queue = ArrayDeque<Pair<Int, Int>>()
        val visited = BooleanArray(edges.size)
        queue.add(0 to 0)
        while (queue.isNotEmpty()) {
            val (index, length) = queue.removeFirst()
            if (index == bankMap[endGene]) return length
            if (!visited[index]) {
                for (e in edges[index]) {
                    queue.add(e to length + 1)
                }
                visited[index] = true
            }
        }
        return -1
    }
}

fun main() {
    val sol = Solution()
    println(sol.minMutation("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA")))
    println(sol.minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGGTA","AACCGCTA","AAACGGTA")))
    println(sol.minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGCTA","AAACGGTA")))
}