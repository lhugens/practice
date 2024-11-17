public class Solution {
    public static int maxSubArray(int[] nums) {
        int maxCurrent = nums[0];
        int maxGlobal = nums[0];

        for (int i = 1; i < nums.length; i++) {
            maxCurrent = Math.max(nums[i], maxCurrent + nums[i]);
            if (maxCurrent > maxGlobal) {
                maxGlobal = maxCurrent;
            }
        }

        return maxGlobal;
    }

    public static void main(String[] args) {
        int[] nums;

        nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));

        nums = new int[]{1};
        System.out.println(maxSubArray(nums));

        nums = new int[]{5, 4, -1, 7, 8};
        System.out.println(maxSubArray(nums));

    }
}
