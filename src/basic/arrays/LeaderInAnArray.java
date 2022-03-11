package basic.arrays;

// An element is called the leader of an array if there is no element greater than it on the right side.
/*
    I/P : arr [] = {7, 10, 4, 10, 6, 5, 2};
    O/P : {10, 6, 5, 2}

    I/P : arr [] = {10, 20, 30}
    O/P : 30

    I/P : arr [] = {30, 20, 10}
    O/P : 30, 20, 10
 */
public class LeaderInAnArray {

    public static void main(String[] args) {
        int[] arr = {7, 10, 4, 10, 6, 5, 2};
        printLeaderInAnArray(arr);

        printLeaderInAnArrayEffSol(arr);
    }

    private static void printLeaderInAnArray(int[] arr){

        for (int i = 0; i < arr.length; i++) {

            boolean flag = false;
            for (int j = i+1; j < arr.length; j++) {

                if(arr[j] >= arr[i]){
                    flag = true;
                    break;
                }
            }

            if(!flag)
                System.out.print(arr[i] + " ");

        }

    }

    // Efficient solution, but prints in reverse order
    private static void printLeaderInAnArrayEffSol(int[] arr){

        System.out.println();
        int n = arr.length;
        int currLeader = arr[n - 1];
        System.out.print(currLeader + " ");

        for (int i = n-2; i >= 0; i--) {

            if(arr[i] > currLeader){
                currLeader = arr[i];
                System.out.print(currLeader + " ");
            }

        }

    }

}
