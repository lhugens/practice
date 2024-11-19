import java.util.Arrays;

public class Solution {

    public static void moveZeroes(int[] nums) {

        int count = 0;
        while (count < nums.length) {
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] == 0) {
                    nums[i] = nums[i + 1];
                    nums[i + 1] = 0;
                }
            }
            count++;
        }

    }

    public static void main(String[] args) {
        int nums[];

        nums = new int[]{0, 1, 0, 3, 12};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);

        System.out.println("");

        nums = new int[]{0};
        moveZeroes(nums);
        Arrays.stream(nums).forEach(System.out::print);
    }
}
