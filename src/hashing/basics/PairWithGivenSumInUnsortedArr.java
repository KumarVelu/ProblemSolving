package hashing.basics;

import java.util.HashSet;

/*
     I/P : {3, 2, 8, 15, -8}
     Sum = 17,
     O/P : Yes

     {11, 5, 6}
     Sum = 10
     O/P : No
 */
public class PairWithGivenSumInUnsortedArr {

    public static void main(String[] args) {

        int [] arr = {3, 2, 8, 15, -8};
        int n = arr.length;
        int sum = 17;

        System.out.println(isPair(arr, n, sum));
        System.out.println(isPairNaive(arr, n, sum));
    }


    private static boolean isPair(int [] arr, int n, int sum){

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(hashSet.contains(sum - arr[i]))
                return true;
            hashSet.add(arr[i]);
        }
        return false;
    }

    // O(n * n)
    private static boolean isPairNaive(int [] arr, int n, int sum){
        System.out.println("Naive approach");
        for (int i = 0; i < n; i++) {

            for (int j = i+1; j < n; j++) {
                if(arr[i] + arr[j] == sum) return true;
            }
        }
        return false;
    }


}
