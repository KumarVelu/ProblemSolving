package basic.arrays;

/*
    I/P : {8, 5, 0, 10, 0, 20}
    O/P : {8, 5, 10, 20, 0, 0}

    I/P : {0, 0, 0, 10, 0}
    O/P : {10, 0, 0, 0, 0}

    I/P : {10, 20}
    O/P : {10, 20}
 */
public class MoveZerosToEnd {

    public static void main(String[] args) {
        int [] arr = {8, 5, 0, 10, 0, 20};
        moveToEnd(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    private static void moveToEndNaive(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                for (int j = i + 1; j < arr.length; j++) {
                    if (arr[j] != 0) {
                        int temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                        break;
                    }
                }
            }
        }
    }

    private static void moveToEnd(int [] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
    }
}
