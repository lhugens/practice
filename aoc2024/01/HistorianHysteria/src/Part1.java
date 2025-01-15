import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Part1 {

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("input.txt");

            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            String[] lineArr;
            List<Integer> first = new ArrayList<>();
            List<Integer> second = new ArrayList<>();

            while((line = bufferedReader.readLine()) != null){
                lineArr = line.split("   ");
                first.add(Integer.valueOf(lineArr[0]));
                second.add(Integer.valueOf(lineArr[1]));
            }

            Collections.sort(first);
            Collections.sort(second);

            int result = 0;

            for (int i = 0; i < first.size(); i++) {
                result += Math.abs(first.get(i) - second.get(i));
            }

            System.out.println(result);

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

}
