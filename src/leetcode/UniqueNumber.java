package leetcode;

import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class UniqueNumber {
    static int searchFirstUniqueNumber(int[] array) throws UniqueElementNotFoundException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : array) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int current = map.get(num) + 1;
                map.put(num, current);
            }
        }

        for (int num : array) {
            if (map.get(num) == 1) {
                return num;
            }
        }
        throw new UniqueElementNotFoundException("Нет уникальных элементов");
    }

    static int searchFirstUniqueNumber1(int[] array) throws UniqueElementNotFoundException {
        //стрим из массива (гарантирует поиск первого уникального числа)
        Map<Integer, Long> map = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return Arrays.stream(array)
                .filter(num -> map.get(num) == 1)
                .findFirst()
                .orElseThrow(() -> new UniqueElementNotFoundException("Нет уникальных элементов"));
    }

    static int searchAnyUniqueNumber(int[] array) {
        Map<Integer, Long> map = Arrays.stream(array)
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        //стрим из мапы (не гарантирует нахождение первого вхождения из-за особенностей мапы, но гарантирует поиск уникального эл-та)
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Нет уникальных элементов"));
        //.get(); //- метод выбрасывает непроверяемое NoSuchElementException
    }

    static int searchFirstUniqueNumber2(int[] array) {
        return Arrays.stream(array)
                .boxed()
                .collect(Collectors.toMap(Function.identity(), existValue -> 1, (a, b) -> a + 1, LinkedHashMap::new))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Нет уникальных элементов"));
    }
}


class UniqueNumberTest {
    public static void main(String[] args) {
        int[] array = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 1, 3, 2, 4, 5, 6, 7, 8, 9, 10};


        int[] randomArray = new int[20];
        for (int i = 0; i < randomArray.length; i++) {
            Random random = new Random();
            randomArray[i] = random.nextInt(-4, 5);
        }

        System.out.println(Arrays.toString(randomArray));

        try {
            System.out.println(UniqueNumber.searchFirstUniqueNumber(randomArray));
            System.out.println(UniqueNumber.searchFirstUniqueNumber1(randomArray));
        } catch (UniqueElementNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(UniqueNumber.searchAnyUniqueNumber(array));
    }
}

class UniqueElementNotFoundException extends Exception {

    public UniqueElementNotFoundException(String message) {
        super(message);
    }
}


