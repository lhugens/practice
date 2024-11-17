import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    public static String gridChallenge(List<String> grid) {

        int n = grid.size();
        char[] charArray = new char[n];

        for (int i = 0; i < n; i++) {
            charArray = grid.get(i).toCharArray();
            Arrays.sort(charArray);
            grid.set(i, new String(charArray));
        }

        for (int j = 0; j < n; j++) {
            for (int i = 1; i < n; i++) {
                if (grid.get(i).charAt(j) < grid.get(i-1).charAt(j)){
                    return "NO";
                }
            }
        }

        return "YES";
    }

    public static void main(String[] args) {

        List<String> grid;

        grid = new ArrayList<>();
        grid.add("abcde");
        grid.add("fghij");
        grid.add("klmno");
        grid.add("pqrst");
        grid.add("uvwxy");

        System.out.println(gridChallenge(grid));
    }

}
