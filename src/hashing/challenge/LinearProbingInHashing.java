package hashing.challenge;

import java.util.Arrays;

public class LinearProbingInHashing {

    public static void main(String[] args) {

        int[] arr = {9, 99, 999, 9999};
        int hashSize = 10;
        System.out.println(Arrays.toString(linearProbing(hashSize, arr, arr.length)));
    }

    private static int[] linearProbing(int hash_size, int[] arr, int N) {
        //Your code here

        int[] hashTable = new int[hash_size];

        for (int i = 0; i < hash_size; i++) {
            hashTable[i] = -1;
        }

        for (int i = 0; i < N; i++) {

            int index = arr[i] % hash_size;
            if (hashTable[index] == -1) {
                hashTable[index] = arr[i];
            } else {

                boolean flag = false;
                int count = 1;
                int probPos = (index + 1) % hash_size;
                while (hashTable[probPos] != -1 || probPos == index) {
                    probPos = (probPos + 1) % hash_size;
                    count++;

                    if(count == hash_size){
                        flag = true;
                        break;
                    }
                }
                if(!flag) hashTable[probPos] = arr[i];
            }
        }

        return hashTable;
    }

}
