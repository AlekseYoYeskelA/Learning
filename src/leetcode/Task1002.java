//Если задан массив строк words, верните массив всех символов, которые встречаются во всех строках внутри слов (включая дубликаты).
// Вы можете вернуть ответ в любом порядке.
//
// Example 1:
//Input: words = ["bella","label","roller"]
//Output: ["e","l","l"]

//Example 2:
//Input: words = ["cool","lock","cook"]
//Output: ["c","o"]

package leetcode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task1002 {
    public static List<String> commonChars(String[] words) {
        if (words == null || words.length == 0) {
            return new ArrayList<>();
        }

        List<Map<Character, Long>> freqMap = Arrays.stream(words)
                .map(word -> word.chars()
                        .mapToObj(ch -> (char) ch)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())))
                .collect(Collectors.toList());

        if (freqMap.isEmpty()) {
            return new ArrayList<>();
        }

        Set<Character> commonChars = freqMap.getFirst().keySet().stream()
                .filter(ch -> freqMap.stream()
                        .allMatch(map -> map.containsKey(ch)))
                .collect(Collectors.toSet());

        return commonChars.stream()
                .flatMap(ch -> {
                    long minCount = freqMap.stream()
                            .mapToLong(map -> map.getOrDefault(ch, 0L))
                            .min()
                            .orElse(0);
                    return Stream.generate(() -> String.valueOf(ch))
                            .limit(minCount);
                })
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        String[] arr = {"bella", "label", "roller"};
        System.out.println((commonChars(arr)));
    }
}
