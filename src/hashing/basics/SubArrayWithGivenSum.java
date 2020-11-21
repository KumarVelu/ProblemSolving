package hashing.basics;


import java.util.HashSet;

/*
    I/P : arr [] = {5, 8, 6, 13, 3, -1}
    sum = 22
    O/P : Yes

    I/P : arr [] = {15, 12, 8, 10, -5, -8, 6}
    sum = 3
    O/P : Yes

    I/P : arr [] = {3, 2, 5, 6}
    sum = 10
    O/P : Yes

 */
public class SubArrayWithGivenSum {

    public static void main(String[] args) {
        int arr [] = {5, 8, 6, 13, 3, -1};
        int sum = 22, n = arr.length;

        System.out.println(isSumAvailable(arr, n, sum));
        System.out.println(isSumAvailableNaive(arr, n, sum));
    }


    /*
        arr [] = {5, 8, 6, 13, 3, -1};
        pre_sum = {5, 13, 19, 32, 35, 34}

     */
    private static boolean isSumAvailable(int [] arr, int n, int sum){

        HashSet<Integer> hashSet = new HashSet<>();
        int preSum = 0;
        for (int i = 0; i < n; i++) {
            preSum += arr[i];
            if(hashSet.contains(preSum - sum) || (preSum == sum)) return true;

            hashSet.add(preSum);
        }

        return false;
    }

    private static boolean isSumAvailableNaive(int [] arr, int n, int sum){
        System.out.println("Naive approach");

        for (int i = 0; i < n; i++) {
            int currentSum = 0;
            for (int j = i; j < n; j++) {
                currentSum += arr[j];

                if(currentSum == sum) return true;
            }
        }

        return false;
    }
}
