import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Stream;

public class Solution {

    public static boolean isAnagram(String s, String t){

        if(s.length() != t.length()){
            return false;
        }

        Map<Character, Integer> sMap = new TreeMap<>();
        Map<Character, Integer> tMap = new TreeMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0)+1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0)+1);
        }

        return sMap.equals(tMap);

    }

    public static void main(String[] args) {
        String s;
        String t;

        s = "anagram";
        t = "nagaram";

        System.out.println(isAnagram(s, t));

        s = "rat";
        t = "car";

        System.out.println(isAnagram(s, t));

    }

}
