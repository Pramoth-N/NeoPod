/* print all combination in the classic key bord for the given input*/

#include<bits/stdc++.h>
using namespace std;
void generateComb(string s,int i,string cur,vector<string>& ans){
    vector<string> digits = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    if(i==s.length()){
        ans.push_back(cur);
        return;
    }
    string l =digits[s[i]-'0'];
    for(char x : l){
        generateComb(s,i+1,cur+x,ans);
    }
}
int main(){
    string n;
    cin>>n;
    vector<string> ans;
    generateComb(n,0,"",ans);
    for(auto x : ans)
    cout<<x<<"\n";
}