/*
 * 
 * Ashok is given a string consisting of some words separated by spaces. He wants to return the length of the last word in the string. The word is a maximal substring consisting of non-space characters only. Help Ashok to complete the program.

Input format :
The input consists of a string.

Output format :
The output prints an integer representing the length of the last word in the string.



Refer to the sample output for formatting specifications.

Code constraints :
2 ≤ length of the input string ≤ 100

Sample test cases :
Input 1 :
Hello World
Output 1 :
5
Input 2 :
What a breathtakingly beautiful scene!
Output 2 :
6
 * 
 */

 import java.util.*;

class StringLenth {
    public static void main(String args[]){
        String[] words = new Scanner(System.in).nextLine().split(" ");
        System.out.println(words[words.length - 1].length());
    }
}