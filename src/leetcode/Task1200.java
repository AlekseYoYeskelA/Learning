package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task1200 {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int minDif = Integer.MAX_VALUE;
        for (int i = 1; i < arr.length; i++) {
            int dif = arr[i] - arr[i - 1];
            minDif = Math.min(minDif, dif);
        }

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] == minDif) {
                result.add(List.of(arr[i - 1], arr[i]));
            }
        }
        return result;
    }


    public List<List<Integer>> minimumAbsDifference1(int[] arr) {
        // Инициализируйте вспомогательный массив `line`.
        // Запишите минимальный элемент и максимальный элемент.
        int minElement = arr[0];
        int maxElement = arr[0];
        for (int num : arr) {
            minElement = Math.min(minElement, num);
            maxElement = Math.max(maxElement, num);
        }
        int shift = -minElement;
        int[] line = new int[maxElement - minElement + 1];
        List<List<Integer>> answer = new ArrayList<>();

        // Для каждого целого числа `num` в `arr`, мы увеличиваем строку[num + shift] на 1.
        for (int num : arr) {
            line[num + shift] = 1;
        }

        // Начните с индекса, представляющего минимальное целое число,
        // инициализируйте абсолютную разницу `min_pair_diff` как огромное значение, такое как `max_element - min_element`,
        // чтобы не пропустить абсолютную разницу первой пары.
        int minPairDiff = maxElement - minElement;
        int prev = 0;

        // Итерация по массиву `line` и проверка, содержит ли line[curr] вхождение входного целого числа.
        for (int curr = 1; curr <= maxElement + shift; ++curr) {
            // Если line[curr] == 0, что означает отсутствие вхождения целого числа (curr - shift),
            // хранящегося в этом индексе, то мы переходим к следующему индексу.
            if (line[curr] == 0) {
                continue;
            }

            // Если разница (curr - prev) равна `minPairDiff`, мы добавляем эту пару {prev - shift, curr - shift} в список ответов.
            // В противном случае, если разница (curr - prev) меньше `minPairDiff`, мы опустошаем список ответов
            // и добавляем пару {curr - shift, prev - shift} в список ответов и обновляем `minPairDiff`.
            if (curr - prev == minPairDiff) {
                answer.add(Arrays.asList(prev - shift, curr - shift));
            } else if (curr - prev < minPairDiff) {
                answer = new ArrayList<>();
                minPairDiff = curr - prev;
                answer.add(Arrays.asList(prev - shift, curr - shift));
            }

            // Update prev as curr.
            prev = curr;
        }

        return answer;
    }
}


class Test1200 {
    public static void main(String[] args) {
        Task1200 t = new Task1200();
        int[] arr = {40, 11, 26, 27, -20}; //[[26,27]]
        System.out.println(t.minimumAbsDifference(arr));
    }
}
