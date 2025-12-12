package word_search;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    static String toString(int i, int j) {
        return i + "," + j;
    }

    static boolean exist(char[][] board, String word, int i, int j, Set<String> visited, List<int[]> lastIndices) {
        if (word.isEmpty()) return true;
        int heuristic = lastIndices.stream()
            .map(index -> Math.abs(i - index[0]) + Math.abs(j - index[1]))
            .min(Integer::compareTo)
            .orElse(Integer.MAX_VALUE);
        if (heuristic > word.length() + 1) return false;
        final int m = board.length;
        final int n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return false;
        final char first = word.charAt(0);
        final String next = word.substring(1);
        if (board[i][j] == first) {
            Set<String> nextVisited = new HashSet<>(visited);
            nextVisited.add(toString(i, j));
            boolean left  = !visited.contains(toString(i, j - 1)) && exist(board, next, i, j - 1, nextVisited, lastIndices);
            boolean right = !visited.contains(toString(i, j + 1)) && exist(board, next, i, j + 1, nextVisited, lastIndices);
            boolean down  = !visited.contains(toString(i + 1, j)) && exist(board, next, i + 1, j, nextVisited, lastIndices);
            boolean up    = !visited.contains(toString(i - 1, j)) && exist(board, next, i - 1, j, nextVisited, lastIndices);
            return left || right || down || up || next.isEmpty();
        }
        return false;
    }

    static List<int[]> lastIndices(char[][] board, String word) {
        List<int[]> indicies = new ArrayList<>();
        char last = word.charAt(word.length() - 1);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == last) indicies.add(new int[]{i, j});
            }
        }
        return indicies;
    }

    public static boolean exist(char[][] board, String word) {
        var lastIndices = lastIndices(board, word);
        final int m = board.length;
        final int n = board[0].length;
        final char first = word.charAt(0);
        final String next = word.substring(1);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == first) {
                    Set<String> visited = new HashSet<>(Set.of(toString(i, j)));
                    boolean left  = exist(board, next, i, j - 1, visited, lastIndices);
                    boolean right = exist(board, next, i, j + 1, visited, lastIndices);
                    boolean down  = exist(board, next, i + 1, j, visited, lastIndices);
                    boolean up    = exist(board, next, i - 1, j, visited, lastIndices);
                    if (left || right || down || up) return true;
                }
            }
        }
        return false;
    }

    static void main() {
        IO.println(exist(new char[][]{
            new char[] {'A','B','C','E'},
            new char[] {'S','F','C','S'},
            new char[] {'A','D','E','E'},
        }, "ABCCED"));
        IO.println(exist(new char[][]{
            new char[] {'A','B','C','E'},
            new char[] {'S','F','C','S'},
            new char[] {'A','D','E','E'},
        }, "SEE"));
        IO.println(exist(new char[][]{
            new char[] {'A','B','C','E'},
            new char[] {'S','F','C','S'},
            new char[] {'A','D','E','E'},
        }, "ABCB"));
        IO.println(exist(new char[][]{
            new char[] {'A','A','A'},
        }, "AAA"));
        IO.println(exist(new char[][]{
            new char[] {'A'},
            new char[] {'A'},
            new char[] {'A'},
        }, "AAA"));
        IO.println(exist(new char[][]{
            new char[] {'A'},
        }, "A"));
        IO.println(exist(new char[][]{
            new char[] {'A','A','A'},
            new char[] {'A','A','A'},
        }, "AAAAAA"));
        IO.println(exist(new char[][]{
            new char[] {'A','A','A'},
            new char[] {'A','A','A'},
        }, "AAAAAAA"));
        IO.println(exist(new char[][]{
            new char[] {'a','a','a'},
            new char[] {'A','A','A'},
            new char[] {'a','a','a'},
        }, "aAaaaAaaA"));
        IO.println(exist(new char[][]{
            new char[] {'A','A','A','A','A','A'},
            new char[] {'A','A','A','A','A','A'},
            new char[] {'A','A','A','A','A','A'},
            new char[] {'A','A','A','A','A','A'},
            new char[] {'A','A','A','A','A','A'},
            new char[] {'A','A','A','A','A','A'},
        }, "AAAAAAAAAAAAAAa"));
    }

}
