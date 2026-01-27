package convert_sorted_array_to_binary_search_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return subSortedArrayToBST(nums, 0, nums.size - 1)
    }

    fun subSortedArrayToBST(nums: IntArray, start: Int, end: Int): TreeNode? {
        if (end < start) return null
        val mid = (start + end) / 2
        val node = TreeNode(nums[mid])
        node.left = subSortedArrayToBST(nums, start, mid - 1)
        node.right = subSortedArrayToBST(nums, mid + 1, end)
        return node
    }

    fun treeNodeString(node: TreeNode?): String {
        if (node == null) return ""
        return "{ val: ${node.`val`}, left: ${treeNodeString(node.left)}, right: ${treeNodeString(node.right)} }"
    }

    fun printTree(node: TreeNode?) {
        println(treeNodeString(node))
    }

}

fun main() {
    val sol = Solution()
    sol.printTree(sol.sortedArrayToBST(intArrayOf(-10, -3, 0, 5, 9)))
    sol.printTree(sol.sortedArrayToBST(intArrayOf(1, 3)))
    sol.printTree(sol.sortedArrayToBST(intArrayOf(1)))
    sol.printTree(sol.sortedArrayToBST(intArrayOf()))
    sol.printTree(sol.sortedArrayToBST(intArrayOf(1,2,3,4,5,6,7,8)))
}