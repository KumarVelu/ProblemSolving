package hashing.basics;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
    I/P : arr[] = {1, 9, 3, 4, 2, 20}
          o/p: 4

    I/P : arr[] = {8, 20, 7, 30}
          o/p: 2

    I/P : arr[] = {10, 20, 30}
          o/p: 1
 */
public class LongestConsecutiveSubsequence {


    public static void main(String[] args) {

        int [] arr = {1, 9, 3, 4, 2, 20};
        int n = arr.length;

        System.out.println(findLongestConsecutive(arr, n));
        System.out.println(findLongestConsecutiveNaive(arr, n));
    }

    private static int findLongestConsecutive(int [] arr, int n){

        int result = 0;
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            hashSet.add(arr[i]);
        }

        for (int i = 0; i < n; i++) {

            if(hashSet.contains(arr[i] - 1)) continue;

            int currentMax = 1;
            while (hashSet.contains(arr[i] + currentMax)){
                currentMax++;
            }

            if(result < currentMax) result = currentMax;
        }

        return result;

    }

    private static int findLongestConsecutiveNaive(int [] arr, int n){

        System.out.println("Naive approach");
        Arrays.sort(arr);
        int result = 1, currentMax = 1;

        for (int i = 1; i < n; i++) {
            if(arr[i] == arr[i - 1] + 1){
                currentMax++;
            }else{
                if(result < currentMax){
                    result = currentMax;
                    currentMax = 1;
                }
            }
        }

        if(result < currentMax){
            result = currentMax;
        }

        return result;
    }
}
