/*
Given n dice each with m faces, numbered from 1 to m, find the number of ways to get sum X. X is the summation of values on each face when all the dice are thrown.

Input format :
The input consists of three space separated integers m, n, and x, representing the number of faces on each die, the number of dice and the desired sum.

Output format :
The output prints a single integer representing the number of ways to get the sum x using n dice, each having m faces.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ m, n, x ≤ 50

Sample test cases :
Input 1 :
4 2 1
Output 1 :
0
Input 2 :
2 2 3
Output 2 :
2
Input 3 :
6 3 8
Output 3 :
21
*/

#include<bits/stdc++.h>
using namespace std;
int main(){
    int m,n,x;
    
    cin>>m>>n>>x;
    vector<vector<int>> dp(n+1,vector<int>(x+1,0));
    
        dp[0][0] = 1;
    for(int i=1;i<=n;i++){
        for(int j=1;j<=x;j++){
            for(int k=1;k<=m && k<=j ; k++){
                dp[i][j] += dp[i-1][j-k];
            }
        }
    }
    
    cout<<dp[n][x];
    
}