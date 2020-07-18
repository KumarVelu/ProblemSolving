package basic.arrays;

// Maximum Difference problem is to find the maximum of arr[j] - arr[i] where j>i.
public class MaxDiffInArr {

    public static void main(String[] args) {

        int [] arr = {2, 3, 10, 6, 4, 8, 1};
        System.out.println(maxDiff(arr)); // 8
    }

    private static int maxDiff(int [] arr){

        int n = arr.length;
        int min = arr[0];
        int res = arr[1] - arr[0];

        for (int j = 1; j < n; j++) {
            res = getMax(res, arr[j] - min);
            min = getMin(min, arr[j]);
        }

        return res;
    }

    private static int getMax(int a, int b){
        if(a > b) return a;
        else return b;
    }

    private static int getMin(int a, int b){
        if(a > b) return b;
        else return a;
    }

}
