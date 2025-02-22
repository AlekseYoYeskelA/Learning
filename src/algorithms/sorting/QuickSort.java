package algorithms.sorting;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        //System.out.println("До сортировки:\n" + Arrays.toString(array));
        quickSort(array, 0, array.length - 1);
        //System.out.println("После сортировки:\n" + Arrays.toString(array));
    }

    //сложность О(n*log(n))
    public static void quickSort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to); //индекс, на котором массивы делится на подмассивы
            printSortStep(array, from, to, divideIndex);
            quickSort(array, from, divideIndex - 1); //левый подмассив
            quickSort(array, divideIndex, to); //правый подмассив
        }
    }

    //разделение массива на подмассивы
    private static int partition(int[] array, int from, int to) {
        int right = to;
        int left = from;
        int pivot = array[from + (to - from) / 2]; //опорный элемент

        while (left <= right) {
            //находим элемент меньше опорного
            while (array[left] < pivot) {
                left++;
            }
            //находим элемент больше опорного
            while (array[right] > pivot) {
                right--;
            }
            //если эл-т в левой части больше опорного, а эл-т в правой части меньше, то меняем их местами
            if (left <= right) {
                swap(array, right, left);
                left++;
                right--;
            }
        }
        return left;
    }

    //меняем элементы местами
    private static void swap(int[] array, int index1, int index2) {
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }


    //методы для печати
    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }

    private static void printSortStep(int[] arr, int from, int to, int partitionIndex) {
        System.out.print(arrayToString(arr));
        System.out.print("\npartition at index: " + partitionIndex);
        System.out.print(", left: " + arrayToString(Arrays.copyOfRange(arr, from, partitionIndex)));
        System.out.println(", right: " + arrayToString(Arrays.copyOfRange(arr, partitionIndex, to + 1)) + "\n");
    }
}
