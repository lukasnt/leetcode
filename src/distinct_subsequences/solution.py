class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        sols = [[0 for _ in range(len(s))] for _ in range(len(t))]
        sols[0][0] = 1 if s[0] == t[0] else 0
        for j in range(1, len(s)):
            sols[0][j] = sols[0][j - 1]
            if s[j] == t[0]:
                sols[0][j] += 1

        for i in range(1, len(t)):
            for j in range(1, len(s)):
                sols[i][j] = sols[i][j - 1]
                if s[j] == t[i]:
                    sols[i][j] += sols[i - 1][j - 1]

        return sols[len(t) - 1][len(s) - 1]


    def main(self):
        print(self.numDistinct("rabbbit", "rabbit"))
        print(self.numDistinct("babgbag", "bag"))
        print(self.numDistinct("123", "1"))
        print(self.numDistinct("123", "1234"))
        print(self.numDistinct("1", "1"))
        print(self.numDistinct("1", "2"))


Solution().main()