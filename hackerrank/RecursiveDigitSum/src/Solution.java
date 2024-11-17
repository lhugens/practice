public class Solution {

    private static int superDigitHelper(long num){

        if(num < 10){
            return (int) num;
        }

        long nextSum = 0;
        while(num > 0){
            nextSum += num % 10;
            num /= 10;
        }

        return superDigitHelper(nextSum);
    }

    public static int superDigit(String n, int k){

        long sum = 0;
        for (int i = 0; i < n.length(); i++) {
            sum += n.charAt(i) - '0';
        }

        sum *= k;

        return superDigitHelper(sum);
    }

    public static void main(String[] args) {

        String n;
        int k;

        n = "9875";
        k = 4;

        System.out.println(superDigit(n, k));
    }

}
