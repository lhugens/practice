import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Part2 {

    public static boolean reportSafe(String report) {

        String[] reportStringArr = report.split(" ");
        List<Integer> reportArr = new ArrayList<>();
        for (String s : reportStringArr) {
            reportArr.add(Integer.parseInt(s));
        }

        boolean tolerated = false;

        boolean increasing = reportArr.get(1) - reportArr.get(0) > 0 ? true : false;

        if (increasing) {
            for (int i = 0; i < reportArr.size() - 1; i++) {
                int diff = reportArr.get(i + 1) - reportArr.get(i);
                if (!(diff > 0 && diff < 4)) {
                    if(tolerated == false) {
                        tolerated = true;
                        continue;
                    }
                    return false;
                }
            }
        } else {
            for (int i = 0; i < reportArr.size() - 1; i++) {
                int diff = reportArr.get(i) - reportArr.get(i + 1);
                if (!(diff > 0 && diff < 4)) {
                    if(tolerated == false) {
                        tolerated = true;
                        continue;
                    }
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        try {
            FileReader reader = new FileReader("input.txt");

            BufferedReader bReader = new BufferedReader(reader);

            String line;

            int count = 0;

            while ((line = bReader.readLine()) != null) {
                if(reportSafe(line)){
                    count++;
                }
            }

            System.out.println(count);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
