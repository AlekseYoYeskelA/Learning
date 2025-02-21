package leetcode;

import java.util.*;

public class Task14 {
    public static final String EMPTY_STRING = "empty";

    public String longestCommonPrefix(String[] strs) {
        if (Objects.isNull(strs) || strs.length == 0) {                        // проверяем есть ли в массиве элементы
            return EMPTY_STRING;// если нет, то возвращаем пустую строку
        }

        //сравнение первых букв с помощью цикла
//        for (int i = 1; i < strs.length; i++) {
//            if (strs[i].charAt(0) != strs[i - 1].charAt(0)) {
//                return EMPTY_STRING;
//            }
//        }

        //сравнение первых букв с помощью стрима
        char ch = strs[0].charAt(0);
        boolean isNotSame = Arrays.stream(strs)
                .anyMatch(word -> ch != word.charAt(0));

        if (isNotSame) {
            return EMPTY_STRING;
        }

        String prefix = Arrays.stream(strs)
                .min(Comparator.comparingInt(String::length))
                .get();
        System.out.println("prefix " + prefix);


        int min = strs[0].length();
        String word = strs[0];

        for (int i = 1; i < strs.length; i++) {
            if (min > strs[i].length()) {
                min = strs[i].length();
                word = strs[i];
            }
        }
        System.out.println("Слово " + word);


        // создаем переменную prefix и назначаем ей значение нулевого элемента массива ("flowers")
        for (int i = 1; i < strs.length; i++) {      // с помощью цикла for начинаем итерировать массив
            while (strs[i].indexOf(prefix) != 0) {   // создаем внутренний цикл while с условием того, что 0-ой и 1-й элементы массива не равны. Как только они становятся равными - цикл завершается
                prefix = prefix.substring(0, prefix.length() - 1); //перезаписываем значение 0-го элемента ("flower","flowe","flow") для 1-ой ит-ции цикла for
                if (prefix.isEmpty()) {            // проверяем что перезаписанная переменная не пустая
                    return EMPTY_STRING;
                }
            }
        }
        return prefix;
    }


    public String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return EMPTY_STRING;
        }

        int minLen = Integer.MAX_VALUE;
        for (String word : strs) {
            minLen = Math.min(minLen, word.length());
        }

        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle)) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private boolean isCommonPrefix(String[] strs, int len) {
        String str1 = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1)) {
                return false;
            }
        return true;
    }
}

class Test14 {
    public static void main(String[] args) {
        Task14 prefix1 = new Task14();
        System.out.println(prefix1.longestCommonPrefix1(new String[]{"flower", "flow", "float", "fly"}));
    }
}


