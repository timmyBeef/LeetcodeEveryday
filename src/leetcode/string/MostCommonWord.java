package leetcode.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MostCommonWord {
    public static String mostCommonWord(String paragraph, String[] banned) {
        String[] ary = paragraph.toLowerCase().split("\\W");
        HashSet<String> set = new HashSet<>(Arrays.asList(banned));

        Map<String, Integer> map = new HashMap<>();
        for (String s : ary) {
            if (!set.contains(s) && s.length() != 0) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        System.out.println(map.keySet());
        int max = Integer.MIN_VALUE;
        String result = "";
        for (String m : map.keySet()) {
            System.out.println("m:[" + m + "]");
            System.out.println(map.get(m));
            if (map.get(m) > max) {
                max = map.get(m);
                result = m;
            }
        }
        return result;
    }

    // better way
    public static String mostCommonWord2(String paragraph, String[] banned) {
        paragraph += ",";
        HashSet set = new HashSet(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();

        int max = Integer.MIN_VALUE;
        String result = "";

        StringBuilder sb = new StringBuilder();
        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                sb.append(Character.toLowerCase(c));
            } else if (sb.length() > 0) {
                String s = sb.toString();
                if (!set.contains(s)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                    if (map.get(s) > max) {
                        max = map.get(s);
                        result = s;
                    }
                }
                sb = new StringBuilder();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(MostCommonWord.mostCommonWord("Bob. hIt, baLl", new String[]{"bob", "hit"}));
    }
}
