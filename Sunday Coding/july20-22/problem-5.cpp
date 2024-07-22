#include<iostream>
#include<unordered_set>
using namespace std;


int main()
{
    int n,k;
    cin>>n;
    int arr[n];
    for(int i=0;i<n;i++)
    cin>>arr[i];
    cin>>k;
    for(int i=0;i<=n-k;i++)
    {
        unordered_set<int> st;
        for(int j=i;j<i+k;j++)
        st.insert(arr[j]);
        
        cout<<st.size()<<endl;
    }
}