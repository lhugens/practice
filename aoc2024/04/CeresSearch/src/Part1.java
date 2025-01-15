import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {

    public static boolean checkX(List<List<String>> matrix, int[] dir, int i, int j) {
        int newI = i + dir[0];
        int newJ = j + dir[1];
        if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("M")) {
            newI += dir[0];
            newJ += dir[1];
            if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("A")) {
                newI += dir[0];
                newJ += dir[1];
                if (newI >= 0 && newJ >= 0 && newI < matrix.size() && newJ < matrix.get(0).size() && matrix.get(newI).get(newJ).equals("S")) {
                    return true;
                }
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
            int[] dir;
            int newI;
            int newJ;

            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (matrix.get(i).get(j).equals("X")) {
                        // test right
                        dir = new int[]{0, 1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test right down diagonal
                        dir = new int[]{1, 1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test down
                        dir = new int[]{1, 0};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test left down diagonal
                        dir = new int[]{1, -1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test left
                        dir = new int[]{0, -1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test left up diagonal
                        dir = new int[]{-1, -1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test up
                        dir = new int[]{-1, 0};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                        // test up right diagonal
                        dir = new int[]{-1, 1};
                        count = checkX(matrix, dir, i, j) ? count + 1 : count;

                    }
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
