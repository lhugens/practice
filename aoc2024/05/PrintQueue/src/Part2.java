import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class Part2 {

    private static List<Integer> sortUpdate(List<Integer> update, List<List<Integer>> rulesL) {
        List<int[]> rules = new ArrayList<>();
        for (int i = 0; i < rulesL.size(); i++) {
            rules.add(new int[]{rulesL.get(i).get(0), rulesL.get(i).get(1)});
        }

        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> inDegree = new HashMap<>();
        Set<Integer> pages = new HashSet<>(update);

        for (int page : pages) {
            graph.put(page, new ArrayList<>());
            inDegree.put(page, 0);
        }

        for (int[] rule : rules) {
            if (pages.contains(rule[0]) && pages.contains(rule[1])) {
                graph.get(rule[0]).add(rule[1]);
                inDegree.put(rule[1], inDegree.get(rule[1]) + 1);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int page : update) {
            if (inDegree.get(page) == 0) {
                queue.add(page);
            }
        }

        List<Integer> sortedUpdate = new ArrayList<>();
        while (!queue.isEmpty()) {
            int page = queue.poll();
            sortedUpdate.add(page);
            for (int neighbor : graph.get(page)) {
                inDegree.put(neighbor, inDegree.get(neighbor) - 1);
                if (inDegree.get(neighbor) == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return sortedUpdate;
    }

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

            List<List<Integer>> invalidUpdates = new ArrayList<>();

            mainFor:
            for (List<Integer> update : updates) {
                if (!isValid(update, pageOrder)) {
                    invalidUpdates.add(update);
                }
            }

            List<List<Integer>> validUpdates = new ArrayList<>();

            for (List<Integer> invalidUpdate : invalidUpdates) {
               validUpdates.add(sortUpdate(invalidUpdate, pageOrder));
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
