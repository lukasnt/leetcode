class Node:
    def __init__(self, val=0, neighbors=None):
        self.val = val
        self.neighbors = neighbors if neighbors is not None else []


from typing import Optional


class Solution:
    def cloneGraph(self, node: Optional['Node']) -> Optional['Node']:
        if node is None:
            return None
        new_node = Node(val=node.val, neighbors=[])
        visited: dict[int, 'Node'] = dict({ node.val: new_node })
        for neighbor in node.neighbors:
            if neighbor.val in visited:
                new_node.neighbors.append(visited[neighbor.val])
            else:
                new_node.neighbors.append(self.clone_sub_graph(neighbor, visited))
        return new_node

    def clone_sub_graph(self, node: Optional['Node'], visited: dict[int, 'Node']) -> Optional['Node']:
        new_node = Node(val=node.val, neighbors=[])
        visited[node.val] = new_node
        for neighbor in node.neighbors:
            if neighbor.val in visited:
                new_node.neighbors.append(visited[neighbor.val])
            else:
                new_node.neighbors.append(self.clone_sub_graph(neighbor, visited))
        return new_node