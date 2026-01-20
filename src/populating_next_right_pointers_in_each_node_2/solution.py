class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next


class Solution:
    def connect(self, root: 'Node') -> Node:
        if root is None:
            return None
        if root.left is None and root.right is None:
            return root
        left_heads = self.head_connect(root.left)
        right_tail = self.tail_connect(root.right)
        for i in range(len(left_heads)):
            head = left_heads[i]
            if i < len(right_tail):
                head.next = right_tail[i]
        return root


    def tail_connect(self, root: 'Node') -> list['Node']:
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root]
        left_heads = self.head_connect(root.left)
        right_tail = self.tail_connect(root.right)
        for i in range(len(left_heads)):
            head = left_heads[i]
            if i < len(right_tail):
                head.next = right_tail[i]
        return self.tails(root)

    def head_connect(self, root: 'Node') -> list['Node']:
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root]
        left_heads = self.head_connect(root.left)
        right_tail = self.tail_connect(root.right)
        for i in range(len(left_heads)):
            head = left_heads[i]
            if i < len(right_tail):
                head.next = right_tail[i]
        return self.heads(root)

    def heads(self, root: 'Node') -> list['Node']:
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root]
        result = [root]
        left = self.heads(root.left)
        right = self.heads(root.right)
        for i in range(max(len(left), len(right))):
            if i < len(right):
                result.append(right[i])
            elif i < len(left):
                result.append(left[i])
        return result

    def tails(self, root: 'Node') -> list['Node']:
        if root is None:
            return []
        if root.left is None and root.right is None:
            return [root]
        result = [root]
        left = self.tails(root.left)
        right = self.tails(root.right)
        for i in range(max(len(left), len(right))):
            if i < len(left):
                result.append(left[i])
            elif i < len(right):
                result.append(right[i])
        return result