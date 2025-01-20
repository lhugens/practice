import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    // sum for a 3x3matrix
    // Calculate the sum of a 3x3 hourglass
    public static int subHourglassSum(List<List<Integer>> arr) {
        return arr.get(0).get(0) + arr.get(0).get(1) + arr.get(0).get(2) // top row
                + arr.get(1).get(1)                                        // middle
                + arr.get(2).get(0) + arr.get(2).get(1) + arr.get(2).get(2); // bottom row
    }

    public static int hourglassSum(List<List<Integer>> arr) {
        int maxSum = Integer.MIN_VALUE; // Start with the smallest possible value

        // Iterate over all possible hourglasses
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                // Extract the 3x3 hourglass starting at (i, j)
                List<List<Integer>> sub = new ArrayList<>();
                for (int k = 0; k < 3; k++) {
                    sub.add(arr.get(i + k).subList(j, j + 3));
                }
                // Calculate the sum of the current hourglass
                int sum = subHourglassSum(sub);
                // Update the maximum sum if the current sum is larger
                maxSum = Integer.max(sum, maxSum);
            }
        }
        return maxSum;
    }


    public static void main(String[] args) {

        List<List<Integer>> testArr = new ArrayList<>();

        testArr.add(new ArrayList<>(Arrays.asList(-9, -9, -9, 1, 1, 1)));
        testArr.add(new ArrayList<>(Arrays.asList(0, -9, 0, 4, 3, 2)));
        testArr.add(new ArrayList<>(Arrays.asList(-9, -9, -9, 1, 2, 3)));
        testArr.add(new ArrayList<>(Arrays.asList(0, 0, 8, 6, 6, 0)));
        testArr.add(new ArrayList<>(Arrays.asList(0, 0, 0, -2, 0, 0)));
        testArr.add(new ArrayList<>(Arrays.asList(0, 0, 1, 2, 4, 0)));

        System.out.println(hourglassSum(testArr));

    }

}
