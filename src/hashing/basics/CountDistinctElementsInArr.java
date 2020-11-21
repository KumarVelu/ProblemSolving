package hashing.basics;

import java.util.HashSet;
import java.util.Set;

public class CountDistinctElementsInArr {

    public static void main (String[] args) {
        int arr[] = new int[]{15, 16, 27, 27, 28, 15};
        int n = arr.length;

        System.out.println(countDistinct(arr, n));

        System.out.println(countDistinctNaive(arr, n));
    }

    static int countDistinct(int arr[], int n)
    {
        Set<Integer> hs = new HashSet<Integer>();
        for(int i = 0; i < n; i++) hs.add(arr[i]);

        return hs.size();
    }

    static int countDistinctNaive(int arr[], int n){

        int result = 0;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if(arr[i] == arr[j]){
                    flag = true;
                    break;
                }
            }
            if(!flag) result++;
        }

        return result;
    }
}
