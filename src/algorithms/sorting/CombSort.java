package algorithms.sorting;

import java.util.Arrays;

public class CombSort {
    public static void combSort(int[] array) {
        int gap = array.length;

        boolean isSorted = false;
        while (!isSorted || gap != 1) {
            if (gap > 1) {
                gap = gap * 10 / 13; // = gap/1.3
            } else {
                gap = 1;
            }

            isSorted = true;
            for (int i = gap; i < array.length; i++) {
                if (array[i - gap] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - gap];
                    array[i - gap] = tmp;
                    isSorted = false;
                }
            }
        }
    }

    public static void combSort1(int[] array) {
        final double FACTOR = 1.247331;
        int step = array.length;

        while (step >= 1) {
            step = (int) (step / FACTOR);
            for (int i = 0; i + step < array.length; i++) {
                if (array[i] > array[i + step]) {
                    int tmp = array[i];
                    array[i] = array[i + step];
                    array[i + step] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        System.out.println("До сортировки:\n" + Arrays.toString(array));
        combSort1(array);
        System.out.println("После сортировки:\n" + Arrays.toString(array));
    }
}
