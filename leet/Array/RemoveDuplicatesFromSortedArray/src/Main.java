import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        class Solution {
            public static int removeDuplicates(int[] nums) {
                if (nums.length == 0) {
                    return 0;
                }

                TreeSet<Integer> result = new TreeSet<>();
                for (int n : nums) {
                    result.add(n);
                }

                int index = 0;
                for (Integer n : result) {
                    nums[index++] = n;
                }

                return result.size();
            }
        }

        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int different = Solution.removeDuplicates(nums);
        System.out.println(different);
        for (int i = 0; i < different; i++) {
            System.out.print(nums[i] + " ");
        }

    }
}
