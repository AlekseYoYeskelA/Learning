package leetcode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class UnicChar {
    public static void main(String[] args) {
        String[] words = {"apple", "banana", "kiwi"};
        System.out.println(findUnicChars(words));
    }

    public static Character[] findUnicChars(String[] words) {
        return Arrays.stream(words)
                .flatMapToInt(String::chars)
                .mapToObj(ch -> (char) ch)
                .distinct()
                .toArray(Character[]::new);
    }
}
