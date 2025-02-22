package algorithms.searching;

public class SecondMinE {
    public static void main(String[] args) {
        int[] array = {61, 45, 88, 73, 19, 21, 6, 15, 7, 3, 33, 69, 95, 11, 55};
        int[] array1 = {1, 1, 1, 1, 1};
        System.out.println(findSecondMinE(array));
    }

    public static int findSecondMinE(int[] array) {
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < array.length; i++) {
            if (min > array[i]) {
                min2 = min;
                min = array[i];
            } else if (array[i] < min2 && array[i] != min) {
                min2 = array[i];
            }
        }
        if (min2 != Integer.MAX_VALUE) {
            return min2;
        }
        return min;
    }
}
