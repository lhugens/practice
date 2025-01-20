import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

    public static List<Integer> rotLeft(List<Integer> a, int d) {

        int n = a.size();
        d = d % n; // Handle cases where d >= n
        // Split the list and reorder
        List<Integer> rotated = new ArrayList<>(a.subList(d, n));
        rotated.addAll(a.subList(0, d));
        return rotated;
    }

    public static void main(String[] args) {

        List<Integer> arr = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
        rotLeft(arr, 4).forEach(System.out::print);

    }

}
