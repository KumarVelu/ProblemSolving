package hashing.contest;

import java.util.Arrays;
import java.util.Scanner;

public class SumOfFirstKSmallestNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){

            int n, k;

            n = sc.nextInt();
            k = sc.nextInt();

            int [] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(findSum(arr, arr.length, k));
        }
    }

    private static int findSum(int [] arr, int n, int k){

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
