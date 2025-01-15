import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Part1 {

    public static List<List<String>> readInput() {
        List<List<String>> matrix = new ArrayList<>();

        try {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {
                List<String> temp = new ArrayList<>();
                for (String s : line.split("")) {
                    temp.add(s);
                }
                matrix.add(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return matrix;
    }

    public static Map<String, List<int[]>> getFreqLocations(List<List<String>> matrix) {
        Map<String, List<int[]>> map = new HashMap<>();

        for (int i = 0; i < matrix.size(); i++) {
            for (int j = 0; j < matrix.get(i).size(); j++) {
                String freq = matrix.get(i).get(j);
                if (!freq.equals(".")) {
                    map.putIfAbsent(freq, new ArrayList<>());
                    map.get(freq).add(new int[]{i, j});
                }
            }
        }

        return map;
    }

    public static Set<String> calculateAntinodes(Map<String, List<int[]>> freqLocations, int rows, int cols) {
        Set<String> antinodes = new HashSet<>();

        for (Map.Entry<String, List<int[]>> entry : freqLocations.entrySet()) {
            List<int[]> locations = entry.getValue();
            for (int i = 0; i < locations.size(); i++) {
                for (int j = i + 1; j < locations.size(); j++) {
                    int[] loc1 = locations.get(i);
                    int[] loc2 = locations.get(j);

                    int dx = loc2[0] - loc1[0];
                    int dy = loc2[1] - loc1[1];

                    int[] antiNode1 = new int[]{loc1[0] - dx, loc1[1] - dy};
                    int[] antiNode2 = new int[]{loc2[0] + dx, loc2[1] + dy};

                    if(antiNode1[0] >= 0 && antiNode1[0] < rows && antiNode1[1] >= 0 && antiNode1[1] < cols){
                        String an1 = String.valueOf(antiNode1[0]) + "," + String.valueOf(antiNode1[1]);
                        antinodes.add(an1);
                    }
                    if(antiNode2[0] >= 0 && antiNode2[0] < rows && antiNode2[1] >= 0 && antiNode2[1] < cols){
                        String an2 = String.valueOf(antiNode2[0]) + "," + String.valueOf(antiNode2[1]);
                        antinodes.add(an2);
                    }
                }
            }
        }

        return antinodes;
    }

    public static void main(String[] args) {
        List<List<String>> matrix = readInput();
        Map<String, List<int[]>> freqLocations = getFreqLocations(matrix);
        Set<String> antinodes = calculateAntinodes(freqLocations, matrix.size(), matrix.get(0).size());

        System.out.println(antinodes.size());
    }
}
