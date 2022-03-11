package hashing.challenge;

import java.util.ArrayList;

/*
    Separate chaining technique in hashing allows to us to use a linked list at each hash slot to handle the problem of collisions.
     That is, every slot of the hash table is a linked list, so whenever a collision occurs,
     the element can be appened as a node to the linked list at the slot.

    In this question, we'll learn how to fill up the hash table using Separate chaining technique.
    Given an array and a hashtable size, you have to fill the elements of the array into a hash table of given size.

    Input:
    hashSize = 10
    sizeOfArray = 6
    arr[] = {92,4,14,24,44,91}
    Output:
    1->91
    2->92
    4->4->14->24->44
    Explanation: 92%10=2 so 92 goes to slot 2.
    4%10=4 so 4 goes to slot 4. 14%10=4. But 4
    is already occupied so we make a linked
    list at this position and add 14 after 4
    in slot 4 and so on.
 */
public class SeparateChainingInHashing {

    public static void main(String[] args) {

        int hashSize = 10;
        int sizeOfArray = 6;
        int [] arr = {92,4,14,24,44,91};

        System.out.println(separateChaining(arr, sizeOfArray, hashSize));
    }


    public static ArrayList<ArrayList<Integer>> separateChaining(int[] arr, int n, int hashSize)
    {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>(hashSize);

        for (int i = 0; i < hashSize; i++) {
            result.add(i, new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int index = arr[i] % hashSize;
            result.get(index).add(arr[i]);
        }

        return result;
    }
}
