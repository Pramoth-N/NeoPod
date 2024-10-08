/*

Raju, an aspiring programmer, is working on a sorting program using the merge sort algorithm. He wants to sort the array and print the sorted array in descending order. Write a program to implement the merge sort algorithm.

Input format :
The first line consists of an integer N, representing the number of elements in the array.

The second line consists of N space-separated integers, representing the elements of the array.

Output format :
The output displays N space-separated integers sorted in descending order.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N ≤ 20

1 ≤ elements of the array ≤ 100

Sample test cases :
Input 1 :
8
78 34 23 76 12 10 4 79
Output 1 :
79 78 76 34 23 12 10 4 
Input 2 :
5
6 5 4 3 2
Output 2 :
6 5 4 3 2 

*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin>>n;
    vector<int> nums;
    while(n--){
        int t;
        cin>>t;
        nums.push_back(t);
    }
    
    sort(nums.begin(),nums.end(),greater<int>());
    for(int num : nums){
        cout<<num<<" ";
    }
}