package merge_intervals;

import java.util.*;

public class Solution {

    public static int[][] merge(int[][] intervals) {
        List<int[]> merged = new ArrayList<>(intervals.length);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int[] current = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (current[1] >= intervals[i][0]) {
                if (current[1] <= intervals[i][1]) {
                    current[1] = intervals[i][1];
                }
            } else {
                merged.add(current);
                current = intervals[i];
            }
        }
        merged.add(current);
        int[][] result = new int[merged.size()][2];
        System.arraycopy(merged.toArray(), 0, (Object[]) result, 0, result.length);
        return result;
    }

    static void main() {
        System.out.println(Arrays.deepToString(merge(new int[][]{
            new int[]{1, 3},
            new int[]{2, 6},
            new int[]{8, 10},
            new int[]{15, 18},
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
            new int[]{1, 4},
            new int[]{4, 5},
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
            new int[]{4, 7},
            new int[]{1, 4},
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
            new int[]{2, 3},
            new int[]{4, 5},
            new int[]{6, 7},
            new int[]{1, 10},
        })));
        System.out.println(Arrays.deepToString(merge(new int[][]{
            new int[]{2, 3},
            new int[]{4, 5},
            new int[]{6, 7},
            new int[]{1, 10},
            new int[]{2, 20},
        })));
    }
}
