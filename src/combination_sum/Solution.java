package combination_sum;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<Integer> candidateSet = Arrays.stream(candidates).boxed().collect(Collectors.toSet());
        Map<Integer, List<List<Integer>>> solutions = new HashMap<>();
        for (int i = 2; i <= target; i++) {
            if (candidateSet.contains(i)) {
                List<List<Integer>> sol = new ArrayList<>();
                sol.add(List.of(i));
                solutions.put(i, sol);
            }
            for (int j = i - 2; j >= 2; j--) {
                if (candidateSet.contains(j) && solutions.containsKey(i - j)) {
                    Set<List<Integer>> newSolutions = new HashSet<>();
                    for (List<Integer> sol : solutions.get(i - j)) {
                        List<Integer> newSol = new ArrayList<>(sol);
                        newSol.add(j);
                        newSol.sort(Comparator.naturalOrder());
                        newSolutions.add(newSol);
                    }
                    var currentSolutions = solutions.getOrDefault(i, new ArrayList<>());
                    currentSolutions.addAll(newSolutions);
                    solutions.put(i, currentSolutions.stream().distinct().collect(Collectors.toList()));
                }
            }
        }
        return solutions.getOrDefault(target, new ArrayList<>());
    }

    static void main() {
        var candidates = new int[] {2,3,6,7};
        System.out.println(combinationSum(candidates, 7));
        var candidates2 = new int[] {2,3,5};
        System.out.println(combinationSum(candidates2, 8));
        var candidates3 = new int[] {7,3,2};
        System.out.println(combinationSum(candidates3, 18));
    }
}
