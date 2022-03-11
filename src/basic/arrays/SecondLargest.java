package basic.arrays;

/*
    I/P : {10, 5, 8, 20}
    O/P : 0 // index of 10

    I/P : {20, 10, 20, 8, 12}
    O/P : 4 // index of 12

    I/P : {10, 10, 10}
    O/P : -1 // no second largest
 */
public class SecondLargest {

    public static void main(String[] args) {
        int[] arr = {10, 10, 10};
        System.out.println(secondLargest(arr));
    }

    private static int secondLargest(int[] arr) {

        int res = -1, largest = 0;
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] != arr[largest]) {
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }
        return res;
    }
}
