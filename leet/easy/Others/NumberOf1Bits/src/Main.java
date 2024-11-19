public class Main {
    public class Solution {
        public static int hammingWeight(int n){
            int sum = 0;
            String binString = Integer.toBinaryString(n);
            for (int i = 0; i < binString.length(); i++) {
                sum += Character.getNumericValue(binString.charAt(i));
            }
            return sum;
        }
    }

    public static void main(String[] args) {
        int n = 128;
        System.out.println(Solution.hammingWeight(n));
    }
}
