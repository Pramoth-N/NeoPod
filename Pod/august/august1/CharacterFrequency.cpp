/*

Given a string str and an integer k, remove all characters from the string that appear exactly k times. 
Input Format 
• The first line of the input contains a string str. 
• An integer k represents the number of times the letter occurs and needs to be removed. 
Output Format 
Displays the string with all characters appearing exactly k times removed. 
• Print Invalid input, if any numerical inputs present in str Print -1, 
if there is no character presents k times. 
Constraints 
1<= str.length <= 105 1<= x <= 4

*/

#include<iostream>
#include<unordered_map>

using namespace std;

int main(){
    string s;
    int n;
    cin>>s>>n;
    
    unordered_map<char,int> mp;
    for(char x : s){
        if(isdigit(x)){
            cout<<"Invalid input";
            return 0;
        }
        mp[x]++;
    }
    string ans="";
    bool t = true;
    for(char x : s){
        if(mp[x] !=n)
        ans+=x;
        else
        t = false;
    }
    if(t)
    cout<<-1;
    else
    cout<<ans;
}


