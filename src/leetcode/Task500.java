package leetcode;//Учитывая массив строк words, верните слова, которые можно набрать с использованием букв алфавита
// только в одной строке американской клавиатуры, как показано на рисунке ниже .
//
//первая строка состоит из символов "qwertyuiop",
//вторая строка состоит из символов "asdfghjkl", и
//третья строка состоит из символов "zxcvbnm".
//
// Example 1:
//
//Input: words = ["Hello","Alaska","Dad","Peace"]
//Output: ["Alaska","Dad"]
//Example 2:
//
//Input: words = ["omk"]
//Output: []
//Example 3:
//
//Input: words = ["adsdf","sfd"]
//Output: ["adsdf","sfd"]

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Task500 {
    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        //String row3 = "zxcvbnm";
        List<String> list = new ArrayList<>();
        for (String word : words) { //пробегаем по словам
            int count1 = 0, count2 = 0, count3 = 0; //инициализируем счетчики совпадений
            for (int i = 0; i < word.length(); i++) { //пробегаем по буквам каждого слова
                //String ch = word.charAt(i)+"".toLowerCase();// O(N∗M)
                String ch = String.valueOf(word.charAt(i)).toLowerCase();// этот вариант быстрее
                //считаем количество совпадений символов из слова для каждой строки
                if (row1.contains(ch)) {
                    count1++;
                } else if (row2.contains(ch)) {
                    count2++;
                } else {
                    count3++;
                }
            }
            if (count1 == word.length() || count2 == word.length() || count3 == word.length()) { // сравниваем длину слова с количеством совпадений
                list.add(word); // добавляем слово в список, если true
            }
        }
        return list.toArray(new String[0]);
    }

    public static String[] findWords1(String[] words) {
        String row1 = "qwertyuioop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";

        AtomicInteger count1 = new AtomicInteger(0);
        AtomicInteger count2 = new AtomicInteger(0);
        AtomicInteger count3 = new AtomicInteger(0);

        return Arrays.stream(words)
                .peek(word -> {
                    count1.set(0);
                    count2.set(0);
                    count3.set(0);
                })
                .filter(word -> word.chars()
                        .map(Character::toLowerCase)
                        .filter(ch -> isNotContains(row1, count1, (char) ch))
                        .filter(ch -> isNotContains(row2, count2, (char) ch))
                        .filter(ch -> isNotContains(row3, count3, (char) ch))
                        .mapToObj(ch -> false)
                        .findAny()
                        .orElse(count1.get() == word.length()
                                || count2.get() == word.length()
                                || count3.get() == word.length()))
                .toArray(String[]::new);
    }

    private static boolean isNotContains(String row, AtomicInteger count, char ch) {
        int result = row.indexOf(ch);
        if (result != -1) {
            count.incrementAndGet();
        }
        return result == -1;
    }

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] words1 = {"Alaska"};
        //System.out.println(Arrays.toString(findWords(words)));
        System.out.println(Arrays.toString(findWords1(words)));
    }
}