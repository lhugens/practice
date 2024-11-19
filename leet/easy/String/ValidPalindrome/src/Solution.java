public class Solution {

    public static boolean isPalindrome(String s){
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");

        String reversedS = "";

        for (int i = s.length()-1; i >= 0; i--) {
            reversedS += s.charAt(i);
        }

        return s.equals(reversedS);
    }

    public static void main(String[] args) {
        String s;

        s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));

        s = "race a car";
        System.out.println(isPalindrome(s));

        s = " ";
        System.out.println(isPalindrome(s));

    }
}
