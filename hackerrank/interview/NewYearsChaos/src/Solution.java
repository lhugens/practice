import java.util.Arrays;
import java.util.List;

public class Solution {

    public static void minimumBribes(List<Integer> q) {

        int totalBribes = 0;

        for (int i = 1; i < q.size()+1; i++) {
            int bribes = q.get(i-1) - i;
            if(bribes > 2){
                System.out.println("Too chaotic");
                return;
            }
            if(bribes > 0){
                totalBribes += bribes;
            }
        }
        System.out.println(totalBribes);
    }

    public static void main(String[] args) {

        List<Integer> queue;

        queue = Arrays.asList(1, 2, 3, 5, 4, 6, 7, 8);
        minimumBribes(queue);

        queue = Arrays.asList(4, 1, 2, 3);
        minimumBribes(queue);

    }

}
