package hashing.challenge;

import java.util.HashMap;
import java.util.Map;

public class SubArrayWithEqual0And1 {

    public static void main(String[] args) {

        int [] arr = {1,0,0,1,0,1,1};
        System.out.println(countSubarrWithEqualZeroAndOne(arr, arr.length));

    }

    private static int countSubarrWithEqualZeroAndOne(int[] arr, int N)
    {
        Map<Integer, Integer> hm = new HashMap<>();
        int sum = 0, count = 0;
        for (int i = 0; i < N; i++)
            arr[i] = (arr[i] == 0) ? -1 : 1;

        for (int i = 0; i < N; i++) {
            sum += arr[i];
            if (sum == 0) count++;

            if (hm.containsKey(sum)) {

                count += hm.get(sum);

                hm.put(sum, hm.get(sum) + 1);

            } else hm.put(sum, 1);
        }
        return count;
    }
}
