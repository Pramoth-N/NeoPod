/*

Given string str, find the longest repeating non-overlapping substring in it.
In other words, find two identical substrings of maximum length that do not overlap. 
If there is more than one such substring, return any one of them. 
Write a program for the same. 

Note: Use Dynamic Programming 

Example: 
    Input: str = "aabaabaaba" 
    Output: aaba 
    
Input format: 
    The input consists of a string as str. 
    
Output format: 
    The output prints string, representing the longest repeating, non- overlapping substring in it. 

Code constraints: 
    The strings contain 100 characters.

*/

#include<iostream>
#include<vector>
using namespace std;
string longestIdenticalSubStr(string s)
{
    int n= s.length();
    vector<vector<int>> dp(n+1,vector<int>(n+1 , 0));
    string str ="";
    int max = 0 , end =0;
    
    for(int i=1;i<=n;i++)
    {
        for(int j = i+1;j<=n;j++)
        {
            if( s[i-1]==s[j-1] && dp[i-1][j-1] < j-i ){

                dp[i][j] = dp[i-1][j-1] + 1;
                
                if(dp[i][j] > max) {
                    max = dp [i][j];
                    end = i;
                }
            }
    
        }
    }
    
    return s.substr(end - max , max);
}
int main()
{
    string str ;
    cin>>str;
    cout<<longestIdenticalSubStr(str);
    return 0;
}