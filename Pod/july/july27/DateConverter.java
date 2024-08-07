/*
    Given a year, determine the date of the 256th day of the year in different calendar systems: 
    Julian, Gregorian, and the special transition year of 1918. 
    Your program should correctly handle leap years and special cases for the year 1918. 
    Input Format 
        A single integer representing the year. 
    Output Format 
        Print the date of the 256th day in the format DD.MM.YYYY. 
        • Print Invalid input if the input is non-integer. 
        • Print -1 if the input is negative. 
    Constraints 
        ⚫-9999 ≤ year ≤ 9999
        
 */

import java.util.*;
import java.time.Year;
class DateConverter{
    public static void main(String args[]) {
        int year = 0;
        try {
        year = new Scanner(System.in).nextInt();
        } catch(Exception ex) {
            System.out.print("Invalid input");
            return;
        }
        if(year <=0){
            System.out.print("-1");
            return;
        }
        if(Year.isLeap(year)){
        System.out.print(getDate(year,255));
        } else{
        System.out.print(getDate(year,256));
        }
    }
    
    private static String getDate(int year , int day){
        int month[] = {31,28,31,30,31,30,31,31,30,31,30,31};
        int m = 0;
        int rem = day;
        while(rem > month[m]){
            rem -=month[m++];
        }
        
        return String.format("%02d.%02d.%04d",rem,m+1,year);
    }
}