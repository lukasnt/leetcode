package multiply_strings;

import java.util.Arrays;

public class Solution {

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            int n1 = num1.charAt(i) - '0';
            int n2 = num2.charAt(j) - '0';
            int prod = n1 * n2 + carry;
            System.out.println(prod);
            carry = prod / 10;
            result[i + j + 1] = prod - 10 * carry;
            if (i == j) {
                i--;
                j--;
            } else if (i > j) {
                i--;
            } else {
                j--;
            }
        }
        if (carry > 0) {
            result[0] = carry;
        }
        return Arrays.stream(result)
            .mapToObj(String::valueOf)
            .reduce("", String::concat);
    }

    static void main() {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
    }

}
