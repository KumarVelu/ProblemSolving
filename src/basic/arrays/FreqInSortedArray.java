package basic.arrays;

/*
    Frequencies in a sorted array.
    I/P : arr : {10, 10, 10, 25, 30, 30}
    O/P : 10 3
          25 1
          30 2

    I/P : arr : {10, 10, 10, 10}
    O/P : 10 4

    I/P : arr : {10, 20, 30}
    O/P : 10 1
          20 1
          30 1

 */
public class FreqInSortedArray {

    public static void main(String[] args) {
        int [] arr = {10, 20, 30, 30};
        printFreq(arr);
    }

    private static void printFreq(int[] arr) {

        int freq = 1, i = 1;
        while (i < arr.length) {
            while (i < arr.length && arr[i] == arr[i - 1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + " " + freq);
            i++;
            freq = 1;
        }
        if (arr.length == 1 || arr[arr.length - 1] != arr[arr.length - 2]) {
            System.out.println(arr[arr.length - 1] + " " + 1);
        }
    }
}
