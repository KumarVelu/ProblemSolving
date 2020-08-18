package basic.arrays.problems;

public class StrongestNeighbour {

    public static void main(String[] args) {
        int [] arr = {89, 89, 60};
        maximumAdjacent(3, arr);
    }

    private static void maximumAdjacent(int sizeOfArray, int arr[]){

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sizeOfArray - 1; i++) {
            if(arr[i] < arr[i+1]){
                sb.append(arr[i + 1]).append(" ");
            }else{
                sb.append(arr[i]).append(" ");
            }
        }

        System.out.println(sb.toString());

    }
}
