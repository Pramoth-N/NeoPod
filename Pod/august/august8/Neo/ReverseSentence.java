/*
 * 
 * 
 * Arun is given a line of text and has been asked to reverse the given string without reversing the individual words using Stack. Assist him in the program.
 * 
Example

Input: I am Neo

Output: Neo am I

Input format :
The input consists of the string that is to be reversed.

Output format :
The output displays the reversed string.

Refer to the sample output for formatting specifications.

Code constraints :
The input string should be 100 characters.

The input string contains lowercase and uppercase letters.

Sample test cases :
Input 1 :
Programming is creative
Output 1 :
creative is Programming
Input 2 :
I am Neo
Output 2 :
Neo am I
 * 
 * 
 */


 import java.util.*;

class ReverseSentence {
    public static void main(String args[]) {
        String s = new Scanner(System.in).nextLine();
        
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        for(String word : words){
            result.insert(0,word+" ");
        }
        System.out.println(result);
    }
}