/*
 * 
 * Vijay is working on a problem where he needs to use a queue to find the index of the first non-repeating character in a string. He needs to efficiently manage the characters and their frequencies to identify the first unique character. If there are no non-repeating characters, he should return -1. 



Help Vijay utilize the queue to solve this problem.



Company Tags: Adobe

Input format :
The input consists of a string s.

Output format :
The output prints an integer, representing the index(0-based) of the first non-repeating character in the string.

If no such character exists, print -1.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ s.length ≤ 100

The string s contains only lowercase elements.

Sample test cases :
Input 1 :
madam
Output 1 :
2
Input 2 :
aabbccdd
Output 2 :
-1
 * 
 */

 import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int result = -1;
        for(char c : s.toCharArray()){
            if(s.indexOf(c) == s.lastIndexOf(c)){
                result = s.indexOf(c);
                break;
            }
        }
        
        System.out.println(result);
    }
}