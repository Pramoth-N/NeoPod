#include<bits/stdc++.h>
using namespace std;

bool isBipartite( vector<vector<int>>& graph){
int n = graph.size();
    vector<int> c(n,-1);
    queue<int> q;
    for(int i=0;i<n;i++){
        if(c[i] == -1){
            c[i]=0;
            q.push(i);
            while(!q.empty()){
                int u=q.front();
                q.pop();
                for(auto& v : graph[u]){
                    if(c[v] == -1){
                        c[v] = 1-c[u];
                        q.push(v);
                    }else if(c[v] == c[u]){
                        return false;
                    }
                }
            }
        }
    }
    return true;
}

int main(){
    int n,e;
    cin>>n>>e;
    if(n<0){
        cout<<"Invalid Input";
        return 0;
    }
    vector<vector<int>> graph(n);
    for(int i=0;i<e;i++){
        int u,v;
        cin>>u>>v;
        graph[u].push_back(v);
        graph[v].push_back(u);
    }
    
    if(isBipartite(graph)){
        cout<<"Bipartite";
    } else {
        cout << "Not Bipartite";
    }
}