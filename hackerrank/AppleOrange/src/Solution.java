import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void countAppleAndOranges(int s, int t, int a, int b, List<Integer> apples, List<Integer> oranges){

        for (int i = 0; i < apples.size(); i++) {
           apples.set(i, a + apples.get(i));
        }
        for (int i = 0; i < oranges.size(); i++) {
           oranges.set(i, b + oranges.get(i));
        }

        int applesInside = 0;
        int orangesInside = 0;

        for (int i = 0; i < apples.size(); i++) {
           if(apples.get(i) >= s && apples.get(i) <= t){
               applesInside++;
           }
        }
        System.out.println(applesInside);

        for (int i = 0; i < oranges.size(); i++) {
            if(oranges.get(i) >= s && oranges.get(i) <= t){
                orangesInside++;
            }
        }
        System.out.println(orangesInside);

    }

    public static void main(String[] args) {

        int s;
        int t;
        int a;
        int b;
        List<Integer> apples;
        List<Integer> oranges;

        s = 7;
        t = 10;
        a = 4;
        b = 12;
        apples = new ArrayList<>();
        apples.add(1);
        apples.add(3);
        apples.add(-4);
        oranges = new ArrayList<>();
        oranges.add(3);
        oranges.add(-2);
        oranges.add(-4);
        countAppleAndOranges(s, t, a, b, apples, oranges);

    }

}
