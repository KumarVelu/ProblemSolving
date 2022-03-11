package hashing.contest;

import java.util.Arrays;
import java.util.Scanner;

public class KthSmallestDifference {

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

            System.out.println(findKthSmallestDiff(arr, arr.length, k));
        }
    }

    private static int findKthSmallestDiff(int [] arr, int n, int k){

        Arrays.sort(arr);
        int [] diffArr = new int[n - 1];

        for (int i = 0; i < n - 1; i++) {
            diffArr[i] = Math.abs(arr[i + 1] - arr[i]);
        }

        Arrays.sort(diffArr);

        return diffArr[k - 1];
    }

}
