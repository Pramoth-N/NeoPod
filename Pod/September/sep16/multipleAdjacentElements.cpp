/*
Azhar is given the task of writing a program to update every array element by multiplying the previous and the next element. He seeks your assistance in the program since he is unable to solve.



Help him in the task.



Note: For the first and last elements, multiply the actual element with the next or previous.



For example, given an array 3 2 4 5 1 7, the result is 6 12 10 4 35 7. Here, each element is updated as follows:



First element: 3 * 2 = 6
Second element: 3 * 4 = 12
Third element: 2 * 5 = 10
Fourth element: 4 * 1 = 4
Fifth element: 5 * 7 = 35
Last element: 1 * 7 = 7.
Input format :
The first line of input consists of an integer N, representing the number of array elements.

The second line consists of N space-separated integers, representing the elements of the array.

Output format :
The output prints the updated array elements, separated by a space.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 10

0 ≤ N ≤ 10000

Sample test cases :
Input 1 :
6
3 2 4 5 1 7
Output 1 :
6 12 10 4 35 7 
Input 2 :
3
10 2 0
Output 2 :
20 0 0
*/

#include<iostream>
using namespace std;

int main(){
    int n;
    cin>>n;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>a[i];
    }
    
    int b[n];
     b[0] = a[0] * a[1];
     b[n-1] = a[n-1] * a[n-2];
    for(int i=1;i<n-1;i++){
        b[i] = a[i-1] * a[i+1];
    }
    
    for(int x : b) cout<< x << " ";
}