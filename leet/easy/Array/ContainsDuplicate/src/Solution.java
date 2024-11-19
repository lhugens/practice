import java.util.Arrays;

public class Solution {

    public static boolean containsDuplicate(int[] nums){
        return Arrays.stream(nums).distinct().count() != nums.length;
    }

    public static void main(String[] args) {

        int[] nums;

        nums = new int[]{1, 2, 3, 1};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{1, 2, 3, 4};
        System.out.println(containsDuplicate(nums));

        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums));

    }

}
