package hashing.challenge;

import java.util.HashMap;

/*
    You are given an array A[] of size N.
    Find the total count of sub-arrays having their sum equal to 0.

    Input:
    N = 6
    A[] = {0,0,5,5,0,0}
    Output: 6
    Explanation: The 6 subarrays are
    [0], [0], [0], [0], [0,0], and [0,0].

    Input:
    N = 10
    A[] = {6,-1,-3,4,-2,2,4,6,-12,-7}
    Output: 4
    Explanation: The 4 subarrays are [-1 -3 4]
    [-2 2], [2 4 6 -12], and [-1 -3 4 -2 2]
 */
public class ZeroSumSubArray {

    public static void main(String[] args) {

        int [] arr = {0,0,5,5,0,0};
        System.out.println(findSubarray(arr, arr.length));
    }

    private static int findSubarray(int[] arr ,int n)
    {
        //Your code here
        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;

            if (prefixSum == 0)
                result++;

            if (hm.containsKey(prefixSum))
                result += hm.get(prefixSum );

            if (hm.containsKey(prefixSum))
                hm.put(prefixSum, hm.get(prefixSum) + 1);
            else
                hm.put(prefixSum, 1);
        }
        return result;
    }
}
