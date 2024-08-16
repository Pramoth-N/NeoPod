/*
 * 
 * Given a string str and an integer , 
 * implement a function to find the length of the longest substring that contains at most a distinct characters. 
 * Input Format 
 *      • The Input consists of a single string. 
 *      • The next line contains an integer k, representing the maximum number of distinct characters allowed in the substring.
 *  Output Format 
 *      Output the length of the longest substring with at most k distinct characters. 
 *      If all the characters are the same, output -1. 
 *      If the string is empty or less than two, output Invalid input. 
 * Constraints 
 *  0<= string length <= 100
 * 
 */

 import java.util.*;

class LongestDistinctSubString {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int k=sc.nextInt() , max = 0;
        if(s.length()<2){
            System.out.println("Invalid input");
            return;
        }
        int n = s.length();
        if(isUnique(s)){
            System.out.println("-1");
            return;
        }
        for(int i=0;i<n;i++){
            for(int j=i+k;j<=n;j++){
                String substr = s.substring(i,j);
                int dist = count(substr);
                if(dist == k){
                    max = Math.max(substr.length(),max);
                }
            }
        }
        System.out.println(max);
    }
    
    private static int count(String s){
        Set<Character> st = new HashSet<>();
        
        for(char c : s.toCharArray()){
            if(!st.contains(c)){
                st.add(c);
            }
        }
        return st.size();
    }
    private static boolean isUnique(String s){
        char a = s.charAt(0);
        for(char c : s.toCharArray()){
            if(a!=c)
            return false;
        }
        return true;
    }
}