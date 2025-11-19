package count_and_say;

class Solution {

    public static String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        StringBuilder result = new StringBuilder();
        String prev = countAndSay(n - 1);
        int count = 1;
        for (int i = 1; i < prev.length(); i++) {
            if (prev.charAt(i - 1) == prev.charAt(i)) {
                count++;
            } else {
                result.append(count);
                result.append(prev.charAt(i - 1));
                count = 1;
            }
        }
        result.append(count);
        result.append(prev.charAt(prev.length() - 1));
        return result.toString();
    }

    static void main() {
        System.out.println(countAndSay(1));
        System.out.println(countAndSay(2));
        System.out.println(countAndSay(3));
        System.out.println(countAndSay(4));
        System.out.println(countAndSay(5));
        System.out.println(countAndSay(30));
    }
}