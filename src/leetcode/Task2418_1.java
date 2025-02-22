package leetcode;

import java.util.Arrays;

public class Task2418_1 {
    // Метод partition определяет положение опорного эл-та и переставляет эл-ты так, чтобы эл-ты меньше опорного
    // находились слева от него, а больше - справа
    public static int partition(int[] heights, String[] names, int low, int high) {
        int pivot = heights[high];  // Опорный элемент - последний элемент массива (могут быть другие эл-ты)
        int i = low - 1;  // Индекс минимального элемента массива

        for (int j = low; j < high; j++) {
            // Если текущий элемент больше или равен опорному элементу (pivot),
            if (heights[j] >= pivot) {
                i++;

                //Меняем местами heights[i] и heights[j]
                int temp = heights[i];
                heights[i] = heights[j];
                heights[j] = temp;

                // Меняем местами соответствующие имена
                String tempName = names[i];
                names[i] = names[j];
                names[j] = tempName;
            }
        }

        // Меняем местами heights[i + 1] и heights[high] (или pivot)
        int temp = heights[i + 1];
        heights[i + 1] = heights[high];
        heights[high] = temp;

        // Меняем местами соответствующие имена
        String tempName = names[i + 1];
        names[i + 1] = names[high];
        names[high] = tempName;

        return i + 1;
    }

    //Рекурсивный метод qSort на вход принимает массивы, а также нижний и верхний индексы.
    public static void qSort(String[] names, int[] heights, int low, int high) {
        if (low < high) {
            // Если low < high, происходит разделение массива с помощью метода partition
            int pi = partition(heights, names, low, high);

            // Рекурсивная сортировка элементов левого и правого подмассивов
            qSort(names, heights, low, pi - 1);
            qSort(names, heights, pi + 1, high);
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        qSort(names, heights, 0, heights.length - 1);
        return names;
    }

    public static void main(String[] args) {
        String[] names = {"Mary", "John", "Emma", "Alice", "Bob", "Bob"};
        int[] heights = {180, 165, 170, 155, 185, 175};
        String[] result = sortPeople(names, heights);
        System.out.println(Arrays.toString(result));
    }
}

