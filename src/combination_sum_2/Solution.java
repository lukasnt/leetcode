package combination_sum_2;

import java.util.*;

public class Solution {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Map<Integer, Set<Map<Integer, Integer>>> solutions = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        for (int candidate : candidates) {
            counts.merge(candidate, 1, Integer::sum);
        }

        for (int i = 0; i <= target; i++) {
            Set<Map<Integer, Integer>> solsForNum = new HashSet<>();
            if (counts.containsKey(i)) {
                solsForNum.add(Map.of(i, 1));
            }

            for (int j = 0; j < i; j++) {
                if (counts.containsKey(j) && solutions.containsKey(i - j)) {
                    for (Map<Integer, Integer> sol : solutions.get(i - j)) {
                        if (sol.getOrDefault(j, 0) < counts.get(j)) {
                            Map<Integer, Integer> newSol = new HashMap<>();
                            for (Integer candidate : sol.keySet()) {
                                newSol.put(candidate, sol.get(candidate));
                            }
                            newSol.put(j, sol.getOrDefault(j, 0) + 1);
                            solsForNum.add(newSol);
                        }
                    }
                }
            }
            solutions.put(i, solsForNum);
        }
        return solutions.getOrDefault(target, new HashSet<>()).stream()
            .map(c -> {
                List<Integer> list = new ArrayList<>();
                for (Integer num : c.keySet()) {
                    for (int i = 0; i < c.get(num); i++) {
                        list.add(num);
                    }
                }
                return list;
            })
            .toList();
    }

    static void main() {
        var candidates1 = new int[]{10,1,2,7,6,1,5};
        System.out.println(combinationSum2(candidates1, 8));
        var candidates2 = new int[]{2,5,2,1,2};
        System.out.println(combinationSum2(candidates2, 5));
    }

}
