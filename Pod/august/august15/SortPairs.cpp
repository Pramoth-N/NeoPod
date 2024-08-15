/*

You are given a list of n key-value pairs where the keys are strings and the values are Integers. 
Your task is to sort the key-value pairs in descending order based on the values. 
If all the values are the same, return -1. Otherwise, retum the sorted key-value pairs. 
Input Format 
    The first line contains an integer n, representing the size of the map. 
    The following a lines contain a string key followed by an integer value. 
Output Format 
    Output the sorted HashMap entries in descending order of values. 
    If the map size is zero or negative, output zavalid input. 
    If all the values are the same, output -1. 
Constraints -100=100 -10 <= value <= 103 The string consists of printable ASCII characters.

*/

#include<iostream>
#include<vector>
#include<algorithm>

using namespace std;

int main(){
    int n;
    cin>>n;
    if(n<=0){
        cout<<"Invalid input";
        return 0;
    }
    vector<pair<string,int>> keys(n);
    for(int i=0;i<n;i++){
        cin>>keys[i].first>>keys[i].second;
    }
    bool f = true;
    for(int i=1;i<n;i++){
        if(keys[i].second != keys[i-1].second){
            f=false;
            break;
        }
    }
    if(f){
        cout<<-1;
        return 0;
    }
    sort(keys.begin(),keys.end(),[](pair<string,int>&a , pair<string,int>&b){return a.second>b.second;});
    
    for(auto key : keys){
        cout<<key.first<<" "<<key.second<<"\n";
    }
}