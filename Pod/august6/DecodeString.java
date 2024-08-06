/*
 * 
 * 
 * Given an encoded string, return its decoded string.

The encoding rule is k[encoded_string], where the encoded_string inside the square brackets is repeated exactly k times. Note that k is guaranteed to be a positive integer.



You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k.



For example, there will not be input like 3a or 2[4].

The test cases are generated so that the length of the output will never exceed 105.



Example

Input

3[a]2[bc]

Output

aaabcbc



Input

3[a2[c]]

Output

accaccacc



Input

2[abc]3[cd]ef

Output

abcabccdcdcdef

Input format :
The input consists of a single line containing a string s (1 <= |s| <= 30).

Output format :
The output consists of a single line containing the decoded string.



Refer to the sample output for the formatting specifications.

Code constraints :
1 <= s.length <= 30

s consists of lowercase English letters, digits, and square brackets '[]'.

s is guaranteed to be a valid input.

All the integers in s are in the range [1, 300].

Sample test cases :
Input 1 :
3[a]2[bc]
Output 1 :
aaabcbc
Input 2 :
3[a2[c]]
Output 2 :
accaccacc
Input 3 :
2[abc]3[cd]ef
Output 3 :
abcabccdcdcdef
 * 
 * 
 */


 import java.util.*;

class DecodeString {
    public static void main(String args[]) {
        String s = new Scanner(System.in).nextLine();
        
        Stack<Character> st = new Stack<>();
        
        for(char c : s.toCharArray()) {
            if(c != ']') {
                st.push(c);
            } else {
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty() && st.peek() != '[') {
                    sb.insert( 0 , st.pop());
                }
                
                st.pop();
                int n  = 0;
                StringBuilder numsb = new StringBuilder();
                while(!st.isEmpty() && Character.isDigit(st.peek())) {
                    numsb.insert( 0 , st.pop());
                }
                n= Integer.parseInt(numsb.toString());
                
                String decode = sb.toString();
                for(int i=1;i<n;i++) {
                    sb.append(decode);
                }
                
                for(char x : sb.toString().toCharArray()) {
                    st.push(x);
                }
            }
        }
        
        StringBuilder rev = new StringBuilder();
        while(!st.isEmpty()) {
            if(Character.isAlphabetic(st.peek()))
                rev.insert(0,st.pop());
        }
        
        System.out.println(rev);
    }
}