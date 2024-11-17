public class Main {
    public class Solution {
        public static void reverseString(char[] s) {
            char[] reversed = new char[s.length];
            for (int i = s.length-1; i >= 0; i--) {
               reversed[s.length-i-1] = s[i];
            }
            for (int i = 0; i < s.length; i++) {
                s[i] = reversed[i];
            }
        }
    }

    public static void main(String[] args) {
        char[] s = new char[]{'H','a','n','n','a','h'};
        Solution.reverseString(s);
        for (char c : s) {
            System.out.print(c);
        }
    }

}
