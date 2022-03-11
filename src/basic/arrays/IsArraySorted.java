package basic.arrays;

/*
    I/P: {8, 12, 15}
    O/P: Yes

    I/P: {8, 10, 10, 12}
    O/P: Yes

    I/P: {100}
    O/P: Yes

    I/P : {100, 20, 200}
    O/P: No
 */
public class IsArraySorted {

    public static void main(String[] args) {
        int [] arr = {5, 12, 30, 2, 35};
        System.out.println("Is array sorted (Naive approach): " + isArrSortedNaive(arr));
        System.out.println("Is array sorted Efficient solution: " + isArrSorted(arr));
        System.out.println("Is array sorted another efficient solution: " + isArrSortedAnotherApproach(arr));
    }

    private static boolean isArrSortedNaive(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isArrSorted(int [] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] - arr[i] < 0) {
                return false;
            }
        }
        return true;
    }

    private static boolean isArrSortedAnotherApproach(int [] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
