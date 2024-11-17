import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void minimumBribes(List<Integer> q) {
        int bribes = 0;
        for (int i = 0; i < q.size(); i++) {
            int originalPosition = q.get(i) - 1; // original position (0-indexed)

            // Check if the person has moved more than two positions ahead
            if (originalPosition - i > 2) {
                System.out.println("Too chaotic");
                return;
            }

            // Count how many people bribed to get this person to current position
            for (int j = Math.max(0, originalPosition - 1); j < i; j++) {
                if (q.get(j) > q.get(i)) {
                    bribes++;
                }
            }
        }
        System.out.println(bribes);
    }


    public static void main(String[] args) {

        List<Integer> list;

        list = new ArrayList<>();
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(3);
        list.add(4);

        minimumBribes(list);

        list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(3);
        list.add(7);
        list.add(8);
        list.add(6);
        list.add(4);

        minimumBribes(list);
    }

}
