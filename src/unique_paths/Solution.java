package unique_paths;

public class Solution {

    public static int uniquePaths(int m, int n) {
        long prod = 1;
        final long q = Math.min(m - 1, n - 1);
        long p = n + m - 2;
        long l = q;
        long r = 1;
        for (long k = 0; k < q; k++) {
            prod *= p;
            if (prod >= l && prod % l == 0) {
                prod /= l;
            } else {
                r *= l;
            }
            p--;
            l--;
        }
        return (int) (prod / r);
    }

    static void main() {
        System.out.println(uniquePaths(3, 7));
        System.out.println(uniquePaths(3, 8));
        System.out.println(uniquePaths(16, 16));
        System.out.println(uniquePaths(17, 17));
    }
}
