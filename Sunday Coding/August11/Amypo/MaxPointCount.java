/*
 * 
 * Given a string ate and integers x and y, remove ab for a points and ba for y points from atr. 
 * Determine the maximum score achievable after performing these operations. 
 * Input Format 
 *  The first line contains a string str. 
 *  The second line contains an integer x, the points gained for removing the substring ab. 
 *  The third line contains an integer y, the points gained for removing the substring ba 
 * Output Format 
 *  Print a single integer, the maximum points you can gain after applying the operations. 
 *  If the user enters any numbers in a string,print Invalid input. 
 *  If the user enters any negative values, print -1
 * Constraints 1cm (atr.length) <= 1000 -100, у= 1000 The string ste contains only lowercase English letters
 * 
 */

import java.util.*;

class MaxPoniCount {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int x = sc.nextInt();
        int y = sc.nextInt();
        if(x<0 || y<0){
                System.out.print("-1");
                return;
            }
        int points = 0;
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                System.out.print("Invalid input");
                return;
            }
        }
        while(s.contains("ab") || s.contains("ba")){
            if(y<x || !s.contains("ba")){
                while(s.contains("ab")){
                    s = s.replaceFirst("ab","");
                    points += x;
                }
            } else {
                while(s.contains("ba")){
                    s = s.replaceFirst("ba","");
                    points += y;
                }
            }
        }
        System.out.println(points);
    }
}