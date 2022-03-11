package hashing.challenge;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/*
    Given an array of integers, sort the array according to frequency of elements.
    That is elements that have higher frequency come first.
     If frequencies of two elements are same, then smaller number comes first.

     Input:
    N = 5
    A[] = {5,5,4,6,4}
    Output: 4 4 5 5 6
    Explanation: The highest frequency here is
    2. Both 5 and 4 have that frequency. Now
    since the frequencies are same then
    smallerelement comes first. So 4 4 comes
    firstthen comes 5 5. Finally comes 6.
    The output is 4 4 5 5 6.
 */
public class SortElementsOfArrByFrequency {

    public static void main(String[] args) {

        int[] arr = {5, 5, 4, 6, 4};
        System.out.println(sortByFreq(arr, arr.length));
    }

    private static ArrayList<Integer> sortByFreq(int arr[], int n) {
        // add your code here

        ArrayList<Integer> result = new ArrayList<>();
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0) + 1);
            result.add(arr[i]);
        }

        IntegerComparator comp = new IntegerComparator(hashMap);

        result.sort(comp);

        return result;
    }
}

class IntegerComparator implements Comparator<Integer> {
    private final Map<Integer, Integer> freqMap;

    IntegerComparator(Map<Integer, Integer> tFreqMap) {
        this.freqMap = tFreqMap;
    }

    @Override
    public int compare(Integer o1, Integer o2) {

        int freqCompare = freqMap.get(o2).compareTo(freqMap.get(o1));

        int valueCompare = o1.compareTo(o2);

        if (freqCompare == 0)
            return valueCompare;
        else
            return freqCompare;
    }
}
