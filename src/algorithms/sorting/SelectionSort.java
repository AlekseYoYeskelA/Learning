package algorithms.sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            //System.out.println(Arrays.toString(array));
            int index = min(array, step);

            int tmp = array[step];
            array[step] = array[index];
            array[index] = tmp;
        }
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    //сложность О(n^2)
    public static void selectionSort1(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int pos = i;
            int minValue = array[i];

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < minValue) {
                    pos = j;
                    minValue = array[j];
                }
            }
            array[pos] = array[i];
            array[i] = minValue;
        }
    }


    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        System.out.println("До сортировки:\n" + Arrays.toString(array));
        //selectionSort(array);
        selectionSort1(array);
        System.out.println("После сортировки:\n" + Arrays.toString(array));
    }
}
