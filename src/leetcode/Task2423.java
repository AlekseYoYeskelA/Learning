
// You are given a 0-indexed string word, consisting of lowercase English letters.
// You need to select one index and remove the letter at that index from word
// so that the frequency of every letter present in word is equal.
//
// Return true if it is possible to remove one letter so that the frequency
// of all letters in word are equal, and false otherwise.
//
// Note:
//    The frequency of a letter x is the number of times it occurs in the string.
//    You must remove exactly one letter and cannot choose to do nothing.

// Input: word = "abcc"
// Output: true
//
// Input: word = "aazz"
// Output: false

// Hint 1
// Brute force all letters that could be removed.
// Hint 2
// Use a frequency array of size 26.
package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task2423 {
    public static void main(String[] args) {
        check("abcc", true);
        check("aazz", false);

        //fails
        check("bac", true);
        check("ddaccb", false);
        check("abbcc", true);
        check("aca", true);
        check("zz", true);
        check("cccd", true);
        check("dzwguwwjah", false);
        check("aaaabbbbccc", false);
        check("aabbbccc", false);

        //my
        check("abbccddd", false);
        check("aabbcc", false);
        check("qw", true);
        check("aasssdddd", false);
        check("aasssdd", true);
        check("assdddffffggggg", false);
        check("aassdddffffgggg", false);
    }

    static void check(String input, boolean expected) {
        boolean output = equalFrequency3(input);
        System.out.println(input + " - " + output +
                (output == expected ? " - OK" : " - WRONG!!!")
        );
    }

    public static boolean equalFrequency(String word) {
        int[] charCountArray = new int[26];
        int maxCount = 0;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int current = ++charCountArray[ch - 'a'];
            if (current > maxCount) {
                maxCount = current;
            }
        }

        //"все символы одинаковые" и "все символы разные" подходят сразу
        // "aaaaa" maxCount=5            "abcde" maxCount=1
        if (maxCount == word.length() || maxCount == 1) {
            return true;
        }

        int minCount = 100;
        int minCountChars = 0;
        int maxCountChars = 0;
        for (int count : charCountArray) {
            if (count == 0) {
                continue;
            }

            if (count == maxCount) {
                maxCountChars++;
            }

            if (count == minCount) {
                minCountChars++;
            } else if (count < minCount) {
                minCount = count;
                minCountChars = 1;
            }
        }
//        System.out.println("minCount="+minCount+" minCountChars="+minCountChars
//                +" maxCount="+maxCount+" maxCountChars="+maxCountChars);

        if (word.length() - (maxCount * maxCountChars + minCount * minCountChars) > 0) {
            return false;
        }

        // Проверяем существует ли что-то кроме символов с минимальным и максимальным кол-вом.
        // В строке не должно остаться символов после вычитания тех и других
        // "abccdd" >> 6-(1*2)-(2*2) == 0    "abbccddd" >> 8-(1*1)-(3*1) == 4


        // Осталось две группы символов: с минимальным и с максимальным количеством.
        // Условию задачи удовлетворяют только два варианта:
        // 1. Должен быть одинокий символ чтобы его убрать совсем, а других останется равное кол-во.
        // Н-р "cccd", "cccaaad", но не "cccde"
        // 2. Должен быть символ с количеством всего на 1 больше всех остальных.
        // Н-р "abcc", "aabbccc", но не "abccee", "aabbcccddd"
        return (minCount == 1 && minCountChars == 1) ||
                (maxCount - 1 == minCount && maxCountChars == 1);
    }

    // чужое решение
    static boolean equalFrequency2(String word) {
        var counts = new int[26];
        int distinct = 0;
        for (var ch : word.toCharArray()) {
            if (counts[ch - 'a']++ == 0) distinct++;
        }
        Arrays.sort(counts);
        return distinct == 1
                || counts[25] == 1
                || counts[25] - counts[24] == 1 && counts[26 - distinct] == counts[24]
                || counts[26 - distinct] == 1 && counts[25] == counts[27 - distinct];
    }


    // чужие стримы
    static boolean equalFrequency3(String word) {

        List<Long> chCounts = word.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .values().stream()
                .sorted(Long::compareTo)
                .toList();

        int last = chCounts.size() - 1;
        return chCounts.size() == 1
                || chCounts.get(last) == 1
                || chCounts.get(last) - chCounts.get(last - 1) == 1 && chCounts.get(0) == chCounts.get(last - 1)
                || chCounts.get(0) == 1 && chCounts.get(last) == chCounts.get(1);
    }
}

