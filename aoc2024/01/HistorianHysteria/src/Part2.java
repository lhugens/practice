import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Part2 {

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("input.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] lineArr;
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            while ((line = bufferedReader.readLine()) != null) {
                lineArr = line.split("   ");
                first.add(Integer.valueOf(lineArr[0]));
                second.add(Integer.valueOf(lineArr[1]));
            }

            Map<Integer, Integer> secondFreq = new HashMap<>();

            for (int i = 0; i < second.size(); i++) {
                secondFreq.put(second.get(i), secondFreq.getOrDefault(second.get(i), 0) + 1);
            }

            int result = 0;

            for (int i = 0; i < first.size(); i++) {
               result += first.get(i) * secondFreq.getOrDefault(first.get(i), 0);
            }

            System.out.println(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}