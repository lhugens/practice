public class Main {
    public static void rotate1(int[] nums, int k) {
        int[] rotated = new int[nums.length];
        int iter = 0;
        while (iter < k) {
            rotated[0] = nums[nums.length - 1];
            for (int i = 1; i < nums.length; i++) {
                rotated[i] = nums[i - 1];
            }
            for (int i = 0; i < nums.length; i++) {
                nums[i] = rotated[i];
            }
            iter++;
        }
    }

    public static void rotate2(int[] nums, int k) {
        int iter = 0;
        while (iter < k) {
            int temp1 = nums[0];
            nums[0] = nums[nums.length - 1];
            int temp2;
            for (int i = 1; i < nums.length; i++) {
                temp2 = nums[i];
                nums[i] = temp1;
                temp1 = temp2;
            }
            iter++;
        }
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void rotate3(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] arr;
        int k;

        arr = new int[]{1, 2, 3, 4, 5, 6, 7};
        k = 3;
        rotate3(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        arr = new int[]{-1, -100, 3, 99};
        k = 2;
        rotate3(arr, k);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }


    }
}
