/*
Toy loves trees, especially alphabet trees! He wants to build his alphabet tree by inserting characters one by one. Given a sequence of characters, Toy needs to construct a binary search tree where each node contains a character. After constructing the tree, Toy wants to search for a specific character in the tree to see if it exists or not.



Write a program to help Toy construct his alphabet tree and perform searches.

Input format :
The first line contains an integer, N, denoting the number of characters Toy wants to insert into the tree.

The second line contains N space-separated characters, representing the characters Toy wants to insert into the tree.

The third line contains a single character, V, representing the character Toy wants to search for in the tree.

Output format :
If the character V is found in the constructed alphabet tree, print "Character - [V] is Found".

If the character V is not found in the constructed alphabet tree, print "Character - [V] is Not Found".



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ N ≤ 10

Each character inserted into the tree is an uppercase English letter ('A' to 'Z').

Sample test cases :
Input 1 :
5
F A B C D
B
Output 1 :
Character - B is Found
Input 2 :
4
D B E A
C
Output 2 :
Character - C is Not Found
*/

#include<bits/stdc++.h>
using namespace std;
int main(){
    int n;
    cin>>n;
    set<char> st;
    for(int i=0;i<n;i++){
        char c;
        cin>>c;
        st.insert(c);
    }
    char c;
    cin>>c;
    if(st.count(c)){
        cout<<"Character - "<<c<<" is Found";
    } else {
        cout<<"Character - "<<c<<" is Not Found";
    }
}