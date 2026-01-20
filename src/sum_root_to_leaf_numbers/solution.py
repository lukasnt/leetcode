from typing import Optional


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def sumNumbers(self, root: Optional[TreeNode]) -> int:
        if root is None:
            return 0
        elif root.left is None and root.right is None:
            return root.val
        return self.sub_sum_numbers(root.left, str(root.val)) + self.sub_sum_numbers(root.right, str(root.val))

    def sub_sum_numbers(self, root: Optional[TreeNode], number: str) -> int:
        if root is None:
            return 0
        elif root.left is None and root.right is None:
            return int(number + str(root.val))
        next_num = number + str(root.val)
        return self.sub_sum_numbers(root.left, next_num) + self.sub_sum_numbers(root.right, next_num)

    def main(self):
        print(self.sumNumbers(TreeNode(1, TreeNode(2), TreeNode(3))))
        print(self.sumNumbers(TreeNode(4, TreeNode(9, TreeNode(5), TreeNode(1)), TreeNode(0))))
        print(self.sumNumbers(TreeNode(1, None, TreeNode(3))))
        print(self.sumNumbers(TreeNode(1, TreeNode(3))))
        print(self.sumNumbers(TreeNode(1, None)))
        print(self.sumNumbers(None))

Solution().main()