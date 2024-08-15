/*
 * Given a string representing a password, build a function to check the strength of the password using regular expressions. 
 * The function should ensure that the password satisfies the following conditions: 
 * it must be at least 8 characters long and include one uppercase letter, one lowercase letter, one digit, and one special character. 
 * Input Format 
 *  The input consists of a string a representing the input password. 
 * Output Format 
 *  Print strong if the password meets the criteria, otherwise print Weak. 
 *  if the password contains only asterisks, the function returns Invalid input. 
 * Constraints 
 *  1< length of <= 10 
 * The string consists of printable ASCII characters.
 */

import java.util.*;

class Password{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        boolean a = false,b= false,c= false;
        for(char d : s.toCharArray()){
            if(Character.isDigit(d)){
                a=true;
            } else if(Character.isUpperCase(d)) {
                b=true;
            } else if(Character.isLowerCase(d)) {
                c=true;
            }
        }
        if(s.length()>8 && a && b && c){
            System.out.println("Strong");
        } else if( a || b || c) {
            System.out.println("Weak");
        } else{
            System.out.println("Invalid input");
        }
    }
}