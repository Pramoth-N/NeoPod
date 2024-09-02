/*

Given an array arr[] of length N and a number K, the task is to find all the subsequences of the array whose sum of elements is K.



Example 1:

Input: arr[] = {1, 2, 3}, K = 3 

Output: 

1 2 

3



Example 2:

Input: arr[] = {17, 18, 6, 11, 2, 4}, K = 6  

Output: 

6

2 4  

Input format :
The first line of input consists of an integer N, the number of elements in the array.

The second line of input consists of N integers separated by spaces, representing the elements of the array.

The third line of input consists of an integer K, representing the value of K.

Output format :
The output prints the subsequences of the array whose sum of elements is K.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ N ≤ 25

1 ≤ each array element ≤ 100

1 ≤ K ≤ 100

Sample test cases :
Input 1 :
3
1 2 3
3
Output 1 :
1 2 
3 
Input 2 :
6
17 18 6 11 2 4
6
Output 2 :
6 
2 4 

*/

#include<bits/stdc++.h>
using namespace  std;

void findSubSequence(int index,int sum,vector<int>& nums,vector<int>& cur,int k){
    if(index==nums.size()){
        if(sum == k){
            for(int num : cur){
                cout<<num<<" ";
            }
            cout<<endl;
        }
        return;
    }
    
    cur.push_back(nums[index]);
    findSubSequence(index+1,sum+nums[index],nums,cur,k);
    cur.pop_back();
    findSubSequence(index+1,sum,nums,cur,k);
}

int  main(){
    int n;
    cin>>n;
    vector<int> nums(n);
    for(int i=0;i<n;cin>>nums[i++]);
    int sum;
    cin>>sum;
    vector<int> cur;
    findSubSequence(0,0,nums,cur,sum);
}