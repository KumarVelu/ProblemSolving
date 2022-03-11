package basic.arrays;

/*
    Find count of maximum consecutive 1s in a binary array.
    I/P
    O/P

    1. {0, 1, 1, 0, 1, 0}
       O/P : 2

    2. {1, 1, 1, 1}
       O/P : 4

 */
public class MaxConsecutiveOnesInBinaryArray {

    public static void main(String[] args) {
        int [] arr = {0, 1, 1, 0, 1, 0};
        System.out.println(getMaxConsecutiveOnesNaiveSol(arr));
        System.out.println("MaxConsecutiveOnesInBinaryArray eff sol : " + getMaxConsecutiveOnesEfficientSol(arr));
    }

    private static int getMaxConsecutiveOnesNaiveSol(int [] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            int currCount = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] == 1) currCount++;
                else break;
            }
            res = Math.max(res, currCount);
        }
        return res;
    }

    private static int getMaxConsecutiveOnesEfficientSol(int [] arr) {
        int res = 0, currCount = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                currCount = 0;
            } else {
                currCount++;
                res = Math.max(res, currCount);
            }
        }
        return res;
    }
}
