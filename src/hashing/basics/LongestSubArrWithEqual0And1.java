package hashing.basics;

import java.util.HashMap;
import java.util.Map;

/*

    I/P : arr [] = {1, 0, 1, 1, 1, 0, 0}
    O/P : 6

    I/P : arr [] = {1, 1, 1, 1}
    O/P : 0

    I/P : arr [] = {0, 0, 1, 1, 1, 1, 0}
    O/P : 4
 */
public class LongestSubArrWithEqual0And1 {

    public static void main(String[] args) {

        int[] arr = {0, 0, 1, 1, 1, 1, 0};
        int n = arr.length;

        System.out.println(getArrSizeNaive(arr, n));

        System.out.println(largestZeroSubarray(arr, n));
    }

    private static int largestZeroSubarray(int arr[], int n) {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0, maxLen = 0;
        for (int i = 0; i < n; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
            if (sum == 0) maxLen = i + 1;

            if (hm.containsKey(sum)) {
                if (maxLen < i - hm.get(sum))
                    maxLen = i - hm.get(sum);

            } else hm.put(sum, i);
        }
        return maxLen;
    }

    private static int getArrSizeNaive(int[] arr, int n) {

        System.out.println("Naive approach");
        int result = 0;
        for (int i = 0; i < n; i++) {

            int noOfZeros = 0, noOfOnes = 0;
            for (int j = i; j < n; j++) {
                if (arr[j] == 0) noOfZeros++;
                else noOfOnes++;

                if (noOfZeros == noOfOnes) {
                    if (result < (j - i + 1)) result = (j - i + 1);
                }
            }
        }

        return result;
    }
}
