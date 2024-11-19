import java.awt.event.WindowStateListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] intersect(int[] nums1, int[] nums2) {
        int[] bigger;
        int[] smaller;

        if (nums1.length > nums2.length) {
            bigger = nums1;
            smaller = nums2;
        } else {
            bigger = nums2;
            smaller = nums1;
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i : bigger) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i : smaller) {
           if(map.containsKey(i) && map.get(i) > 0){
               arr.add(i);
               map.put(i, map.get(i) - 1);
           }
        }

        return arr.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void main(String[] args) {
        int[] nums1;
        int[] nums2;

        nums1 = new int[]{1, 2, 2, 1};
        nums2 = new int[]{2, 2};

        Arrays.stream(intersect(nums1, nums2)).forEach(System.out::print);

        System.out.println("");

        nums1 = new int[]{4, 9, 5};
        nums2 = new int[]{9, 4, 9, 8, 4};

        Arrays.stream(intersect(nums1, nums2)).forEach(System.out::print);

    }
}
