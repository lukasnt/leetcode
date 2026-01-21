from typing import List


class Solution:
    def partition(self, s: str) -> List[List[str]]:
        if len(s) == 0:
            return []
        if len(s) == 1:
            return [[s]]
        result: List[List[str]] = []
        for l in range(1, len(s) + 1):
            sub = s[0:l]
            palindrome = True
            for k in range(len(sub) // 2):
                if sub[k] != sub[-(k + 1)]:
                    palindrome = False
                    break
            if palindrome:
                if len(sub) == len(s):
                    result.append([sub])
                for sol in self.partition(s[l:]):
                    result.append([sub] + sol)
        return result


    def main(self):
        print(self.partition("aab"))
        print(self.partition("aabb"))
        print(self.partition("aaaa"))
        print(self.partition("aabcc"))
        print(self.partition("bb"))

Solution().main()