import javax.swing.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int[] twoSum(int[] nums, int target){

        Map<Integer, Integer> map = new HashMap<>();
        int desired;

        for (int i = 0; i < nums.length; i++) {
            desired = target - nums[i];

            if(map.containsKey(nums[i])){
                return new int[]{i, map.get(nums[i])};
            }
            map.put(desired, i);
        }

        return new int[]{0, 0};
    }

    public static void main(String[] args) {

        int[] nums;
        int target;

        nums = new int[]{2, 7, 11, 15};
        target = 9;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::print);

        System.out.println();

        nums = new int[]{3, 2, 4};
        target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::print);

        System.out.println();

        nums = new int[]{3, 3};
        target = 6;
        Arrays.stream(twoSum(nums, target)).forEach(System.out::print);

    }
}
