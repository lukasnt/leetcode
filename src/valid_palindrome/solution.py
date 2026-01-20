class Solution:
    def isPalindrome(self, s: str) -> bool:
        lower = s.lower()
        alpha_num = ""
        for char in lower:
            if char.isalnum():
                alpha_num += char
        for i in range(0, len(alpha_num) // 2):
            if alpha_num[i] != alpha_num[len(alpha_num) - 1 - i]:
                return False
        return True

    def main(self):
        print(self.isPalindrome("A man, a plan, a canal: Panama"))
        print(self.isPalindrome("race a car"))
        print(self.isPalindrome(" "))

Solution().main()