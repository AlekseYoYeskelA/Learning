package youtube.stream_ex;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CollectorsEx {
    static Map<Integer, List<String>> stringByLength(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(String::length));
    }

    static Map<Integer, String> stringByLength1(List<String> list) {
        return list.stream().collect(Collectors.groupingBy(String::length, Collectors.joining("+")));
    }

    static Map<Integer, Map<Character, List<String>>> stringByLengthAndFirstLetter(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.groupingBy(s -> s.charAt(0))
                ));
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("a", "bb", "c", "dd", "eee");
        System.out.println(stringByLength(list));
        System.out.println(stringByLength1(list));
        System.out.println(stringByLengthAndFirstLetter(list));
    }
}
