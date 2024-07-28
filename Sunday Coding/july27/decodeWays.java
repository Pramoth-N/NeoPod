/*
 Given an encoded string containing digits, determine the total number of ways to decode it. 
 The encoding is based on the mapping 'a' -< '1', 'יפ -> '2',..., '2'> '26' 
 Input Format 
 •The input consists of a string a representing the encoded string. 
 Output Format The output must be a single integer representing the number of ways to decode the string. 
 Print Invalid input, If the value is negative.
 */

import java.util.*;

public class DecodeWays {
    
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        if (input.startsWith("-")) {
            System.out.println("Invalid input");
            return;
        }
        
        int result = numDecodings(input);
        if (result == -1) {
            System.out.println("Invalid input");
        } else {
            System.out.println(result);
            List<String> combinations = decodeCombinations(input);
            for (String combination : combinations) {
                System.out.println(combination);
            }
        }
    }
    
    public static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return -1;
        }
        
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        
        for (int i = 1; i <= n; i++) {
            if (s.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
            }
            
            if (i > 1 && s.charAt(i - 2) != '0') {
                int twoDigit = Integer.parseInt(s.substring(i - 2, i));
                if (twoDigit >= 10 && twoDigit <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        
        return dp[n];
    }
    
    public static List<String> decodeCombinations(String s) {
        List<String> result = new ArrayList<>();
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return result;
        }
        decodeHelper(s, 0, "", result);
        return result;
    }
    
    private static void decodeHelper(String s, int index, String current, List<String> result) {
        if (index == s.length()) {
            result.add(current);
            return;
        }
        
        if (s.charAt(index) == '0') {
            return;
        }
        
        int oneDigit = Integer.parseInt(s.substring(index, index + 1));
        decodeHelper(s, index + 1, current + (char) ('A' + oneDigit - 1), result);
        
        if (index + 1 < s.length()) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits >= 10 && twoDigits <= 26) {
                decodeHelper(s, index + 2, current + (char) ('A' + twoDigits - 1), result);
            }
        }
    }
}
