public class Solution {

    public static String longestCommonPrefix(String[] strs) {

        if (strs.length < 2) {
            return strs[0];
        }

        StringBuilder prefix = new StringBuilder();

        int i = 0;
        mainFor:
        while (true) {
            try {
                char current = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].charAt(i) != current) {
                        break mainFor;
                    }
                }
                prefix.append(current);
                i++;
            } catch (Exception e) {
                break mainFor;
            }
        }

            if (prefix != null) {
                return prefix.toString();
            }
        return "";
    }

    public static void main(String[] args) {

        String[] strs;

        strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));

        strs = new String[]{"dog", "racecar", "car"};
        System.out.println(longestCommonPrefix(strs));

        strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));


    }

}
