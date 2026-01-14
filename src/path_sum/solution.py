from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def pathSum(self, root: Optional[TreeNode], targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        elif root.left is None and root.right is None:
            if root.val == targetSum:
                return [[root.val]]
            else:
                return []
        left = self.subPathSum(root.left, root.val, targetSum)
        right = self.subPathSum(root.right, root.val, targetSum)
        result: List[List[int]] = []
        for res in left:
            result.append([root.val] + res)
        for res in right:
            result.append([root.val] + res)
        return result

    def subPathSum(self, root: Optional[TreeNode], currentSum: int, targetSum: int) -> List[List[int]]:
        if root is None:
            return []
        elif root.left is None and root.right is None:
            if currentSum + root.val == targetSum:
                return [[root.val]]
            else:
                return []
        left = self.subPathSum(root.left, root.val + currentSum, targetSum)
        right = self.subPathSum(root.right, root.val + currentSum, targetSum)
        result: List[List[int]] = []
        for res in left:
            result.append([root.val] + res)
        for res in right:
            result.append([root.val] + res)
        return result

    def main(self):
        print(self.pathSum(
            TreeNode(5, TreeNode(4, TreeNode(11, TreeNode(7), TreeNode(2))),
                     TreeNode(8, TreeNode(13), TreeNode(4, TreeNode(5), TreeNode(1)))),
            22
        ))
        print(self.pathSum(
            TreeNode(1, TreeNode(2), TreeNode(3)),
            5
        ))
        print(self.pathSum(
            TreeNode(1, TreeNode(2)),
            0
        ))
        print(self.pathSum(
            TreeNode(1, TreeNode(2), TreeNode(3)),
            4
        ))
        print(self.pathSum(
            TreeNode(0),
            0
        ))
        print(self.pathSum(
            None,
            0
        ))


Solution().main()
