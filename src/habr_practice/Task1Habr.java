package habr_practice;

import java.util.Arrays;

public class Task1Habr {
    public static double[] minMaxAvgValues(double[] arr) {
        double min = arr[0];
        double max = arr[0];
        double avg = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
            avg += arr[i] / arr.length;
        }
        return new double[]{min, max, avg};
    }

    public static double[] bubbleSort(double[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    double tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        return arr;
    }

    public static void primeNumbers() {
        for (int i = 2; i <= 100; i++) {
            boolean isPrime = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.print(i + " ");
            }
        }
    }

    public static void primeNumbers2() {
        OUTER:
        for (int i = 2; i <= 100; i++) {
            INNER:
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    continue OUTER;
                }
            }
            System.out.print(i + " ");
        }
    }

    public static int[] removeElement(int[] arr, int val) {
        int offset = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == val) {
                offset++;
            } else {
                arr[i - offset] = arr[i];
            }
        }
        return Arrays.copyOf(arr, arr.length - offset);
    }


    public static void main(String[] args) {
        double[] arr = new double[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Math.random();
        }
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(minMaxAvgValues(arr)));
        System.out.println("--------------------------------------");

        System.out.println(Arrays.toString(bubbleSort(arr)));
        System.out.println("--------------------------------------");

        primeNumbers();
        System.out.println("\n--------------------------------------");

        primeNumbers2();
        System.out.println("\n--------------------------------------");

        int[] array = {1, 3, 1, 2, 6, 8, 9, 1, 4, 5, 7};
        System.out.println(Arrays.toString(removeElement(array, 1)));

    }
}


