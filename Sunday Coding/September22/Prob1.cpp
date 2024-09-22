/*
Given a total of N tasks that you have to pick, labelled from 0 to N-1. Some tasks may have prerequisite tasks, for example, to pick task 0 you have to first finish task 1, which is expressed as a pair: [0, 1] Given the total number of tasks and a list of prerequisite pairs, return the ordering of tasks you should pick to finish all tasks. There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all tasks, return an empty array. 



Examples



Input: N=2, Prerequisite_Pairs=[[1, 0]]

Output: [0, 1] 

Explanation: There are a total of 2 tasks to pick. To pick task 1 you should have finished task 0. So the correct task order is [0, 1] . 



Input: N=4, Prerequisite_Pairs=[[1, 0], [2, 0], [3, 1], [3, 2]] 

Output: [0, 1, 2, 3] or [0, 2, 1, 3] 

Explanation: There are a total of 4 tasks to pick. To pick task 3 you should have finished both tasks 1 and 2. Both tasks 1 and 2 should be pick after you finished task 0. So one correct task order is [0, 1, 2, 3]. Another correct ordering is [0, 2, 1, 3].

Input format :
The first line of input consists of an integer n, representing the number of tasks (vertices).

The second line consists of an integer p, representing the number of prerequisites (edges).

The next p lines each consist of two integers orig and dest, representing a directed edge from orig to dest (prerequisite relationship).

Output format :
The output displays the tasks in a topologically sorted order.



Refer to the sample output for formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ n, p ≤ 8

Sample test cases :
Input 1 :
4
4
0 1
0 2
1 3
2 3
Output 1 :
0 1 2 3 
Input 2 :
5
3
1 0
3 2
2 0
Output 2 :
1 3 4 2 0 
Input 3 :
2
1
0 1
Output 3 :
0 1 
*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,m;
    cin>>n>>m;
    vector<vector<int>> prerequisites(m,vector<int>(2));
    for(int i=0;i<m;i++){
        cin>>prerequisites[i][1] >> prerequisites[i][0];
    }
    vector<vector<int>> adj(n);
    vector<int> indegree(n,0)  , result ;
    for(auto pre : prerequisites ){
        int u = pre[1] , v = pre[0];
        adj[u].push_back(v);
        indegree[v]++;
    }
    
    queue<int> q;
    
    for(int i=0;i<n;i++){
        if(indegree[i] == 0){
            q.push(i);
        }
    }
    
    while(!q.empty()){
        int u = q.front();
        q.pop();
        result.push_back(u);
        
        for(int v : adj[u]){
            if(--indegree[v] == 0){
                q.push(v);
            }
        }
    }
    
    for(int task : result){
        cout<<task<<" ";
    }
}