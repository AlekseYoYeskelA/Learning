package parser;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Parser {
    public static void main(String[] args) throws IOException {
//        System.out.println(findWordAndCount("C:\\Users\\Алексей\\Desktop\\text.txt", "[T|t]he"));
//        System.out.println("-----------------------------------------------------");

        parseCharAndPrint("C:\\Users\\Алексей\\Desktop\\Толстой Лев. Война и мир. Книга 1 - royallib.ru.txt", "[\\p{P}]");
        //"[\\p{P}]"
    }

    private static String readFromFile(String path) {
        try {
            return Files.readString(Paths.get(path), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static Map<String, Long> groupingAndCount(String text, String regex) {
        return text.chars()
                .mapToObj(ch -> (char) ch)
                .map(String::valueOf)
                .filter(ch -> ch.matches(regex))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public static void parseCharAndPrint(String path, String regex) {
        var map = groupingAndCount(readFromFile(path), regex);
        map.forEach((key, value) -> System.out.printf("Символ: %s   Количество в тексте: %s\n", key, value));
    }


    public static Map<String, Long> findWordAndCount(String path, String regex) throws IOException {
        return Files.lines(Path.of(path), StandardCharsets.UTF_8)
                .map(lines -> lines.split("[\\W]+"))
                .flatMap(Arrays::stream)
                .peek(System.out::println)
                .filter(ch -> ch.matches(regex))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
