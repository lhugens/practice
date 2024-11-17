public class Main {
    public static class Solution {
        int[] nums;
        public Solution(int[] nums){
            this.nums = nums;
        }

        public int[] reset() {
            return this.nums;
        }

        public int[] shuffle(){
            int[] shuffled = new int[this.nums.length];
            for (int i = 0; i < this.nums.length; i++) {
               shuffled[i] = this.nums[i];
            }
            for (int k = 0; k < 1000; k++) {
                int i = (int) (Math.random()*this.nums.length);
                int j = (int) (Math.random()*this.nums.length);
                int temp = shuffled[i];
                shuffled[i] = shuffled[j];
                shuffled[j] = temp;
            }
            return shuffled;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 2, 3});
        solution.shuffle();
        solution.reset();
        solution.shuffle();
    }
}
