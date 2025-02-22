package leetcode;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class LongestPalindrome {
    public static void main(String[] args) {
        System.out.println("Cтрим: " + longestPalindrome1("aaaccbbaaa"));
        System.out.println("Цикл: " + longestPalindrome("aaaccbbaaa"));
    }

    public static int longestPalindrome(String s) {
        Set<Character> set = new HashSet<>(); //Используем HashSet для сохранения ключей
        int pairs = 0;
        for (char c : s.toCharArray()) {    // преобразуем String в массив Char
            if (set.contains(c)) {          // если Set уже содержит ключ,
                set.remove(c);              // то удаляем существующий
                pairs++;                    // и добавляем единицу в счётчик пар
            } else {                        // если такого ключа нет,
                set.add(c);                 // то вносим значение в сет
            }
        }
        return set.isEmpty() ? pairs * 2 : pairs * 2 + 1; // если палиндром четной длины, то умножаем на 2,
    }

    public static int longestPalindrome1(String s) {
        Set<Integer> set = new HashSet<>();

        //AtomicInteger pairs = new AtomicInteger(0);

        int pairs = (int) s.chars()
                .filter(ch -> !set.add(ch))
                .mapToObj(set::remove)
                .count();

                //.peek(ch -> pairs.incrementAndGet())
                //.forEach(set::remove);


        return set.isEmpty() ? pairs * 2 : pairs * 2 + 1;
    }


    public static int longestPalindrome2(String s) {
        Map<Integer, Long> map = s.chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(map);

        long summ = map.values().stream()
                .filter(value -> value >= 2)
                .mapToLong(value -> {
                    if (value % 2 == 1) {
                        return value - 1;
                    }
                    return value;
                })
                .sum();

        return Math.toIntExact(map.values()
                .stream()
                .filter(value -> value % 2 == 1)
                .map(value -> summ + 1)
                .findFirst()
                .orElse(summ));
    }
}
