import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public class Solution {
        public static void merge(int[] nums1, int m, int[] nums2, int n) {
            Queue<Integer> nums1Queue = new LinkedList<>();
            Queue<Integer> nums2Queue = new LinkedList<>();

            for (int i = 0; i < m; i++) {
                nums1Queue.add(nums1[i]);
            }
            for (int i = 0; i < n; i++) {
                nums2Queue.add(nums2[i]);
            }

            for (int i = 0; i < nums1.length; i++) {
                if(!nums1Queue.isEmpty() && !nums2Queue.isEmpty()){
                    if(nums1Queue.peek() < nums2Queue.peek()){
                        nums1[i] = nums1Queue.poll();
                    } else {
                        nums1[i] = nums2Queue.poll();
                    }
                } else if (!nums1Queue.isEmpty()){
                   nums1[i] = nums1Queue.poll();
                } else {
                    nums1[i] = nums2Queue.poll();
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        Solution.merge(nums1, m, nums2, n);
        for (int i : nums1) {
            System.out.print(i);
        }
    }
}
