import sys
from typing import List


class Solution:
    def canCompleteCircuit(self, gas: List[int], cost: List[int]) -> int:
        fuel = 0
        min_fuel = sys.maxsize
        min_index = -1
        for i in range(len(gas)):
            fuel += gas[i] - cost[i]
            if fuel < min_fuel:
                min_fuel = fuel
                min_index = i
        return -1 if fuel < 0 else (min_index + 1) % len(gas)

    def main(self):
        print(self.canCompleteCircuit([1,2,3,4,5], [3,4,5,1,2]))
        print(self.canCompleteCircuit([2,3,4], [3,4,3]))

Solution().main()

