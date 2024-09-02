/*

You are given a network of n computers, represented by vertices numbered from 0 to n-1. The computers are connected to each other through network cables, forming a communication network. Your task is to determine whether the given network is bipartite or not using the Breadth-first search algorithm.



A network is considered bipartite if it can be divided into two independent sets of computers such that no two computers within the same set are directly connected. In other words, the computers in each set can communicate with computers in the other set but not within their own set.

Input format :
The first line contains an integer n, representing the total number of computers in the network.

The next n lines contain n integers each, representing the adjacency matrix G.

Each integer G[i][j] is either 0 or 1, separated by a space.

The last line contains an integer src, representing the source computer.

Output format :
If the graph is bipartite, print "Yes, the given graph is Bipartite".

If the graph is not bipartite, print "No, the given graph is not Bipartite".



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 6

The adjacency matrix will be a square matrix of size n x n.

Each cell in the matrix will contain either 0 or 1.

Sample test cases :
Input 1 :
3
0 1 1
1 0 0
1 0 0
0
Output 1 :
Yes, the given graph is Bipartite
Input 2 :
5
0 1 1 0 0
1 0 0 1 0
1 0 0 0 1
0 1 0 0 1
0 0 1 1 0
3
Output 2 :
No, the given graph is not Bipartite

*/

#include<bits/stdc++.h>
using namespace std;

bool isBiparted(int src , vector<vector<int>> &adj){
    int n = adj.size();
    queue<int> q;
    
    vector<int> mark(n,-1);
    q.push(src);
    mark[src] = 0;
    
    while(!q.empty()){
        int u=q.front();
        q.pop();
        
        for(int v=0;v<n;v++){
            if(adj[u][v] == 1){
                if(mark[v] == -1){
                    mark[v] = 1-mark[u];
                    q.push(v);
                } else if(mark[v] == mark[u]) {
                    return false;
                }
            }
        }
    }
    return true;
}

int main(){
    int n,src;
    cin>>n;
    vector<vector<int>> adj(n,vector<int>(n));
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin>>adj[i][j];
        }
    }
    cin>>src;
    
    if(isBiparted(src,adj)){
        cout<<"Yes, the given graph is Bipartite";
    } else {
        cout<<"No, the given graph is not Bipartite";
    }
}