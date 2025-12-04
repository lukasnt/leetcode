package group_anagrams;

import java.util.*;

public class Solution {

    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<Map<Character, Integer>, List<Integer>> inverted = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            HashMap<Character, Integer> letters = new HashMap<>();
            for (Character c : s.toCharArray()) {
                letters.merge(c, 1, Integer::sum);
            }
            List<Integer> indicies = inverted.get(letters);
            if (indicies == null) {
                ArrayList<Integer> ind = new ArrayList<>();
                ind.add(i);
                inverted.put(letters, ind);
            } else {
                indicies.add(i);
            }
        }
        return inverted.values().stream()
            .map(index -> index.stream()
                .map(i -> strs[i])
                .toList())
            .toList();
    }

    static void main() {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        System.out.println(groupAnagrams(new String[]{""}));
        System.out.println(groupAnagrams(new String[]{"a"}));
    }
}
