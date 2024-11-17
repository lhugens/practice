public class Solution {
    public static int hammingDistance(int x, int y){
        int xor = x ^ y;
        int distance = 0;

        while(xor != 0){
            distance += xor & 1;
            xor >>= 1;
        }

        return distance;
    }

    public static void main(String[] args) {
        int x;
        int y;

        x = 1;
        y = 4;

        System.out.println(hammingDistance(x, y));

        x = 3;
        y = 1;

        System.out.println(hammingDistance(x, y));
    }
}
