package hashing.contest;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class XORPair {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while(t-- > 0){

            int n, c;

            n = sc.nextInt();
            c = sc.nextInt();

            int [] arr = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            System.out.println(isXORPair(arr, arr.length, c));
        }
    }

    private static String isXORPair(int [] arr, int n, int sum){

        Set<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if(hashSet.contains(sum - arr[i])) return "Yes";
            hashSet.add(arr[i]);
        }
        return "No";
    }
}
