/*
In a scientific experiment dataset, time intervals between consecutive measurements are stored in a sorted array. 



You are assigned to develop a program to efficiently identify even time intervals using binary search and apply a user-defined multiplication factor to adjust their values. 



The program takes the number of measurements, the sorted array of time intervals, and the multiplication factor as input, displaying the modified array with adjusted time intervals.

Input format :
The first line of input consists of an integer N, representing the number of measurements in the experiment.

The second line consists of N space-separated integers, representing the sorted list of time intervals between measurements.

The third line consists of an integer M, representing the multiplication factor for adjusting the time intervals.

Output format :
The output prints the modified array of time intervals, with adjustments applied to intervals corresponding to even time intervals.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

1 ≤ interval ≤ 100

1 ≤ M ≤ 10

Sample test cases :
Input 1 :
5
12 15 16 24 26
2
Output 1 :
24 15 32 48 52 
Input 2 :
5
34 39 45 51 62
3
Output 2 :
102 39 45 51 186 
Input 3 :
5
25 37 49 51 63
9
Output 3 :
25 37 49 51 63 
*/

#include<stdio.h>


int main(){
    int n , m;
    scanf("%d",&n);
    int nums[n];
    
    for(int i=0;i<n;i++){
        scanf("%d",&nums[i]);
    }
    
    scanf("%d",&m);
    
    for(int i=0;i<n;i++){
        if(nums[i] % 2 == 0){
            nums[i]*=m;
        }
    }
    for(int i=0;i<n;i++){
        printf("%d ",nums[i]);
    }
}