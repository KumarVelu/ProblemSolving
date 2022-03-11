package hashing.challenge;

import java.util.HashMap;
import java.util.Map;

public class FirstRepeatingElement {

    public static void main(String[] args) {

        int [] a = {1, 2, 3, 4};
        System.out.println(firstRepeated(a, a.length));
    }

    private static int firstRepeated(int []arr, int n)
    {
        Map<Integer, Integer> hashMap = new HashMap<>();
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if(!hashMap.containsKey(arr[i])){
                hashMap.put(arr[i], i);
            }else{
                if(result > hashMap.get(arr[i])){
                    result = hashMap.get(arr[i]) + 1;
                }
            }
        }

        return (result == Integer.MAX_VALUE) ? -1 : result;
    }
}
