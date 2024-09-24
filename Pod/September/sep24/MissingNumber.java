/*
 * 
 * 
Rohit has an array of integers, and he wants to find the missing number in the array. The array initially contains all the numbers from 1 to num+1, but one number is missing. Rohit needs to determine and print the missing number.



 Help him write a program to print the missing number.

Input format :
The first line contains an integer, num, representing the number of elements in the array.

The second line contains num space-separated integers, representing the elements of the array.

Output format :
The program prints an integer, representing the missing number in the array.



Refer to the sample output for formatting specifications.

Code constraints :
1<=num<=20.

1<=elements<=20.

Sample test cases :
Input 1 :
5
6 4 3 2 1
Output 1 :
5
Input 2 :
15
4 6 5 7 3 1 2 9 8 10 12 15 14 13 16
Output 2 :
11
 * 
 */


 import java.util.*;

class MissingNumber{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        boolean v[] = new boolean[n+2];
        for(int i=0;i<n;i++){
            int t = sc.nextInt();
            v[t] = true;
        }
        for(int i=1;i<=n+1;i++){
            if(!v[i]){
                System.out.println(i);
                return;
            }
        }
    }
}