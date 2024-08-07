#include<bits/stdc++.h>

using namespace std;

void backtrack(vector<vector<int>> &comb , vector<int> &cur , int rem , int st)
{
    if(rem == 0 )
    {
        comb.push_back(cur);
        return;
    }
    
    if(rem < 0)
    return;
    int i = st;
    for(; i<= rem ; i++)
    {
        cur.push_back(i);
        backtrack(comb , cur , rem - i , i);
        
        cur.pop_back();
    }
}

vector<vector<int>> getCombination(int n)
{
    vector<vector<int>> comb;
    vector<int> cur;
    backtrack(comb , cur , n , 1);
    
    return comb;
}

int main()
{
    int n;
    cin>>n;
    
    vector<vector<int>> arr = getCombination(n);
    
    cout<<"[";
    for(int i=0 ; i<arr.size();i++)
    {
        for( int j=0 ; j<arr[i].size();j++)
        {
            if(j==0)
            cout<<"[";
            cout<<arr[i][j];
            if(j<arr[i].size()-1)
            cout<<", ";
            else
            cout<<"]";
        }
        if(i!= arr.size()-1)
        cout<<", ";
    }
    cout<<"]";
    
}