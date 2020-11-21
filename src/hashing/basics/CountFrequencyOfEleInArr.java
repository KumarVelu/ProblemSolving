package hashing.basics;

import java.util.HashMap;
import java.util.Map;

public class CountFrequencyOfEleInArr {

    public static void main (String[] args) {
        int arr[] = new int[]{15, 16, 27, 27, 28, 15};
        int n = arr.length;

        countFreq(arr, n);
        countFreqNaive(arr, n);
    }

    static void countFreq(int arr[], int n)
    {
        Map<Integer, Integer> hmp = new HashMap<Integer, Integer>(); // Used LinedHashMap if you want to maintain the order of insertion.
        for(int i = 0; i < n; i++)
        {
            if(hmp.containsKey(arr[i]))
                hmp.put(arr[i], hmp.get(arr[i]) + 1);
            else
                hmp.put(arr[i], 1);
        }

        for(Map.Entry<Integer, Integer> itr: hmp.entrySet())
            System.out.println(itr.getKey() + " " + itr.getValue());
    }

    static void countFreqNaive(int arr[], int n){

        System.out.println("Naive approach");

        for (int i = 0; i < n; i++) {

            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            int freqCount = 1;
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]) freqCount++;
            }

            System.out.println(arr[i] + " " + freqCount);
        }

    }






}
