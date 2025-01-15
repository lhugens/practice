import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part1 {

    public static boolean isValid(List<Integer> update, List<List<Integer>> pageOrder) {
        for (int i = 0; i < update.size(); i++) {
            for (int j = 0; j < update.size(); j++) {
                if (i < j && !pageOrder.contains(new ArrayList<>(List.of(update.get(i), update.get(j))))) {
                    return false;
                }
                if (i > j && !pageOrder.contains(new ArrayList<>(List.of(update.get(j), update.get(i))))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

        try {

            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);

            String line = "";

            boolean b = false;

            List<List<Integer>> pageOrder = new ArrayList<>();
            List<List<Integer>> updates = new ArrayList<>();

            while ((line = reader.readLine()) != null) {
                if (line.equals("")) {
                    b = true;
                } else if (!b) {
                    String[] l1 = line.split("\\|");
                    int page1 = Integer.parseInt(l1[0]);
                    int page2 = Integer.parseInt(l1[1]);
                    pageOrder.add(new ArrayList<>(List.of(page1, page2)));
                } else {
                    String[] l2 = line.split(",");
                    List<Integer> l3 = new ArrayList<>();
                    for (String s : l2) {
                        l3.add(Integer.parseInt(s));
                    }
                    updates.add(l3);
                }
            }

            reader.close();
            fileReader.close();

            List<List<Integer>> validUpdates = new ArrayList<>();

            for (List<Integer> update : updates) {
                if(isValid(update, pageOrder)){
                    validUpdates.add(update);
                }
            }

            int result = 0;

            for (List<Integer> validUpdate : validUpdates) {
               result += validUpdate.get(validUpdate.size() / 2);
            }

            System.out.println(result);


        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
