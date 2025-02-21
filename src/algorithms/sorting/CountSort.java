package algorithms.sorting;

import java.util.Arrays;

public class CountSort {
    // сложность О(n) - линейная, применим только для чисел и потребляет много памяти
    public static void countSort(int[] array) {
    final int MAX_VALUE = 100;

    int[] countArray = new int[MAX_VALUE];

        for (int i = 0; i < array.length; i++) {
            countArray[array[i]] = countArray[array[i]] + 1;
        }

        int arrayIndex = 0;
        for (int i = 0; i < countArray.length; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                array[arrayIndex] = i;
                arrayIndex++;
            }
        }
    }


    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        System.out.println("До сортировки:\n" + Arrays.toString(array));
        countSort(array);
        System.out.println("После сортировки:\n" + Arrays.toString(array));
    }
}
