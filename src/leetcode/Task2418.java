package leetcode;//Вам дан массив строк names и массив heights, состоящий из различных положительных целых чисел. Оба массива имеют длину n.
//Для каждого индекса i, names[i] и heights[i] обозначают имя и рост i-го человека.
//
//Возврат names отсортирован в порядке убывания роста людей .
//
//Пример 1:
//Ввод: имена = ["Мэри","Джон","Эмма"], высоты = [180,165,170]
//Выход: ["Мэри","Эмма","Джон"]
//Объяснение: Мэри самая высокая, за ней следуют Эмма и Джон.
//
//Пример 2:
//Ввод: имена = ["Алиса","Боб","Боб"], высоты = [155,185,150]
//Выход: ["Боб","Алиса","Боб"]
//Объяснение: Первый Боб самый высокий, за ним следует Алиса. и второй Боб.
//
//Найдите самого высокого человека и поменяйтесь местами с первым человеком,
//затем найдите второго по высоте человека и поменяйтесь местами со вторым человеком и т. д.
// Повторяйте, пока не исправите всех n человек.

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task2418 {
    public static String[] sortPeople(String[] names, int[] heights) {
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                if (heights[i] < heights[j]) {
                    swapHeights(heights, i, j);
                    swapNames(names, i, j);
                }
            }
        }
        return names;
    }

    public static String[] sortPeople1(String[] names, int[] heights) {
        final double FACTOR = 1.247331;
        int step = heights.length;
        while (step >= 1) {
            step = (int) (step / FACTOR);
            for (int i = 0; i + step < heights.length; i++) {
                if (heights[i] < heights[i + step]) {
                    swapHeights(heights, i, i + step);
                    swapNames(names, i, i + step);
                }
            }
        }
        return names;
    }

    public static void swapHeights(int[] heights, int i, int j) {
        int tmp = heights[j];
        heights[j] = heights[i];
        heights[i] = tmp;
    }

    public static void swapNames(String[] names, int i, int j) {
        String tmp = names[j];
        names[j] = names[i];
        names[i] = tmp;

    }


    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma", "Alice", "Bob", "Bob"};
        int[] heights = {180, 165, 170, 155, 185, 150};
        String[] result = sortPeople(names, heights);
        String[] result1 = sortPeople1(names, heights);
        //System.out.println("Сортировка пузырьком: " + Arrays.toString(result));
        //System.out.println("Сортировка расчёской: " + Arrays.toString(result1));

        List<String> list1 = Arrays.stream(names)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(list1);


    }
}

