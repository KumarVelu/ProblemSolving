package basic.arrays;

/*
    Given a fixed array and multiple queries of following types on the array, how to efficiently perform queries.
    Ex : arr [] = {2, 8, 3, 9, 6, 5, 4}
    getSum(0, 2) = 13
    getSum(1, 3) = 20
    getSum(2, 6) = 27

 */
public class PrefixSumArrayQueryTheSum {

    public static void main(String[] args) {
        int [] arr = {2, 8, 3, 9, 6, 5, 4};
        System.out.println("Naive sol : " + getSumNaiveSol(arr, 1, 3));
        System.out.println("Efficient sol : " + getSumEfficientSol(arr, 1, 3));
    }

    private static int getSumNaiveSol(int [] arr, int l, int r) {
        int sum = 0;
        for (int i = l; i <= r; i++) {
            sum += arr[i];
        }
        return sum;
    }

    /*
        O(n) to preprocess and after that for any query O(1)
     */
    private static int getSumEfficientSol(int [] arr, int l, int r) {
        int [] prefixSum = new int[arr.length];
        prefixSum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            prefixSum[i] = arr[i] + prefixSum[i - 1];
        }

        if(l != 0) {
            return prefixSum[r] - prefixSum[l - 1];
        } else {
            return prefixSum[r];
        }
    }
}
