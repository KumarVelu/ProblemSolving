package hashing.basics;


/*
    Intersection of two arrays.
    I/P : a[] = {10, 15, 20, 15, 30, 30, 5}
          b[] = {30, 5, 30, 80}

    O/P : 2

    I/P : a[] = {10, 10, 10}
          b[] = {10, 10, 10}

    O/P : 1
 */

import java.util.HashSet;

public class IntersectionOfTwoArrays {

    public static void main(String[] args) {
        int a[] = {10, 15, 20, 15, 30, 30, 5};
        int b[] = {30, 5, 30, 80};
        int m = a.length;
        int n = b.length;

        System.out.println(getIntersectionOfTwoArrays(a, b, m, n));
        System.out.println(getIntersectionOfTwoArraysNaive(a, b, m, n));
    }

    /*
        O(m + n) Time
        O(m) Aux space
     */
    static int getIntersectionOfTwoArrays(int a[], int b[], int m, int n){

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < m; i++) {
            hashSet.add(a[i]);
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            if(hashSet.contains(b[i])){
                result++;
                hashSet.remove(b[i]);     // note this
            }
        }

        return result;
    }

    // O(m * (m + n))
    static int getIntersectionOfTwoArraysNaive(int a[], int b[], int m, int n){

        System.out.println("Naive approach");

        int result = 0;
        for (int i = 0; i < m; i++) {

            boolean flag = false;
            for (int j = i-1; j >= 0; j--) {
                if(a[i] == a[j]){
                    flag = true;
                    break;
                }
            }

            if(flag) continue;

            for (int j = 0; j < n; j++) {
                if(a[i] == b[j]){
                    result++;
                    break;
                }
            }
        }

        return result;
    }
}
