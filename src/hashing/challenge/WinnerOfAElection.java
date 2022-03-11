package hashing.challenge;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/*
    Given an array of names (consisting of lowercase characters) of candidates in an election.
    A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes.
    If there is tie, print lexicographically smaller name.
 */
public class WinnerOfAElection {

    public static void main(String[] args) {

        String [] votes = {"john","johnny", "jackie", "johnny", "john", "jackie", "jamie",
                "jamie", "john", "johnny", "jamie",
                "johnny", "john"};

        System.out.println(Arrays.toString(winner(votes, votes.length)));
    }

    private static String[] winner(String[] arr, int n) {
        // add your code

        Map<String, Integer> treeMap = new TreeMap<>();
        int maxVotes = 0;
        String winner = null;
        String [] result = new String[2];

        for(String name : arr){
            treeMap.put(name, treeMap.getOrDefault(name, 0) + 1);
        }

        for (Map.Entry<String, Integer> entrySet : treeMap.entrySet()){
            if(maxVotes < entrySet.getValue()){
                maxVotes = entrySet.getValue();
                winner = entrySet.getKey();
            }
        }

        result[0] = winner;
        result[1] = String.valueOf(maxVotes);

        return result;
    }
}
