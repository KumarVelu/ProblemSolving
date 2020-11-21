package hashing.basics;


import java.util.HashMap;
import java.util.Map;

/*
    I/p : arr = {10, 20, 20, 10, 30, 40, 10}
                k = 4
    O/P : 2 3 4 3

    I/p : arr = {10, 10, 10, 10}
                k = 3
    O/P : 1 1

    I/p : arr = {10, 20, 30, 40}
                k = 3
    O/P : 3 3
 */
public class CountDistinctElementsInEveryWindow {

    public static void main(String[] args) {

        int [] arr = {10, 20, 20, 10, 30, 40, 10};
        int n = arr.length, k = 4;

        printDistinctWind(arr, n, k);
        printDistinctWindNaive(arr, n, k);
    }

    // todo : revisit the logic
    private static void printDistinctWind(int [] arr, int n, int k){

        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < k; i++) {
            if(freqMap.containsKey(arr[i])){
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }else{
                freqMap.put(arr[i], 1);
            }
        }

        System.out.print(freqMap.size() + " ");

        for (int i = k; i < n; i++) {

            freqMap.put(arr[i - k], freqMap.get(arr[i - k]) - 1);

            if(freqMap.get(arr[i - k]) == 0) freqMap.remove(arr[i - k]);

            if(freqMap.containsKey(arr[i])){
                freqMap.put(arr[i], freqMap.get(arr[i]) + 1);
            }else{
                freqMap.put(arr[i], 1);
            }

            System.out.print(freqMap.size() + " ");
        }

    }

    private static void printDistinctWindNaive(int [] arr, int n, int k){

        System.out.println("\n Naive approach");

        for (int i = 0; i <= (n - k); i++) {

            int currentMax = 0;

            for (int j = i; j < (i + k); j++) {

                boolean flag = false;

                for (int l = j-1; l >= i; l--) {

                    if(arr[l] == arr[j]){
                        flag = true;
                        break;
                    }
                }

                if(!flag) currentMax++;
            }

            System.out.print(" " + currentMax);
        }
    }
}
