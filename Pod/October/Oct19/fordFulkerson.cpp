/*
Here is the question corresponding to the C++ code you requested:

---

**Problem: Maximum Flow in a Directed Graph**

You are given a directed graph with `n` vertices and `m` edges, where each edge has a capacity. Your task is to find the maximum flow from a source vertex to a sink vertex using the **Ford-Fulkerson** algorithm.

### Input Format:
- The first line contains two integers `n` and `m`, where:
  - `n` is the number of vertices in the graph (numbered from 0 to n-1),
  - `m` is the number of edges in the graph.
- The next `m` lines each contain three integers `u`, `v`, and `e`, representing an edge from vertex `u` to vertex `v` with capacity `e`.
- The last line contains two integers, `source` and `sink`, which are the source and sink vertices.

### Output Format:
- Print the **maximum flow** from the `source` to the `sink`.
- If the input contains any negative values for vertices, edges, or capacities, print `"Invalid Input"`.

### Constraints:
- `1 ≤ n ≤ 100`
- `0 ≤ m ≤ n*(n-1)` (i.e., at most there can be n*(n-1) edges)
- `0 ≤ u, v < n`
- `1 ≤ e ≤ 10^5`
- The source and sink vertices are distinct and valid.

### Example:

#### Input:
```
4 5
0 1 10
0 2 5
1 2 15
1 3 10
2 3 10
0 3
```

#### Output:
```
15
```

#### Explanation:
- The graph has 4 vertices and 5 edges.
- The edges and capacities are given, and you are required to compute the maximum flow from vertex `0` (source) to vertex `3` (sink).
- The maximum possible flow from source to sink is `15`. 

#### Invalid Input Example:
```
4 5
0 1 -10
0 2 5
1 2 15
1 3 10
2 3 10
0 3
```

Output:
```
Invalid Input
```
*/

#include<bits/stdc++.h>
using namespace std;

bool bfs(vector<vector<int>>& r,int src , int sink , vector<int>& parent){
    int n = r.size();
    vector<bool> vs(n,0);
    queue<int> q;
    q.push(src);
    vs[src] = 1;
    parent[src] = -1;
    while(!q.empty()){
        int u = q.front();
        q.pop();
        for(int v = 0;v<n;v++){
            if(!vs[v] && r[u][v] > 0){
                q.push(v);
                parent[v] = u;
                vs[v] = 1;
                if(v==sink){
                    return true;
                }
            }
        }
    }
    return 0;
}
int ford_fulkerson(vector<vector<int>>&graph ,int src ,int sink) {
    int n = graph.size();
    vector<vector<int>> r = graph;
    vector<int> parent(n);
    int maxFlow = 0;
    while(bfs(r,src,sink,parent)){
        int pathFlow = INT_MAX;
        for(int v = sink ; v != src ; v=parent[v] ){
            int u = parent[v];
            pathFlow = min(pathFlow,r[u][v]);
        }
        for(int v = sink ; v != src ; v=parent[v] ){
            int u = parent[v];
            r[u][v] -= pathFlow;
            r[v][u] += pathFlow;
        }
        maxFlow += pathFlow;
        
    }
    return maxFlow;
}
int main(){
    int n , m ;
    cin >> n >> m;
    
    vector<vector<int>> graph(n,vector<int>(n,0));
    
    for(int i=0;i<m;i++){
        int u,v,c;
        cin >> u >> v >> c;
        if(u< 0 || v <0 || c<0){
            cout<<"Invalid Input";
            return 0;
        }
        graph[u][v] = c;
    }
    int src , sink;
    cin >> src >> sink;
    
    cout << ford_fulkerson(graph , src , sink) << endl;
    
}