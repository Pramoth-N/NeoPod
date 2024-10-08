/*

Imagine you are given a task by your teacher. The task is to develop a student registration system for a university. The system needs to maintain a priority queue of student registration requests based on their admission urgency.



Each student registration request is represented by a unique identifier (ID) and has an associated priority value. 



To implement the priority queue, you have decided to use a linked list data structure with a priority queue approach. Each student registration request will be stored in a node of the linked list, along with its priority value. The linked list will be organized in such a way that student requests with smaller priority values will be positioned first.

Input format :
The first line of input specifies the number of student registration requests to be processed.

The following input line will contain two integers separated by space: the unique identifier (ID) of a student registration request and its priority value.

Output format :
The output displays the "Priority Queue: " followed by the space-separated integers, representing the student registration requests in the priority queue after all the requests have been processed.

The student requests with smaller priority values will be positioned first.



Refer to the sample output for the exact text and format.

Code constraints :
The priority values range from 1 to 10.

101 ≤ unique ID ≤ 100001

Sample test cases :
Input 1 :
5
101 3
102 5
103 4
104 2
105 1
Output 1 :
Priority Queue: 105 104 101 103 102 
Input 2 :
3
201 8
202 9
203 7
Output 2 :
Priority Queue: 203 201 202 

*/

#include<bits/stdc++.h>
using namespace std;

struct Node{
    int val,pr;
};

int main(){
    int n;
    cin>>n;
    vector<Node> q(n);
    for(int i=0;i<n;i++){
        cin>>q[i].val >> q[i].pr;
    }
    
    sort(q.begin(),q.end(),[](Node& a , Node& b){return a.pr < b.pr ;});
    cout << "Priority Queue: ";
    for(Node node : q){
        cout<<node.val<<" ";
    }
  
}