package hashing.challenge;

import java.util.HashMap;

public class NumbersContainingOneTwoAndThree {

    static HashMap<Integer,Integer> mp=new HashMap<>();


    public static boolean containsOtherThan123(int number){

        String numberStr = String.valueOf(number);
        if(numberStr.contains("4") || numberStr.contains("5") || numberStr.contains("6") || numberStr.contains("7")
            || numberStr.contains("8") || numberStr.contains("9") || numberStr.contains("0")){
            return true;
        }

        return false;

    }

    public static void findAll()
    {
        //Your code here
        for (int i = 0; i < 1000000; i++) {

            if(!containsOtherThan123(i)){
                mp.put(i, 1);
            }

        }
    }
}
