package hashing.challenge;

import java.util.HashMap;
import java.util.Map;

/*
    Given two arrays A and B of equal size N, the task is to find if given arrays are equal or not.
     Two arrays are said to be equal if both of them contain same set of elements, arrangements (or permutation)
     of elements may be different though.
    Note : If there are repetitions, then counts of repeated elements must also be same for two array to be equal.

    Input:
    N = 5
    A[] = {1,2,5,4,0}
    B[] = {2,4,5,0,1}
    Output: true
 */
public class CheckIf2ArraysAreEqualOrNot {

    public static void main(String[] args) {

        long[] A = {1,2,5,4,6};
        long[] B = {2,4,5,0,1};
        System.out.println(check(A, B, A.length));
    }

    public static boolean check(long arr[],long brr[],int n)
    {
        Map<Long, Integer> arrHashMap = new HashMap<>();
        Map<Long, Integer> brrHashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            arrHashMap.put(arr[i], arrHashMap.getOrDefault(arr[i], 0) + 1);
            brrHashMap.put(brr[i], brrHashMap.getOrDefault(brr[i], 0) + 1);
        }

        for(Map.Entry<Long, Integer> entrySet : arrHashMap.entrySet()){
            if(arrHashMap.get(entrySet.getKey()) != brrHashMap.get(entrySet.getKey())){
                return false;
            }
        }

        return true;
    }
}
