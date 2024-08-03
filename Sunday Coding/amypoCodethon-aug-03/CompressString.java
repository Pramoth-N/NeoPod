/*
 * 
 * 
 * Given a string s, perform basic string compression using the counts of repeated characters. 
 * The compressed string is formed by replacing each group of consecutive repeated characters with the character followed by the count of repetitions. 
 * If the compressed string is not smaller than the original string, return the original string. 
 * Input Format 
 * The input consists of a string & representing the input string. 
 * Output Format 
 * The output must be a compressed string or the original string if compression does not reduce the size. 
 * Print the Original string, if the string contains Integers or Special characters. 
 * Constraints 
 * •1 s length of s ≤ 10000 
 * •The string consists of printable ASCII characters.
 * 
 * 
 */

import java.util.*;

class CompressString {
    public static void main(String args[]){
        String str = new Scanner(System.in).nextLine();
        StringBuilder comp = new StringBuilder();
        char c = str.charAt(0);
        char cnt = '1';
        for(int i=1;i<str.length();i++){
            if(!Character.isAlphabetic(str.charAt(i))){
                System.out.print(str);
                return;
            }
            if(c == str.charAt(i)){
                cnt++;
            }
            else {
                comp.append(c);
                comp.append(cnt);
                c = str.charAt(i);
                cnt = '1';
            }
        }
        comp.append(c);
        comp.append(cnt);
        if(comp.length() > str.length()){
            System.out.println(str);
        } else{
            System.out.println(comp);
        }
    }
}