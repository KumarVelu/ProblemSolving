package basic.arrays.problems;

public class InsertAtIndex {

    public static void main(String[] args) {
        int [] arr = {32, 28, 33, 39, 3, 45, 35};
        insertAtIndex(arr, 7, 0, 30);
    }

    private static void insertAtIndex(int arr[],int sizeOfArray,int index,int element)
    {
        int [] modifiedArr = new int[arr.length + 1];

        for (int i = 0; i < index; i++) {
            modifiedArr[i] = arr[i];
        }

        modifiedArr[index] = element;

        for (int i = index + 1; i <= arr.length; i++) {
            modifiedArr[i] = arr[i - 1];
        }

        for (int i = 0; i < modifiedArr.length; i++) {
            System.out.print(modifiedArr[i] + " ");
        }
    }

}
