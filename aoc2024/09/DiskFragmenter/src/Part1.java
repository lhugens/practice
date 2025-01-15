import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Deque;
import java.util.LinkedList;

public class Part1 {

    public static String getInput() {
        StringBuilder builder = new StringBuilder();
        try {
            FileReader fileReader = new FileReader("input.txt");
            BufferedReader reader = new BufferedReader(fileReader);
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder.toString();
    }

    public static String expand(String memory) {
        StringBuilder builder = new StringBuilder();
        boolean free = false;
        int id = 0;
        int maxOutputSize = 10000; // Limit the output size to 10,000 characters

        for (int i = 0; i < memory.length(); i++) {
            Character chr = memory.charAt(i);
            if (!Character.isDigit(chr)) {
                throw new IllegalArgumentException("Input string contains non-numeric characters.");
            }

            int count = Integer.valueOf(chr - '0');
            if (free) {
                for (int j = 0; j < count; j++) {
                    if (builder.length() >= maxOutputSize) {
                        return builder.toString();
                    }
                    builder.append('.');
                }
            } else {
                for (int j = 0; j < count; j++) {
                    if (builder.length() >= maxOutputSize) {
                        return builder.toString();
                    }
                    builder.append(id);
                }
                id++;
            }
            free = !free;
        }
        return builder.toString();
    }

    public static String move(String expanded) {
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < expanded.length(); i++) {
            if (expanded.charAt(i) != '.') {
                deque.add(expanded.charAt(i));
            }
        }
        StringBuilder moved = new StringBuilder();
        int i = 0;
        while (!deque.isEmpty()) {
            if (expanded.charAt(i) == '.') {
                moved.append(deque.pollLast());
            } else {
                moved.append(deque.pollFirst());
            }
            i++;
        }
        return moved.toString();
    }

    public static int checksum(String moved) {
        int result = 0;
        for (int i = 0; i < moved.length(); i++) {
            result += i * Integer.valueOf(moved.charAt(i) - '0');
        }
        return result;
    }

    public static void main(String[] args) {
        String memory = getInput();
        //System.out.println("Input: " + memory);
        String expanded = expand(memory);
        //System.out.println("Expanded: " + expanded);
        String moved = move(expanded);
        //System.out.println("Moved: " + moved);
        int checksum = checksum(moved);
        System.out.println("Checksum: " + checksum);
    }
}