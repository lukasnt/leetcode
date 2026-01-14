from typing import Optional, List


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


class Solution:
    def levelOrderBottom(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None: return []
        left = self.levelOrderBottom(root.left)
        right = self.levelOrderBottom(root.right)
        sub_len = max(len(left), len(right))
        res = [[] for _ in range(sub_len)]
        for l in range(len(left)):
            res[l + sub_len - len(left)].extend(left[l])
        for r in range(len(right)):
            res[r + sub_len - len(right)].extend(right[r])
        res.append([root.val])
        return res

    def main(self):
        print(self.levelOrderBottom(TreeNode(3, TreeNode(9), TreeNode(20, TreeNode(15), TreeNode(7)))))
        print(self.levelOrderBottom(TreeNode(1)))
        print(self.levelOrderBottom(None))
        print(self.levelOrderBottom(TreeNode(3, TreeNode(9, TreeNode(20), TreeNode(21)), TreeNode(20, TreeNode(15), TreeNode(7)))))

Solution().main()