package hashing.challenge;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/*
    Given an array of distinct integers, find all the pairs having both negative
    and positive values of a number in the array.

    Input:
    N = 8
    arr[] = {1,3,6,-2,-1,-3,2,7}
    Output: -1 1 -3 3 -2 2
    Explanation: 1, 3 and 2 are present
    pairwirse postive and negative. 6 and
    7 have no pair.
 */
public class PositiveNegativePair {

    public static void main(String[] args) {

        int [] arr = {1,3,6,-2,-1,-3,2,7};
        System.out.println(findPairs(arr, arr.length));
    }

    public static ArrayList<Integer> findPairs(int arr[], int n)
    {
        // code here.
        ArrayList<Integer> result = new ArrayList<>();
        Set<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < n; i++) {

            if(arr[i] > 0 && hashSet.contains(-arr[i])){
                result.add(-arr[i]);
                result.add(arr[i]);
            }else  if(arr[i] < 0 && hashSet.contains(Math.abs(arr[i]))){
                result.add(arr[i]);
                result.add(-arr[i]);
            }

            hashSet.add(arr[i]);
        }

        if(result.size() == 0) result.add(0);

        return result;
    }

}
