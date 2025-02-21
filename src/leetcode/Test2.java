package leetcode;

import java.util.Arrays;

public class Test2 {
    public static int[] twoInOne (int[] arr1, int[] arr2){
        int [] arr3 = new int[arr1.length+arr2.length];
        int i = 0;
        for(int index=0; index<arr1.length; index++){
            arr3[i++] = arr1[index];
        }
        for(int index2=0; index2<arr2.length; index2++){
            arr3[i++] = arr2[index2];
        }
        Arrays.sort(arr3);
        return arr3;
    }

    public static int[] twoInOne2(int[] arr1, int[] arr2) {
        int[] arr3 = new int[arr1.length + arr2.length];
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        while (index1 < arr1.length && index2 < arr2.length) {
            if (arr1[index1] < arr2[index2]) {
                arr3[index3++] = arr1[index1++];
            } else {
                arr3[index3++] = arr2[index2++];
            }
        }
        while (index1 < arr1.length) {
            arr3[index3++] = arr1[index1++];
        }
        while (index2 < arr2.length) {
            arr3[index3++] = arr2[index2++];
        }
        return arr3;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,1,1,1,1,2,2,3};
        int[] arr2 = {1, 2, 14, 25}; // {1,1,3,5,5,6,7,9,10}

        System.out.println(Arrays.toString(twoInOne(arr1, arr2)));

    }
}

