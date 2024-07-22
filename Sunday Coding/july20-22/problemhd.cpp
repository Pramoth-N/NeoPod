#include<iostream>
#include<vector>
using namespace std;

void findPath(vector<vector<int>>& m, int n, int x, int y, string path , vector<string> &paths , vector<vector<bool>>& visited)
{
    if(x==n-1 && y==n-1)
    {
        paths.push_back(path);
        return ;
    }
    
    visited[x][y] =true;
    
    if(x>0 && m[x-1][y] == 1 && !visited[x-1][y])
    {
        findPath(m,n,x-1,y,path+"U",paths,visited);
    }
    if(x<n-1 && m[x+1][y] == 1 && !visited[x+1][y])
    {
        findPath(m,n,x+1,y,path+"D",paths,visited);
    }
    if(y>0 && m[x][y-1] == 1 && !visited[x][y-1])
    {
        findPath(m,n,x,y-1,path+"L",paths,visited);
    }
    if(y<n-1 && m[x][y+1] == 1 && !visited[x][y+1])
    {
        findPath(m,n,x,y+1,path+"R",paths,visited);
    }
    visited[x][y] = false;
}

int main()
{
    int n;
    cin>>n;
    vector<vector<int>> m(n,vector<int>(n));
    
    for(int i=0;i<n;i++) for(int j=0;j<n;j++) cin>>m[i][j];
    
    vector<string> paths;
    vector<vector<bool>> visited(n,vector<bool>(n,false));
    string path = "";
    
    findPath(m,n,0,0,path,paths,visited);
    
    if(paths.size()==0)
    {
        cout<<-1;
    }
    else{
        for(string x : paths)
        cout<<x<<" ";
    
    }
}