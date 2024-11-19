import java.util.ArrayList;
import java.util.List;

public class Main {
    public class Solution {
        public static List<String> fizzBuzz(int n) {
            String[] answer = new String[n];
            for (int i = 0; i < n; i++) {
                int j = i + 1;
                if (j % 3 == 0 && j % 5 == 0) {
                    answer[i] = "FizzBuzz";
                } else if (j % 3 == 0) {
                    answer[i] = "Fizz";
                } else if (j % 5 == 0) {
                    answer[i] = "Buzz";
                } else {
                    answer[i] = j + "";
                }
            }
            return List.of(answer);
        }
    }

    public static void main(String[] args) {
        int n = 5;
        List<String> result = Solution.fizzBuzz(n);
        for (String s : result) {
            System.out.print(s + " ");
        }
    }
}
