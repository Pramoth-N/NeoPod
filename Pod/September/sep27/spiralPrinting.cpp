#include<iostream>
using namespace std;
int main() {
    int n;
    cin>>n;
    if(n<=0) {
        cout<<"Invalid input";
        return 0;
    }
    int a[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>a[i][j];
        }
    }
    int t = 0 , l = 0 , b = n-1 , r = n-1 ;
    
    while(t<=b && l <= r){
        for(int i=l;i<=r;i++){
            cout<<a[t][i]<<" ";
        }
        t++;
        for(int i=t;i<=b;i++){
            cout<<a[i][r]<<" ";
        }
        r--;
        if(t<=b){
            for(int i=r;i>=l;i--){
                cout<<a[b][i]<<" ";
            }
            b--;
        }
        if(l<=r){
            for(int i=b;i>=t;i--){
                cout<<a[i][l]<<" ";
            }
            l++;
        }
    }
}