import sys
from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def minDepth(self, root: Optional[TreeNode]) -> int:
        if not root:
            return 0
        elif root.left is None and root.right is None:
            return 1
        left = self.minDepth(root.left) if root.left is not None else sys.maxsize
        right = self.minDepth(root.right) if root.right is not None else sys.maxsize
        return min(left, right) + 1

    def main(self):
        print(self.minDepth(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
        print(self.minDepth(TreeNode(2, None, TreeNode(3, None, TreeNode(4, None, TreeNode(5, None, TreeNode(6)))))))
        print(self.minDepth(TreeNode(1)))
        print(self.minDepth(None))


Solution().main()
