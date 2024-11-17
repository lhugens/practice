import java.util.ArrayList;

public class Solution {
    public static int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] newDigits = new int[digits.length+1];
        newDigits[0] = 1;

        return newDigits;
    }

    public static void main(String[] args) {

        int[] digits = new int[]{1, 2, 3};
        int[] pOne = plusOne(digits);
        for (int i : pOne) {
            System.out.print(i);
        }

    }

}
