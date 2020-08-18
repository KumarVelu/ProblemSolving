package basic.arrays.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxAndSecondMaxInArr {

    public static void main(String[] args) {
        int [] arr = {1000, 1000, 1000, 1000, 100};
        System.out.println(largestAndSecondLargest(5, arr));
    }

    public static ArrayList<Integer> largestAndSecondLargest(int sizeOfArray, int arr[])
    {
        //code here.
        int max, secondMax;
        max = secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < sizeOfArray; i++) {
            if(arr[i] > max){
                secondMax = max;
                max = arr[i];
            }else if(arr[i] > secondMax && arr[i] < max){
                secondMax = arr[i];
            }
        }

        int finalMax = max;
        int finalSecondMax = (secondMax == Integer.MIN_VALUE ? -1 : secondMax);
        return new ArrayList<>(){{
            add(finalMax);
            add(finalSecondMax);
        }};
    }
}
