from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def isBalanced(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        return (abs(self.depth(root.left) - self.depth(root.right)) <= 1
                and self.isBalanced(root.left)
                and self.isBalanced(root.right))

    def depth(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        return max(self.depth(root.left), self.depth(root.right)) + 1

    def main(self):
        print(self.isBalanced(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
        print(self.isBalanced(TreeNode(1, TreeNode(2, TreeNode(3, TreeNode(4), TreeNode(4)), TreeNode(3)), TreeNode(2))))

Solution().main()