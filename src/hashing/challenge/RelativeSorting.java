package hashing.challenge;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class RelativeSorting {

    public static void main(String[] args) {

        int[] A1 = {2,1,2,5,7,1,9,3,6,8,8};
        int[] A2 = {99,22,444,56};

        sortA1ByA2(A1, A1.length, A2, A2.length);
    }

    private static void sortA1ByA2(int A1[], int N, int A2[], int M)
    {
        //Your code here

        Map<Integer, Integer> freqMap = new TreeMap<>();

        for (int i = 0; i < N; i++) {
            freqMap.put(A1[i], freqMap.getOrDefault(A1[i], 0) + 1);
        }

        int count = 0;
        for (int i = 0; i < M; i++) {

            int freq = freqMap.getOrDefault(A2[i], 0);

            if(freq == 0) continue;;

            int lastIndex = count + freq;

            for (int j = count; j < lastIndex; j++) {
                A1[j] = A2[i];
                count++;
            }

            freqMap.remove(A2[i]);
        }

        for(Map.Entry<Integer, Integer> entrySet : freqMap.entrySet()){

            int freq = entrySet.getValue();
            int lastIndex = freq + count;
            for (int i = count; i < lastIndex; i++) {
                A1[i] = entrySet.getKey();
                count++;
            }

        }

        System.out.println(Arrays.toString(A1));
    }
}
