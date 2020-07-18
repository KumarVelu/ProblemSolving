package basic.arrays;

import java.util.Arrays;

public class LeftRotateArrayByDTimes {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 8};
        System.out.println(Arrays.toString(leftRotateArrayByDTimesNaiveApproach(arr, 2)));

        int[] newArr = {2, 4, 5, 1, 8};
        System.out.println(Arrays.toString(leftRotateArrayByDTimesBetterApproach(newArr, 2)));

        int[] anotherArr = {2, 4, 5, 1, 8};
        System.out.println(Arrays.toString(leftRotateArrayByDTimesBetterApproach(anotherArr, 2)));
    }


    private static int[] leftRotateByOne(int[] arr) {

        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;
        return arr;
    }

    /*
        Naive approach. Call leftRotateArrayByOne 'd' times. Time complexity theta(nd)
     */
    private static int[] leftRotateArrayByDTimesNaiveApproach(int[] arr, int d) {
        for (int i = 0; i < d; i++)
            leftRotateByOne(arr);

        return arr;

    }

    /*
        Better approach. Having time complexity of theta(n)
     */
    private static int[] leftRotateArrayByDTimesBetterApproach(int[] arr, int d) {

        int[] temp = new int[d];
        for (int i = 0; i < d; i++)
            temp[i] = arr[i];

        for (int i = d; i < arr.length; i++)
            arr[i - d] = arr[i];

        for (int i = 0; i < d; i++)
            arr[arr.length - d + i] = temp[i];

        return arr;

    }

    private static int[] leftRotateArrayByDTimesUsingReversalAlgorithm(int[] arr, int d) {
        reverseArray(arr, 0, d-1);
        reverseArray(arr, d, arr.length-1);
        reverseArray(arr, 0, arr.length-1);

        return arr;
    }

    private static int[] reverseArray(int[] arr, int low, int high) {

        while (low < high){
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;
            low++;
            high--;
        }

        return arr;
    }

}
