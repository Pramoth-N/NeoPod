/*
 * 
 * 
 * Your company is organizing a team-building activity where you need to arrange employees into two distinct groups: one group for technical activities and the other for creative activities.



The arrangement must ensure that:



Technical employees (represented by positive integers) and creative employees (represented by negative integers) are alternated.
The relative order within each group should be preserved.
You have a list of employees where each employee is represented by a unique integer (positive for technical and negative for creative).

Your task is to rearrange the list such that technical and creative employees are alternated while maintaining the order within each group.

Write a program to rearrange the employees' list based on the given conditions.

Example

Input 

6

1 2 3 -4 -1 4

Output 

1 2 3 -4 -1 4  -------> Input list

-4 1 -1 2 3 4  -------> Rearranged list

Explanation

Creative employees come first and are alternated with technical employees.

The relative order within the technical and creative groups is preserved.

Note: Here employee ID "0" represent technical employee.

Input format :
The first line consists of an integer N representing the number of employees.

The second line consists of an array of integers of size N where each integer represents an employee's ID.

Positive integers represent technical employees, and negative integers represent creative employees.

Output format :
The first line contains the elements of the original employee list before rearrangement.

The second line contains the elements of the employee list after rearrangement according to the given conditions.

Refer to the sample output for the formatting specifications.

Code constraints :
2 ≤ n ≤ 10

-100 ≤ employees ID ≤100

Sample test cases :
Input 1 :
6
1 2 3 -4 -1 4
Output 1 :
1 2 3 -4 -1 4 
-4 1 -1 2 3 4 
Input 2 :
10
-5 -2 5 2 4 7 1 8 0 -8
Output 2 :
-5 -2 5 2 4 7 1 8 0 -8 
-5 5 -2 2 -8 4 7 1 8 0 
 * 
 * 
 */



 import java.util.*;

class MixedArrangement{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] emp = new int[n];
        int neg = 0 , pos = 0;
        for(int i=0;i<n;i++){
            emp[i] = sc.nextInt();
            if(emp[i] < 0)
                neg++; 
            else
                pos++;
        }
        
        int[] tech = new int[pos];
        int[] creative = new int[neg];
        int i=0 , j=0;
        for(int k=0;k<n;k++){
            System.out.print(emp[k] + " ");
            if(emp[k]<0) 
                creative[i++] = emp[k] ;
            else
                tech[j++] = emp[k];
        }
        System.out.print("\n");
        i = j = 0;
        while(i<neg && j<pos){
            System.out.print(creative[i++] + " " + tech[j++] + " ");
        }
        while(i<neg){
            System.out.print(creative[i++] + " " );
        }
        while(j<pos){
            System.out.print(tech[j++] + " ");
        }
    }
}