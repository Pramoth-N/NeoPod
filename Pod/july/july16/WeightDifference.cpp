#include<iostream>
#include<vector>
#include<climits>

using namespace std;

int main()
{
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++) cin>>arr[i];
    int min_val = INT_MAX , max_val = INT_MIN;
    for(int x : arr)
    {
        min_val = min(min_val , x);
        max_val = max(max_val , x);
    }
    
    cout<<"Heaviest piece weight: "<< max_val;
    cout<<"\nLightest piece weight: "<< min_val;
    cout<<"\nWeight difference: "<< max_val - min_val;
}