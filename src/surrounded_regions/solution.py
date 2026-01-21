from collections import deque
from typing import List


class Solution:
    def solve(self, board: List[List[str]]) -> None:
        """
        Do not return anything, modify board in-place instead.
        """
        m, n = len(board), len(board[0])
        free: set[tuple[int, int]] = set({})
        for j in range(n):
            if board[0][j] == 'O':
                free |= self.connected_region((0, j), board)
        for j in range(n):
            if board[m - 1][j] == 'O':
                free |= self.connected_region((len(board) - 1, j), board)
        for i in range(m):
            if board[i][0] == 'O':
                free |= self.connected_region((i, 0), board)
        for i in range(m):
            if board[i][n - 1] == 'O':
                free |= self.connected_region((i, n - 1), board)

        for i in range(m):
            for j in range(n):
                if board[i][j] == 'O' and (i, j) not in free:
                    board[i][j] = 'X'


    def connected_region(self, pos: tuple[int, int], board: List[List[str]], ) -> set[tuple[int, int]]:
        m, n = len(board), len(board[0])
        visited = set({})
        queue = deque([pos])
        while len(queue) > 0:
            next = queue.popleft()
            if next in visited:
                continue
            else:
                visited.add(next)
            if next[0] - 1 >= 0 and board[next[0] - 1][next[1]] == 'O':
                queue.append((next[0] - 1, next[1]))
            if next[0] + 1 < m  and board[next[0] + 1][next[1]] == 'O':
                queue.append((next[0] + 1, next[1]))
            if next[1] - 1 >= 0 and board[next[0]][next[1] - 1] == 'O':
                queue.append((next[0], next[1] - 1))
            if next[1] + 1 < n  and board[next[0]][next[1] + 1] == 'O':
                queue.append((next[0], next[1] + 1))
        return visited

    def print_solve(self, board: List[List[str]]) -> None:
        self.solve(board)
        print(board)

    def main(self):
        self.print_solve([
            ["X", "X", "X", "X"],
            ["X", "O", "O", "X"],
            ["X", "X", "O", "X"],
            ["X", "O", "X", "X"]
        ])
        self.print_solve([
            ["X", "X", "X", "X"],
            ["X", "O", "O", "X"],
            ["X", "X", "O", "O"],
            ["X", "O", "X", "X"]
        ])
        self.print_solve([
            ["X", "X", "X", "X", "X"],
            ["X", "O", "X", "O", "X"],
            ["X", "O", "X", "O", "O"],
            ["X", "X", "O", "X", "X"]
        ])
        self.print_solve([
            ["X", "X", "X", "X", "O"],
            ["X", "X", "O", "X", "O"],
            ["O", "O", "X", "O", "O"],
            ["X", "O", "X", "O", "X"]
        ])
        self.print_solve([
            ["X"]
        ])
        self.print_solve([
            ["X", "O", "O", "X"],
        ])
        self.print_solve([
            ["O", "O", "O", "O"],
        ])
        self.print_solve([
            ["O"],
            ["O"],
            ["O"],
            ["O"],
        ])
        self.print_solve([
            ["X"],
            ["O"],
            ["O"],
            ["X"],
        ])

Solution().main()
