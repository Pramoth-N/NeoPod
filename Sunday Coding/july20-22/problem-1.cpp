#include<iostream>
using namespace std;
int main()
{
    int n;
    cin>>n;
    
    for(int i=1;i<=n;i++)
    {
        string s="";
        int t = i;
        while(t)
        {
            if(t & 1)
            {
                s = to_string(1)+s;
            }
            else
            {
                s = to_string(0)+s;
            }
            t = t>>1;
        }
        
        cout<<s<<" ";
    }
}