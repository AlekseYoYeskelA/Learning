package leetcode;//Даны две строки s и t, вернуть , true если t является анаграммой s, и false в противном случае .
//
//Анаграмма — это слово или фраза , образованные путем перестановки букв другого слова или фразы,
//обычно с использованием всех исходных букв ровно один раз.
//Example 1:
//
//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:
//
//Input: s = "rat", t = "car"
//Output: false


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Task242 {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] string = s.toCharArray();
        char[] target = t.toCharArray();
        Arrays.sort(string);
        Arrays.sort(target);
        return Arrays.equals(string, target);
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> mapS = getLetterStat(s);
        Map<Character, Integer> mapT = getLetterStat(t);
        return mapS.equals(mapT);
    }

    private static Map<Character, Integer> getLetterStat(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        return map;
    }


    public static boolean isAnagram3(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        String str1 = charToString(s);
        String str2 = charToString(t);
        return str1.equals(str2);
    }

    static String charToString(String s) {
        String sortStr = s.chars()
                .mapToObj(ch -> (char) ch)
                .sorted()
                .map(character -> String.valueOf(character))
                .collect(Collectors.joining());
        return sortStr;
    }

    public static void main(String[] args) {
        String s = "caccs";
        String t = "cassc";
        System.out.println(isAnagram3(s, t));
    }
}


