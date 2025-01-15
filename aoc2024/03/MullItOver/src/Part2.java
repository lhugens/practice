import javax.management.openmbean.OpenMBeanAttributeInfo;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Part2 {

    public static void main(String[] args) {

        try {

            FileReader reader = new FileReader("input.txt");
            BufferedReader bReader = new BufferedReader(reader);

            String line;
            String regex = "do\\(\\)|don't\\(\\)|mul\\([0-9]{1,3},[0-9]{1,3}\\)";
            Pattern pattern = Pattern.compile(regex);

            int result = 0;
            boolean isMulEnabled = true; // Initially, mul operations are enabled

            while ((line = bReader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);

                while (matcher.find()) {
                    String match = matcher.group();
                    System.out.println(match);

                    if (match.equals("do()")) {
                        isMulEnabled = true; // Enable mul instructions
                    } else if (match.equals("don't()")) {
                        isMulEnabled = false; // Disable mul instructions
                    } else if (match.startsWith("mul(") && isMulEnabled) {
                        // Extract numbers from mul(X,Y)
                        String[] numbers = match.substring(4, match.length() - 1).split(",");
                        int X = Integer.parseInt(numbers[0]);
                        int Y = Integer.parseInt(numbers[1]);

                        // Add the product to the result
                        result += X * Y;
                    }
                }
            }

            bReader.close();
            System.out.println("Sum of enabled multiplications: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
