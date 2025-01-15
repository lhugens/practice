import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part1 {

    public static void main(String[] args) {

        try {

            FileReader reader = new FileReader("input.txt");

            BufferedReader bReader = new BufferedReader(reader);

            String line;

            String regex = "mul\\([0-9]{1,3},[0-9]{1,3}\\)";
            List<String> matches = new ArrayList<>();

            while ((line = bReader.readLine()) != null) {

                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    matches.add(matcher.group());
                }

            }

            int result = 0;

            for (String match : matches) {
                match = match.replace("mul(", "");
                match = match.replace(")", "");
                int X = Integer.parseInt(match.split(",")[0]);
                int Y = Integer.parseInt(match.split(",")[1]);
                result += X*Y;
            }

            System.out.println(result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
