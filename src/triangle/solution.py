from typing import List


class Solution:
    def minimumTotal(self, triangle: List[List[int]]) -> int:
        if len(triangle) == 0:
            return 0
        elif len(triangle) == 1:
            return triangle[0][0]
        for r in range(2, len(triangle) + 1):
            for i in range(len(triangle[-r])):
                triangle[-r][i] += min(triangle[1 - r][i], triangle[1 - r][i + 1])
        return triangle[0][0]

    def main(self):
        print(self.minimumTotal([[2], [3, 4], [6, 5, 7], [4, 1, 8, 3]]))
        print(self.minimumTotal([[2], [3, 4], [1, 5, 7], [1, 1, 8, 3]]))
        print(self.minimumTotal([[2], [3, 4]]))

Solution().main()