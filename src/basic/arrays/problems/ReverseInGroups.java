package basic.arrays.problems;

import java.util.ArrayList;
import java.util.Arrays;

/*
    Given an array arr[] of positive integers of size N. Reverse every sub-array
    of K group elements.
 */
public class ReverseInGroups {

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>(){{
            add(1);
            add(2);
            add(3);
            add(4);
            add(5);

        }};


        System.out.println(reverseInGroups(al, 5, 3));
    }

    public static ArrayList<Integer> reverseInGroups(ArrayList<Integer> mv, int n, int k) {
        // add your code here

        int startIndex = k - 1;
        int endIndex = 0;
        ArrayList<Integer> resultArrayList = new ArrayList<>();

        while (startIndex < n){

            for (int i = startIndex; i >= endIndex; i--) {
                resultArrayList.add(mv.get(i));
            }

            endIndex = startIndex + 1;
            if(startIndex + k < n) startIndex += k;
            else break;
        }

        if(!(startIndex >= n - 1)){
            for (int i = n-1; i > startIndex; i--) {
                resultArrayList.add(mv.get(i));
            }
        }

        return resultArrayList;

    }

}
