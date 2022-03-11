package basic.arrays;

/*
    Given an array of integers, find if it has an equilibrium point.
    arr [] = {3, 4, 8, -9, 20, 6}
    O/P: Yes (Point 20, sum of elements of lef of its side is equal to sum of elements on right of it = 6)

    {4, 2, -2}
    Yes // Point, 4, sum = 0

    {4, 2, 2}
    No
 */
public class PrefixSumArrayFindEquilibriumPoint {


    public static void main(String[] args) {
        int [] arr = {3, 4, 8, -9, 20, 6};
        System.out.println("Naive sol : " + isEquilibriumPointNaiveSol(arr));
    }

    private static boolean isEquilibriumPointNaiveSol(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            int lSum = 0, rSum = 0;
            for (int j = 0; j < i; j++) {
                lSum += arr[j];
            }
            for (int j = i +1; j < arr.length; j++) {
                rSum += arr[j];
            }
            if(lSum == rSum) return true;
        }
        return false;
    }
}
