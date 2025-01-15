import java.io.BufferedReader;
import java.io.FileReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Part2 {

    public static Map<BigInteger, BigInteger[]> readInput() {

        Map<BigInteger, BigInteger[]> map = new HashMap<>();

        try {

            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(":");

                BigInteger key = new BigInteger(parts[0]);

                String[] elements = parts[1].trim().split(" ");

                BigInteger[] values = new BigInteger[elements.length];

                for (int i = 0; i < elements.length; i++) {
                    values[i] = new BigInteger(elements[i]);
                }

                map.put(key, values);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return map;
    }

    public static List<ExpressionResult> calculateAllExpressions(BigInteger[] arr) {
        List<ExpressionResult> results = new ArrayList<>();
        if (arr.length > 0) {
            helper(arr, 1, arr[0], String.valueOf(arr[0]), results);
        }
        return results;
    }

    private static void helper(BigInteger[] arr, int index, BigInteger currentValue, String currentExpression, List<ExpressionResult> results) {
        if (index == arr.length) {
            results.add(new ExpressionResult(currentExpression, currentValue));
            return;
        }

        helper(arr, index + 1, currentValue.add(arr[index]), "(" + currentExpression + " + " + arr[index] + ")", results);

        helper(arr, index + 1, currentValue.multiply(arr[index]), "(" + currentExpression + " * " + arr[index] + ")", results);

        helper(arr, index + 1, concatenate(currentValue, arr[index]), "(" + currentExpression + " || " + arr[index] + ")", results);
    }

    public static BigInteger concatenate(BigInteger a, BigInteger b){
        return new BigInteger(String.valueOf(a) + String.valueOf(b));
    }

    public static void main(String[] args) {

        Map<BigInteger, BigInteger[]> map = readInput();

        BigInteger totalCalibrationResult = new BigInteger("0");

        mainFor:
        for (BigInteger bigInteger : map.keySet()) {
            BigInteger[] values = map.get(bigInteger);

            List<ExpressionResult> results = calculateAllExpressions(values);
            for (ExpressionResult result : results) {
                System.out.println(result.expression + " = " + result.result);
                if(result.result.equals(bigInteger)){
                    totalCalibrationResult = totalCalibrationResult.add(bigInteger);
                    continue mainFor;
                }
            }

        }

        System.out.println(totalCalibrationResult);

    }

}
