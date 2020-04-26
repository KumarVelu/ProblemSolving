package basic.arrays;

import java.util.Arrays;

public class LeftRotateArrayByOne {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 1, 8};

        System.out.println(Arrays.toString(leftRotateByOne(arr)));
    }

    private static int[] leftRotateByOne(int[] arr) {

        int temp = arr[0];
        for (int i = 1; i < arr.length; i++) {
            arr[i - 1] = arr[i];
        }

        arr[arr.length - 1] = temp;
        return arr;
    }

}
