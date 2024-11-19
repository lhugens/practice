import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static int missingNumber(int[] nums){

        Map<Integer, Boolean> map = new HashMap<>();
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            map.put(num, true);
            max = Integer.max(max, num);
        }

        for (int i = 0; i < max; i++) {
            if(!map.containsKey(i)){
                return i;
            }
        }
        return max + 1;
    }

    public static void main(String[] args) {

        int[] nums;

        nums = new int[]{3, 0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{0, 1};
        System.out.println(missingNumber(nums));

        nums = new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1};
        System.out.println(missingNumber(nums));

    }

}
