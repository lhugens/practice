import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Part1 {

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line;

            List<List<String>> matrix = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                matrix.add(Arrays.stream(line.split("")).toList());
            }

            int[] position = new int[2];

            for (int i = 0; i < matrix.size(); i++) {
                for (int j = 0; j < matrix.get(i).size(); j++) {
                    if (matrix.get(i).get(j).equals("^")) {
                        position = new int[]{i, j};
                    }
                }
            }

            int visited = 0;

            boolean obstacle = false;
            int[] direction = new int[]{-1, 0};
            int[] newPosition = position;

            while (!obstacle) {

                if(position[0] + direction[0] >= matrix.size() || position[1] + direction[1] >= matrix.get(0).size()){
                    break;
                }

                String object = matrix.get(position[0] + direction[0]).get(position[1] + direction[1]);

                if (!object.equals("#")) {
                    newPosition[0] = position[0] + direction[0];
                    newPosition[1] = position[1] + direction[1];
                    if (!object.equals("X")) {
                        List<String> mutableList = new ArrayList<>(matrix.get(position[0]));
                        mutableList.set(position[1], "X");
                        matrix.set(position[0], mutableList);
                        visited++;
                    }
                } else {
                    if (direction[0] == -1 && direction[1] == 0) {
                        direction[0] = 0;
                        direction[1] = 1;
                    } else if (direction[0] == 0 && direction[1] == 1) {
                        direction[0] = 1;
                        direction[1] = 0;
                    } else if (direction[0] == 1 && direction[1] == 0) {
                        direction[0] = 0;
                        direction[1] = -1;
                    } else if (direction[0] == 0 && direction[1] == -1){
                        direction[0] = -1;
                        direction[1] = 0;
                    }
                }
            }

            System.out.println(visited);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
