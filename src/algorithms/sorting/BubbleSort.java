package algorithms.sorting;

import java.util.Arrays;

public class BubbleSort {
    //сложность О(n^2)
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
            //System.out.println(Arrays.toString(array));
        }
    }

    public static void bubbleSort1(int[] array) {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;
            for (int i = 1; i < array.length; i++) {
                if (array[i] < array[i - 1]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
            //System.out.println(Arrays.toString(array));
        }
    }

    public static int bubbleSortKnuth(int[] array) {
        int count = 0;
        int k = 1;
        int j = array.length;
        while (k > 0) {
            k = 0;
            for (int i = 1; i < j; i++) {
                if (array[i - 1] > array[i]) {
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    k = 1;
                }
                count++;
            }
            j = k;
        }
        return count;
    }


    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        System.out.println("До сортировки:\n" + Arrays.toString(array));
        bubbleSort(array);
        //bubbleSort1(array);
        System.out.println("После сортировки:\n" + Arrays.toString(array));
    }
}

