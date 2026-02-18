package evaluate_division

class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        val products = productGraph(equations, values)
        val result = DoubleArray(queries.size) { -1.0 }
        for (q in 0 until queries.size) {
            val (from, to) = queries[q]
            if (products[from] != null && products[from]!![to] != null) {
                result[q] = products[from]!![to]!!
                continue
            }
            val visited = HashSet<String>()
            val queue = LinkedHashSet<Pair<String, Double>>()
            queue.add(from to 1.0)
            while (queue.isNotEmpty()) {
                val (current, totalProd) = queue.first()
                queue.remove(current to totalProd)
                if (current !in visited) {
                    visited.add(current)
                } else {
                    continue
                }
                for (prod in products.getOrDefault(current, emptyMap())) {
                    if (prod.key !in visited) {
                        products[from]!![prod.key] = totalProd * prod.value
                        queue.add(prod.key to totalProd * prod.value)
                    }
                }
            }
            if (products[from] != null && products[from]!![to] != null) {
                result[q] = products[from]!![to]!!
            }
        }
        return result
    }

    fun productGraph(equations: List<List<String>>, values: DoubleArray): MutableMap<String, MutableMap<String, Double>> {
        val products = HashMap<String, MutableMap<String, Double>>()
        for (i in 0 until equations.size) {
            val eq = equations[i]
            val q = values[i]
            if (!products.containsKey(eq[0])) {
                products[eq[0]] = mutableMapOf(eq[1] to q, eq[0] to 1.0)
            } else {
                products[eq[0]]!![eq[1]] = q
            }
            if (!products.containsKey(eq[1])) {
                products[eq[1]] = mutableMapOf(eq[0] to 1 / q, eq[1] to 1.0)
            } else {
                products[eq[1]]!![eq[0]] = 1 / q
            }
        }
        return products
    }
}

fun main() {
    val sol = Solution()
    println(sol.calcEquation(
        listOf(listOf("a","b"), listOf("b","c")),
        doubleArrayOf(2.0,3.0),
        listOf(listOf("a","c"), listOf("b","a"), listOf("a","e"), listOf("a","a"), listOf("x","x"))
    ).contentToString())
    println(sol.calcEquation(
        listOf(listOf("a","b"), listOf("b","c"), listOf("bc","cd")),
        doubleArrayOf(1.5,2.5,5.0),
        listOf(listOf("a","c"), listOf("c","b"), listOf("bc","cd"), listOf("cd","bc"))
    ).contentToString())
    println(sol.calcEquation(
        listOf(listOf("a","b")),
        doubleArrayOf(0.5),
        listOf(listOf("a","b"), listOf("b","a"), listOf("a","c"), listOf("x","y"))
    ).contentToString())
    println(sol.calcEquation(
        listOf(listOf("a","b"), listOf("b","c"), listOf("b","cd"), listOf("bc","cd")),
        doubleArrayOf(1.5,2.5,3.0,5.0),
        listOf(listOf("a","bc"))
    ).contentToString())
}