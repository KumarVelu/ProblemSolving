package hashing.basics;

import java.util.HashMap;

/*
    I/P : arr [] = {5, 8, -4, -4, 9, -2, 2}
    sum = 0
    O/P : 3

    I/P : arr [] = {3, 1, 0, 1, 8, 2, 3, 6}
    sum = 5
    O/P : 4

    I/P : arr [] = {8, 3, 7}
    sum = 15
    O/P : 0

 */
public class LongestSubArrWithGivenSum {

    public static void main(String[] args) {
        int arr[] = {3, 1, 0, 1, 8, 2, 3, 6};
        int n = arr.length, sum = 5;

        System.out.println(getLongestSubArrForGivenSum(arr, n, sum));
        System.out.println(getLongestSubArrForGivenSumNaive(arr, n, sum));
    }

    private static int getLongestSubArrForGivenSum(int[] arr, int n, int sum) {

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int preSum = 0, result = 0;

        for (int i = 0; i < n; i++) {

            preSum += arr[i];

            if(preSum == sum) result = i + 1;

            if(!hashMap.containsKey(preSum)){
                hashMap.put(preSum, i);
            }

            if(hashMap.containsKey(preSum - sum)){
                if(i - hashMap.get(preSum - sum) > result){
                    result = i - hashMap.get(preSum - sum);
                }
            }
        }

        return result;
    }


    private static int getLongestSubArrForGivenSumNaive(int[] arr, int n, int sum) {

        System.out.println("Naive approach");
        int longestArrSize = 0;
        for (int i = 0; i < n; i++) {

            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];

                if (currentSum == sum) {
                    if (longestArrSize < (j - i + 1)) {
                        longestArrSize = (j - i + 1);
                    }
                }
            }
        }
        return longestArrSize;
    }
}
