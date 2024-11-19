import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Solution {

    public static int firstUniqChar(String s) {

        Map<Character, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s.length(); i++) {
           if(map.get(s.charAt(i)) == 1){
               return i;
           }
        }

        return -1;
    }

    public static void main(String[] args) {
        String s;

        s = "leetcode";
        System.out.println(firstUniqChar(s));

        s = "loveleetcode";
        System.out.println(firstUniqChar(s));

        s = "aabb";
        System.out.println(firstUniqChar(s));
    }
}
