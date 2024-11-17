import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static List<List<Integer>> generate(int numRows) {

        int count = 0;

        List<Integer> element = new ArrayList<>();
        List<Integer> newElement = new ArrayList<>();
        List<List<Integer>> triangle = new ArrayList<>();

        element.add(1);
        triangle.add(element);
        System.out.println(element);
        count++;

        if (numRows == 1) {
            return triangle;
        }

        while(count < numRows){
            newElement = new ArrayList<>();
            newElement.add(1);
            for (int i = 0; i < count-1; i++) {
               newElement.add(element.get(i) + element.get(i+1));
            }
            newElement.add(1);
            element = newElement;
            triangle.add(element);

            System.out.println(element);
            count++;
        }

        return triangle;

    }

    public static void main(String[] args) {
        int numRows;

        numRows = 5;
        System.out.println(generate(numRows));
    }

}
