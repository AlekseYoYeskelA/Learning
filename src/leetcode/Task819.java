package leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task819 {
    public static String mostCommonWord(String paragraph, List<String> banned) {
        List<String> words = List.of(paragraph.split(" "));

        return words.stream()
                .map(String::toLowerCase)
                .map(word -> word.replaceAll("[\\p{P}]", ""))
                .filter(word -> !banned.contains(word))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findAny()
                .orElseThrow(() -> new NoSuchElementException("Нет такого слова"));
    }
}

class Test819 {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        List<String> banned = List.of("hit");
        System.out.println(Task819.mostCommonWord(paragraph, banned));
    }
}
