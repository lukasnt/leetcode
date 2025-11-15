package length_of_last_word;

public class Solution {

    static int lengthOfLastWord(String s) {
        String sentence = s.strip();
        int index = sentence.lastIndexOf(" ");
        return sentence.substring(index + 1).length();
    }

    static void main() {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(lengthOfLastWord("luffy is still joyboy"));
        System.out.println(lengthOfLastWord("112312"));
    }
}
