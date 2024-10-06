#include<bits/stdc++.h>
using namespace std;

void dfs(vector<vector<int>>& graph , int x, vector<bool>& visited){
    visited[x] = true;
    
    for(auto i : graph[x]){
        if(!visited[i]){
            dfs(graph,i,visited);
        }
    }
}

int main(){
    int v,e;
    cin>>v>>e;
    if(v<=0){
        cout<<"Invalid input";
        return 0;
    }
    vector<vector<int>> graph(v);
    for(int i=0;i<e;i++){
        int u,v;
        cin>>u>>v;
        graph[u].push_back(v);
    }
    vector<bool> visited(v,false);
    dfs(graph,0,visited);
    for(bool b : visited){
        if(!b){
            cout<<"False";
            return 0;
        }
    }
    cout<<"True";
}