#include<iostream>
#include<string>
using namespace std;
int main(){
    int n,m;
    string q1="",q2="";
    char c;
    cin>>n;
    if(cin.fail()){
        cout<<"Invalid input";
        return 0;
    }
    
    for(int i=0;i<n;i++){
        cin>>c;
        q1+=c;
    }
    cin>>m;
    for(int i=0;i<m;i++){
        cin>>c;
        q2+=c;
    }
    string ans="" ;
    
    for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            string substring = q1.substr(i,j-i+1);
            if(q2.find(substring) != string::npos && substring.length() > ans.length()){
                ans = substring;
            }
        }
    }
    if(ans.empty())
    cout<<"-1";
    else
    cout<<ans;
}