/*
 * 
 * Akila is developing a program to identify the day of the week based on a numerical input. She has designed a DayOfWeek class containing a method printDay for this purpose. The program takes an integer input representing a day of the week, and the printDay method prints the corresponding day.



Your task is to assist Akila in achieving this functionality.

Input format :
The input consists of an integer N, representing the day of the week (1 for Sunday, 2 for Monday, ..., 7 for Saturday).

Output format :
The output displays the corresponding day of the week.

If the input is invalid, print "Invalid".



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ Valid value of N ≤ 7

Sample test cases :
Input 1 :
7
Output 1 :
Saturday
Input 2 :
0
Output 2 :
Invalid
Input 3 :
9
Output 3 :
Invalid
 * 
 */

 import java.util.*;

class DayOfWeek{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        DayOfWeek dayOfWeek = new DayOfWeek();
        System.out.println(dayOfWeek.printDay(n));
    }
    
    private String printDay(int n){
        String[] days = {"Invalid","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
        
        try {
            return days[n];
        } catch(Exception e){
            return days[0];
        }
    }
}