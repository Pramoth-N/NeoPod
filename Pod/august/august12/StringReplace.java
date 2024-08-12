/*
 * 
 * Sarah is working on a text-processing tool to automate certain tasks. She needs a program that replaces a specific substring in a given string with another substring. 



﻿Your task is to help her write a program that takes an input string, a substring to be replaced, and a replacement substring. The program should replace all occurrences of the specified substring with the replacement substring and print the modified string.

Input format :
The first line of the input consists of the original string.

The second line of the input consists of the substring to be replaced.

The third line of the input consists of the replacement substring.

Output format :
The output prints the modified string after replacing all occurrences of the specified substring with the replacement substring.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the given test cases will fall under the following constraints:

1 ≤ original string ≤ 100

1 ≤ substring to be replaced ≤ 10

1 ≤ replacement substring ≤ 10

Sample test cases :
Input 1 :
Hello World
World
Java
Output 1 :
Hello Java
Input 2 :
Programming is fun
is
isn't
Output 2 :
Programming isn't fun
 * 
 */


 import java.util.*;

class StringReplace {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String sent = sc.nextLine();
        String key = sc.nextLine();
        String word = sc.nextLine();
        System.out.println(sent.replace(key,word));
    }
}