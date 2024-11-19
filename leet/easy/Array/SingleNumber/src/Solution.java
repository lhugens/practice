import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int singleNumber(int[] nums){

        Map<Integer, Integer> map = new HashMap<>();;
        for (int num : nums) {
           map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer i : map.keySet()) {
           if(map.get(i) == 1){
               return i;
           }
        }
        return 0;
    }

    public static void main(String[] args) {

        int[] nums;

        nums = new int[]{2, 2, 1};
        System.out.println(singleNumber(nums));

        nums = new int[]{4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));

        nums = new int[]{1};
        System.out.println(singleNumber(nums));

    }
}
