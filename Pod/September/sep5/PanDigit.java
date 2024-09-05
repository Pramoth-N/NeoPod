/*
 * 
 * Given an integer num, implement a function to check if num is a pandigital
 * number. A pandigital number is defined as a number that contains all digits
 * from 1 to n exactly once, where n is the number of digits in num. The
 * function should return true if num is pandigital, and false otherwise. Input
 * Format • The input consists of a single integer n, where n is the number to
 * be checked. Output Format • The output is a boolean value "true" if n is a
 * pandigital number, and "false" otherwise. • If the value of n is a
 * non-integer, print "Invalid input". • If the value of n is negative, print
 * "-1".
 * 
 */

 import java.util.*;
class PanDigit{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean[] v = new boolean[s.length()+1];
        if(s.charAt(0) == '-'){
                System.out.println("-1");
                return;
        }
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                v[c-'0'] = true;
            } else {
                System.out.println("Invalid input");
                return;
            }
        }
        
        for(int i=1;i<v.length;i++){
            if(!v[i]){
                System.out.println("false");
                return;
            }
        }
        System.out.println("true");
    }
}