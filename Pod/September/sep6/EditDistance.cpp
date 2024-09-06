/* find edit distance of two strings  */

#include<bits/stdc++.h>
using namespace std;
int main(){
    string s1,s2;
    cin>>s1>>s2;
    int m= s1.size() , n= s2.size();
    vector<vector<int>> dp(m+1,vector<int>(n+1));
    for(int i=0;i<=m;i++){
        for(int j=0;j<=n;j++){
            if(i==0){
                dp[i][j] = j;
            } else if(s1[i-1] == s2[j-1]){
                dp[i][j] = dp[i-1][j-1];
            } else {
                dp[i][j] = 1 + min({dp[i-1][j] , dp[i][j-1] , dp[i-1][j-1]});
            }
        }
    }
    
    cout<<dp[m][n];
}