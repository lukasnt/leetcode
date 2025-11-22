package multiply_strings;

import java.util.Arrays;

public class Solution {

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];

        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (int j = num2.length() - 1; j >= 0; j--) {
                int n1 = num1.charAt(i) - '0';
                int n2 = num2.charAt(j) - '0';
                int prod = n1 * n2 + carry + result[i + j + 1];
                carry = prod / 10;
                result[i + j + 1] = prod % 10;
            }
            if (carry > 0) {
                result[i] = carry;
            }
        }
        String stringResult = Arrays.stream(result)
            .dropWhile(num -> num == 0)
            .mapToObj(String::valueOf)
            .reduce("", String::concat);
        if (!stringResult.isEmpty()) {
            return stringResult;
        } else return "0";
    }

    static void main() {
        System.out.println(multiply("2", "3"));
        System.out.println(multiply("123", "456"));
        System.out.println(multiply("1234", "4567"));
        System.out.println(multiply("2345", "3456"));
        System.out.println(multiply("99", "99"));
        System.out.println(multiply("190", "0"));
    }

}
