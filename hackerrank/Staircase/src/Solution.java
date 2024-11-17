public class Solution {

    public static void staircase(int n) {

        for(int i = n-1; i >= 0; i--){
            String str = "";
            for(int j = 0; j < i; j++){
                str += " ";
            }
            for(int k = i; k < n; k++){
                str += "#";
            }
            System.out.println(str);
        }
    }

    public static void main(String[] args) {

        staircase(4);

    }

}

