import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part2 {

    public static boolean checkARight(List<List<String>> matrix, int i, int j) {
        int newI, newJ;

        newI = i - 1;
        newJ = j - 1;
        if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("M")) {
            newI = i + 1;
            newJ = j + 1;
            if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("S")) {
                return true;
            }
        }
        newI = i - 1;
        newJ = j - 1;
        if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("S")) {
            newI = i + 1;
            newJ = j + 1;
            if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("M")) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkALeft(List<List<String>> matrix, int i, int j) {
        int newI, newJ;

        newI = i + 1;
        newJ = j - 1;
        if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("M")) {
            newI = i - 1;
            newJ = j + 1;
            if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("S")) {
                return true;
            }
        }
        newI = i + 1;
        newJ = j - 1;
        if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("S")) {
            newI = i - 1;
            newJ = j + 1;
            if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("M")) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;
            List<List<String>> matrix = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                String[] arr = line.split("");
                matrix.add(Arrays.stream(arr).toList());
            }

            int count = 0;

            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (matrix.get(i).get(j).equals("A")) {
                        if(checkARight(matrix, i, j) && checkALeft(matrix, i, j)){
                            count++;
                        }

                    }
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}