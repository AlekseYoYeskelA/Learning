package leetcode;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task609 {
    private static final Pattern FILE_PATTERN = Pattern.compile("(.*?)\\((.*?)\\)");


    public static List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFilePaths = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String root = parts[0];

            for (int i = 1; i < parts.length; i++) {
                String[] fileParts = parts[i].split("\\(");
                String fileName = fileParts[0];
                String content = fileParts[1].substring(0, fileParts[1].length() - 1);

                String filePath = root + "/" + fileName;
                contentToFilePaths.computeIfAbsent(content, k -> new ArrayList<>()).add(filePath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> filePaths : contentToFilePaths.values()) {
            if (filePaths.size() > 1) {
                result.add(filePaths);
            }
        }
        return result;
    }

    public static List<List<String>> findDuplicate1(String[] paths) {
        return Arrays.stream(paths)
                .flatMap(path -> {
                    String[] parts = path.split(" ");
                    String root = parts[0];
                    return Arrays.stream(parts, 1, parts.length)
                            .map(file -> {
                                String[] fileParts = file.split("\\(");
                                String fileName = fileParts[0];
                                String content = fileParts[1].substring(0, fileParts[1].length() - 1);
                                return new AbstractMap.SimpleEntry<>(content, root + "/" + fileName);
                            });
                })
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .values().stream()
                .filter(list -> list.size() > 1)
                .collect(Collectors.toList());
    }


    public static List<List<String>> findDuplicate2(String[] paths) {
        return Arrays.stream(paths)
                .flatMap(path -> processPath(path))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toList())))
                .values().stream()
                .filter(group -> group.size() > 1)
                .collect(Collectors.toList());
    }

    //вспомогательный метод для обработки пути, извлекает корень, обрабатывает каждый файл в пути
    private static Stream<Map.Entry<String, String>> processPath(String path) {
        String[] parts = path.split(" ");
        String root = parts[0];
        return Arrays.stream(parts, 1, parts.length)
                .map(file -> parseFile(root, file));
    }

    //вспомогательный метод для разбора файла, возвращает пару "содержимое = путь"
    private static Map.Entry<String, String> parseFile(String root, String file) {
        var matcher = FILE_PATTERN.matcher(file);
        matcher.find();
        return new AbstractMap.SimpleEntry<>(matcher.group(2), root + "/" + matcher.group(1));
    }
}


class Test609 {
    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};

        System.out.println("findDuplicate: " + Task609.findDuplicate(paths));
        System.out.println("findDuplicate1: " + Task609.findDuplicate(paths));
        System.out.println("findDuplicate2: " + Task609.findDuplicate(paths));
    }
}
