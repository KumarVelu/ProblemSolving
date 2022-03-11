package basic.arrays;

/*
    IP : {10, 12, 14, 7, 8}
    OP : 3

    IP : {7, 10, 13, 14}
    OP : 4

    IP : 10, 12, 8, 4
    OP : 1
 */
public class LongestEvenOddSubarray {

    public static void main(String[] args) {
        int [] arr = {10, 12, 14, 7, 8};
        System.out.println(maxEvenOddNaive(arr));
        System.out.println("Efficient sol : " + maxEvenOdd(arr));
    }

    private static int maxEvenOddNaive(int [] arr) {
        int res = 1;
        for (int i = 0; i < arr.length; i++) {
            int curr = 1;
            for (int j = i + 1; j < arr.length; j++) {
                if((arr[j] % 2 == 0 && arr[j - 1] % 2 != 0) ||
                        (arr[j] % 2 != 0 && arr[j - 1] % 2 == 0)) {
                    curr++;
                } else {
                    break;
                }
            }
            res = Math.max(res,curr);
        }
        return res;
    }

    private static int maxEvenOdd(int [] arr) {
        int res = 1, curr = 1;
        for (int i = 1; i < arr.length; i++) {

            if ((arr[i] % 2 == 0 && arr[i - 1] % 2 != 0) ||
            (arr[i] % 2 != 0 && arr[i - 1] % 2 == 0)) {
                curr++;
                res = Math.max(res, curr);
            } else {
                curr = 1;
            }
        }
        return res;
    }
}
