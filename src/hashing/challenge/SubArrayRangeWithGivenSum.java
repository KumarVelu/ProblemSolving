package hashing.challenge;

import java.util.HashMap;

public class SubArrayRangeWithGivenSum {

    public static void main(String[] args) {
        int[] arr = {10, 2, -2, -20, 10};
        int sum = -10, n = arr.length;

        System.out.println(subArraySum(arr, n, sum));
    }

    static int subArraySum(int[] arr, int n, int sum) {
        // add your code here

        int result = 0;
        HashMap<Integer, Integer> hm = new HashMap();
        int prefixSum = 0;
        for (int num : arr) {
            prefixSum += num;

            if (prefixSum == sum)
                result++;

            if (hm.containsKey(prefixSum - sum))
                result += hm.get(prefixSum - sum);

            if (hm.containsKey(prefixSum))
                hm.put(prefixSum, hm.get(prefixSum) + 1);
            else
                hm.put(prefixSum, 1);
        }
        return result;
    }
}
