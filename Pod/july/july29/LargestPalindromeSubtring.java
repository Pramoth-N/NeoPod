/*
 * 
 * 
A palindrome string means that if we reverse the string, it gives you the same string.
For example:
         "madam" is a palindrome; if we reverse that string, it gives you the same word as "madam." 

Now you have a string, and your task is to figure out the largest palindrome in it.

Input format :
The first line of input consists of a string, str.

Output format :
The output prints the largest palindrome of the given string.



Refer to the sample input and output for formatting specifications.

Code constraints :
1 ≤ string.length ≤ 500


 * 
 */


import java.util.*;

class LargestPalindromeSubString {
    public static void main(String args[]) {
        String str = new String(new Scanner(System.in).nextLine());
        String pal ="";
        for(int i=0;i<str.length();i++) {
            for(int j=str.length();j>i;j--){
                String subStr = str.substring(i,j);
                
                if(isPal(subStr)) {
                    if(pal.length() < subStr.length()){
                        pal = subStr;
                    }
                }
            }
        }
        
        System.out.println(pal);
    }
    
    private static boolean isPal(String str) {
        int i=0,j=str.length() -1;
        
        while(i<j) {
            if(str.charAt(i++) != str.charAt(j--)){
                return false;
            }
        }
        
        return true;
    }
}