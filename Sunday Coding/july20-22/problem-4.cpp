#include<iostream>
#include<vector>
#include<map>
#include<math.h>
using namespace std;

long toDecimal(string s)
{
    long num =0,j=1;
    for(int i=s.size()-1;i>=0;i--)
    {
        if(s[i] == '1')
        {
            num+=pow(2,j);
        }
        j++;
    }
    return num;
}

int main()
{
    int n;
    cin>>n;
    vector<string> arr(n);
    for(int i=0;i<n;i++) cin>>arr[i];
    map<long,string> mp;
    for(string x : arr)
    {
        mp[toDecimal(x)] = x;
    }
    
    for(auto it : mp)
    cout<<it.second<<" ";
}