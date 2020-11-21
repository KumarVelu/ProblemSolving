package hashing.basics;

import java.util.HashSet;

/*
    Union of two unsorted arrays.
    I/P : a[] = {15, 20, 5, 15}
          b[] = {15, 15, 15, 20, 10}
    O/P : 4

    I/P : a[] = {10, 12, 15}
          b[] = {18, 12}
    O/P : 4

    I/P : a[] = {10, 10, 10}
          b[] = {10, 10}
    O/P : 1
 */
public class UnionOfTwoUnsortedArray {

    public static void main(String[] args) {
        int a[] = {15, 20, 5, 15};
        int b[] = {15, 15, 15, 20, 10};
        int m = a.length;
        int n = b.length;

        System.out.println("Union of two unsorted arrays");
        System.out.println(findUnion(a, b, m, n));
        System.out.println(findUnionNaive(a, b, m, n));
    }

    /*
        O(m+n) Time
        O(m+n) Aux space
     */
    private static int findUnion(int[] a, int[] b, int m, int n) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            hashSet.add(a[i]);
        }

        for (int i = 0; i < n; i++) {
            hashSet.add(b[i]);
        }

        return hashSet.size();
    }


    /*
        O((m+n) * (m+n)) Time
        O(m+n) Aux space
     */
    private static int findUnionNaive(int[] a, int[] b, int m, int n) {

        System.out.println("Naive approach");

        int[] c = new int[m + n];

        for (int i = 0; i < m; i++) c[i] = a[i];
        for (int i = 0; i < n; i++) c[i + m] = b[i];

        int result = 0;
        for (int i = 0; i < c.length; i++) {

            boolean flag = false;
            for (int j = i - 1; j >= 0; j--) {
                if (c[i] == c[j]) {
                    flag = true;
                    break;
                }
            }

            if (!flag) result++;

        }

        return result;
    }
}
