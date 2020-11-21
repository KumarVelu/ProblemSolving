package hashing.basics;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/*
    I/P : [] arr = {30, 10, 20, 20, 10, 20, 30, 30}
          n = 8, k = 4
     O/P : 20 30

    I/P : [] arr = {30, 10, 20, 30, 30, 40, 30, 40, 30}
          n = 9, k = 2
     O/P : 30
 */
public class MoreThanNByKOccurence {

    public static void main(String[] args) {

        int [] arr = {30, 10, 20, 20, 10, 20, 30, 30};
        int n = arr.length, k = 4;

        printNByK(arr, n, k);
        printNByKNaive(arr, n, k);
    }

    private static void printNByK(int [] arr, int n, int k){

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int x : arr) {
            hashMap.put(x, hashMap.getOrDefault(x, 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : hashMap.entrySet()){
            if(entry.getValue() > n/k){
                System.out.print(entry.getKey() + " ");
            }
        }
    }

    private static void printNByKNaive(int [] arr, int n, int k){

        System.out.println("Naive approach");

        Arrays.sort(arr);
        int i = 1, count = 1;

        while (i < n){

            while (i < n && arr[i] == arr[i - 1]){
                count++;
                i++;
            }

            if(count > n/k){
                System.out.print(arr[i - 1] + " ");
            }

            count = 1;
            i++;
        }
    }
}
