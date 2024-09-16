/*
Write a program to find the pairs of integers in the array that can sum up to the given number S.



Note: Use Hashing technique to solve this.

Input format :
The first line of input consists of the size of the array.

The second line of input consists of the array elements.

The third line of input consists of the number S.

Output format :
The output displays all such pairs as mentioned in the problem.



Refer to the sample output for formatting specifications.

Sample test cases :
Input 1 :
6
1 2 3 4 5 6
7
Output 1 :
Pairs: 4 and 3
Pairs: 5 and 2
Pairs: 6 and 1
Input 2 :
6
11 12 13 14 11 6
7
Output 2 :
No such pairs
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    unordered_set<int> s;
    int n;
    cin>>n;
    vector<int> a(n);
    for(int i=0;i<n;i++){
        cin>>a[i];
        if(a[i] < 0){
            cout<<"No such pairs";
            return 0;
        }
    }
    int k;
    cin>>k;
    bool f = false;
    
    for(int x : a){
        int c = k-x;
        if(s.count(c)){
            cout<<"Pairs: "<<x << " and "<<c <<"\n";
            f = true;
        }
        
        s.insert(x);
    }
    if(!f)
    cout<<"No such pairs";
}