public class Solution {
    public static boolean isBadVersion(int version) {
        if (version == 4) {
            return true;
        }
        return false;
    }

    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while(left <= right){
            int mid = (int) (left + (right - left) / 2);
            if(!isBadVersion(mid - 1) && isBadVersion(mid)){
                return mid;
            } else if(!isBadVersion(mid)){
                left = mid + 1;
            } else {
               right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println(firstBadVersion(n));
    }
}
