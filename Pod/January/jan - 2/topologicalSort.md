You are given a directed acyclic graph ***(DAO)*** with n vertices and m edges. Your task is to perform topological sorting of the graph. Topological sorting of a graph is a linear ordering of its vertices such that for every directed edge **(u, v)**, verter u comes before v in the ordering

### Input Format

The first line contains on integer **n** (number of vertices in the graph).

The second line contains an integer **m** (number of directed edges in the graph

The next we lines contain two integers **u** and **v each, representing a directed edge from vertex u to vertex v.

### Output Format

Print the topological order of the vertices if it exists.

If no topological order exists (i.e., the graph contains a cycle), print -1.

### Constraints
- `1 ≤ n ≤ 20` (maximum number of vertices)
- `0 ≤ m ≤ n*(n-1)` (maximum number of edges in a directed graph)
- Vertex labels u and v are integers such that `0 ≤ u,v < n`
- The graph does not contain self-loops (i.e., no edge from a vertex to itself)

### Sample Input 1:
```
6
6
5 0
4 0
4 1
2 3
3 1
```
### Sample Output 1:
```
4 5 0 2 3 1
```


``` c++ []
#include<bits/stdc++.h>
using namespace std;

bool topologicalSort(int n , vector<vector<int>>& adj , vector<int>& res){
    vector<int> inDegree(n,0);
    queue<int> q;
    
    for(int i=0;i<n;i++){
        for(int v : adj[i]){
            inDegree[v]++;
        }
    }
    
    for(int i=0;i<n;i++){
        if(inDegree[i] == 0){
            q.push(i);
        }
    }
    
    while(!q.empty()){
        int u = q.front();
        q.pop();
        res.push_back(u);
        for(int v : adj[u]){
            inDegree[v]--;
            if(inDegree[v] == 0){
                q.push(v);
            }
        }
    }
    
    return res.size() == n;
}
int main(){
    int n , m;
    cin >> n >> m;
    
    vector<vector<int>> adj(n);
    for(int i=0;i<m;i++){
        int u , v;
        cin >> u >> v;
        if(cin.fail()){
            cout << "Invalid input";
            return 0;
        }
        adj[u].push_back(v);
    }
    
    vector<int> res;
    if(topologicalSort(n , adj , res)){
        for(int v : res){
            cout << v << " ";
        }
    } else {
        cout << "No";
    }
}
```