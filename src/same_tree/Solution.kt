package same_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if ((p == null && q != null) || (q == null && p != null)) return false
        if (p == null || q == null) return true
        return p.`val` == q.`val` && isSameTree(p.left, q.left) && isSameTree(p.right, q.right)
    }
}