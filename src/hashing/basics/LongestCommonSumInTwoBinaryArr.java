package hashing.basics;

import java.util.HashMap;

/*
    I/P arr1 [] = {0, 1, 0, 0, 0, 0}
        arr2 [] = {1, 0, 1, 0, 0, 1}

        o/p : 4

    I/P arr1 [] = {0, 1, 0, 1, 1, 1, 1}
        arr2 [] = {1, 1, 1, 1, 1, 0, 1}

        o/p : 6

    I/P arr1 [] = {0, 0, 0}
        arr2 [] = {1, 1, 1}

        o/p : 0

    I/P arr1 [] = {0, 0, 1, 0}
        arr2 [] = {1, 1, 1, 1}

        o/p : 1
 */
public class LongestCommonSumInTwoBinaryArr {

    public static void main(String[] args) {

        int [] arr1 = {0, 1, 0, 0, 0, 0};
        int [] arr2 = {1, 0, 1, 0, 0, 1};
        int n = arr1.length;

        System.out.println(longestCommonSum(arr1, arr2, n));
        System.out.println(longestCommonSumNaive(arr1, arr2, n));
    }


    private static int longestCommonSum(int[] arr1, int[] arr2, int n)
    {
        // Find difference between the two
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = arr1[i] - arr2[i];

        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<>();

        int sum = 0;	 // Initialize sum of elements
        int max_len = 0; // Initialize result

        // Traverse through the given array
        for (int i = 0; i < n; i++)
        {
            // Add current element to sum
            sum += arr[i];

            // To handle sum=0 at last index
            if (sum == 0)
                max_len = i + 1;

            // If this sum is seen before,
            // then update max_len if required
            if (hM.containsKey(sum))
                max_len = Math.max(max_len, i - hM.get(sum));

            else // Else put this sum in hash table
                hM.put(sum, i);
        }
        return max_len;
    }


    private static int longestCommonSumNaive(int [] arr1, int [] arr2, int n){

        System.out.println("Naive approach");
        int result = 0;
        for (int i = 0; i < n; i++) {

            int firstArrSum = 0, secondArrSum = 0;
            for (int j = i; j < n; j++) {

                firstArrSum += arr1[j];
                secondArrSum += arr2[j];

                if(firstArrSum == secondArrSum){
                    if(result < (j - i + 1)){
                        result = (j - i + 1);
                    }
                }
            }
        }
        return result;
    }
}
