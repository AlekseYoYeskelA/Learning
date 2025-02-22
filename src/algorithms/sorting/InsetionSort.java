package algorithms.sorting;

import java.util.Arrays;

public class InsetionSort {
    //сложность О(n^2), при небольшом количестве эл-тов работает быстрее, чем quick sort
    public static void insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int current = array[i];
            int j = i;
            while (j > 0 && array[j - 1] > current) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = current;
        }
    }

    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        System.out.println("До сортировки:\n" + Arrays.toString(array));
        insertionSort(array);
        System.out.println("После сортировки:\n" + Arrays.toString(array));
    }
}
