package algorithms.searching;

import java.util.Arrays;

public class SearchElement {
    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        Arrays.sort(array);
        System.out.println(linearSearch(array, 33));
        System.out.println(binarySearch(array, 33));

    }

    public static int linearSearch(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static int recursiveBinarySearch(int[] array, int startIdx, int endIdx, int target) {
        if (endIdx >= startIdx) {
            int middleIdx = startIdx + (endIdx - startIdx) / 2;

            if (array[middleIdx] == target) {
                return middleIdx;
            }

            if (array[middleIdx] > target) {
                return recursiveBinarySearch(array, startIdx, middleIdx - 1, target);
            } else {
                return recursiveBinarySearch(array, middleIdx + 1, endIdx, target);
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (target == array[middle]) {
                return middle;
            } else if (array[middle] > target) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }
}
