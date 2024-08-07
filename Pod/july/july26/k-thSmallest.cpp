/*

Given a list of Integers and an integer k, Your task is to find the k-th smallest element 
in the list using a min-heap (priority queue) from the Standard Template Library (STL). 
Input Format
 • The first line consists of two Integers n and k, the size of the list and the position of the k-th smallest element. 
 • The second line consists of n integers representing the elements of the list. 
 Output Format 
 • A single Integer representing the k-th smallest element in the list. 
 Constraints 
 • 1≤ n ≤ 1000 •isksn 
 • The elements of the list are integers within the range [-1000 to 1000].


*/

#include<iostream>
#include<algorithm>
using namespace std;

int main()
{
    int n,k,temp;
    cin>>n>>k;
    int a[n];
    for(int i=0;i<n;i++){
        cin>>temp;
        a[i] = temp;
    }
    sort(a,a+n);
    cout<<a[k-1];
}