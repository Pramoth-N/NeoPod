/*
 * 
 * In the field of historical geography, tracking the shifts in Earth's positions and alignments over time is crucial for understanding long-term climatic, geological, and astronomical phenomena.



Your task is to develop a program that identifies specific years within a given range where all geographic positions on Earth have completely shifted after 60 years.



Example



Input

1990

2340

Output 

All positions change in year 1990

All positions change in year 2050

All positions change in year 2110

All positions change in year 2170

All positions change in year 2230

All positions change in year 2290



Explanation

The input 1990 and 2340 indicates that we are interested in identifying years where every 60-year interval marks a complete change in all positions on Earth.

The expected output lists each year y1 where this change occurs, starting from 1990 and continuing in increments of 60 years until 2340.

Input format :
The first line consists of an integer y1, representing a starting year.

The second line consists of an integer y2, representing an ending year.

Output format :
For each year y1 within the range [y1, y2], print a message if it marks the beginning of a 60-year cycle where all positions on Earth have experienced significant changes. Specifically, output:

"All positions change in year y1".



Each output should appear on a new line.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ y1 ≤ 2500

1 ≤ y2 ≤ 3000

y1 ≤ y2

Sample test cases :
Input 1 :
2000
2100
Output 1 :
All positions change in year 2000
All positions change in year 2060
Input 2 :
1990
2340
Output 2 :
All positions change in year 1990
All positions change in year 2050
All positions change in year 2110
All positions change in year 2170
All positions change in year 2230
All positions change in year 2290
 * 
 */


 import java.util.*;
class EarthAllingment {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int u = sc.nextInt();
        int v = sc.nextInt();
        for(;u<=v;u+=60){
            System.out.println("All positions change in year " + u);
        }
    }
}