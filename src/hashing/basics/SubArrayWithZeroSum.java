package hashing.basics;

import java.util.HashSet;

/*
    I/P : arr [] = {1, 4, 13, -3, -10, 5}
    O/P : Yes

    I/P : arr [] = {1, 4, -3, 1, 2}
    O/P : Yes

    I/P : arr [] = {5, 6, 0, 8}
    O/P : Yes

 */
public class SubArrayWithZeroSum {

    public static void main(String[] args) {

        int arr [] = {-1, 3, -2, 8};
        int n = arr.length;

        System.out.println(isSumZero(arr, n));
        System.out.println(isSumZeroNaive(arr, n));
    }


    /*
        arr [] = {1, 4, 13, -3, -10, 5}
        Prefix sum = {1, 5, 18, 15, 5, 10}
     */
    private static boolean isSumZero(int [] arr, int n){

        HashSet<Integer> hashSet = new HashSet<>();

        int prefixSum = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];

            if(hashSet.contains(prefixSum) || hashSet.contains(0))
                return true;

            hashSet.add(prefixSum);
        }

        return false;
    }


    private static boolean isSumZeroNaive(int [] arr, int n){
        System.out.println("Naive approach");

        for (int i = 0; i < n; i++) {

            int currentSum = 0;

            for (int j = i; j < n; j++) {
                currentSum += arr[j];
                if(currentSum == 0) return true;
            }
        }

        return false;
    }
}
