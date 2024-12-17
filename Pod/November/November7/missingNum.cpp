// smallest positive missing number in the array

#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin >> n;
    if(n<=0){
        cout<<"Invalid input";
        return 0;
    }
    int a[n];
    for(int i=0;i<n;i++){
        cin>> a[i];
    }
    sort(a,a+n);
    int ans = a[n-1]+1;
    for(int i=0;i<n-1;i++){
        if(a[i]+1 != a[i+1] && a[i] >= 0){
            ans = a[i]+1;
            break;
        }
    }
    cout << ans;
}