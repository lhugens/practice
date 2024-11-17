public class Solution {
    public static int reverse(int x){
        String str = Integer.toString(Math.abs(x));
        String reversed = "";
        for (int i = str.length()-1; i >= 0; i--) {
           reversed += str.charAt(i);
        }
        try {
            int result = Integer.valueOf(reversed);
            if(x < 0){
                return -result;
            }
            return result;
        } catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        System.out.println(reverse(120));
    }
}
