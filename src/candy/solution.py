from typing import List


class Solution:
    def candy(self, ratings: List[int]) -> int:
        inv: dict[int, List[int]] = dict({})
        for i in range(len(ratings)):
            if ratings[i] in inv:
                inv[ratings[i]].append(i)
            else:
                inv[ratings[i]] = [i]
        sorted_ratings = sorted(inv.keys())
        candies = [1 for _ in range(len(ratings))]
        for rating in sorted_ratings:
            for index in inv[rating]:
                left  = candies[index - 1] if (index - 1 >= 0 and rating > ratings[index - 1]) else 0
                right = candies[index + 1] if (index + 1 < len(ratings) and rating > ratings[index + 1]) else 0
                candies[index] = max(left, right) + 1
        return sum(candies)

    def main(self):
        print(self.candy([1,0,2]))
        print(self.candy([1,2,2]))
        print(self.candy([1,2,2,5,5,4,2]))
        print(self.candy([1,1,1,1]))
        print(self.candy([1,1,1,1,2,2,2]))

Solution().main()