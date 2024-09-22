/*
Given a singly linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)



Example 1





Input:

4

1 2 3 4



Output:

2->1->4->3



Example 2



Input:

1

1



Output: 

1

Input format :
The first line consists of an integer n representing the number of nodes in the linked list.

The second line consists of n integers separated by spaces, representing the values of the nodes in the linked list.

Output format :
The output returns the head of the linked list after swapping every two adjacent nodes.

Code constraints :
1 <= n <= 100

-100 <= Elements of the node <= 100

Sample test cases :
Input 1 :
4
1 2 3 4
Output 1 :
2->1->4->3
Input 2 :
1
1
Output 2 :
1
Input 3 :
5
10 20 30 40 50
Output 3 :
20->10->40->30->50
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
    for(int i=0;i<n-1;i+=2){
        swap(a[i],a[i+1]);
    }
    for(int i=0;i<n;i++){
        cout<<a[i];
        if(i!=n-1)
        cout<<"->";
    }
}