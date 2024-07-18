#include<bits/stdc++.h>
using namespace std;
bool isValid(int r , int c , int n , int m)
{
    return r>=0 && r<n && c>=0 && c<m ;
}

bool findWord(vector<vector<char>> &board , string word , int r , int c , int i , vector<vector<bool>> &visited)
{
    if(i == word.size())
    return 1;
    if(!isValid (r,c,board.size() , board[0].size()) || visited[r][c] || board[r][c] != word[i])
    return 0;
    
    visited[r][c] = true;
    
    bool found =  findWord(board,word,r+1 , c , i+1 , visited) ||
                    findWord(board,word,r-1 , c , i+1 , visited) ||
                    findWord(board,word,r , c+1 , i+1 , visited) ||
                    findWord(board,word,r , c-1 , i+1 , visited) ;
    visited[r][c] = false;
    
    return found;
    
}
int main()
{
    int n,m,i,j;
    cin>>n>>m;
    vector<vector<char>> board(n,vector<char>(m));
    for(i=0;i<n;i++) for(j=0;j<m;j++) cin>>board[i][j];
    string word;
    cin>>word;
    
    vector<vector<bool>> visited(n,vector<bool>(m,false));
    
    bool found = false;
    
    for(i=0;i<n;i++)
    {
        for(j=0;j<m;j++)
        {
            if(findWord(board,word,i,j,0,visited))
            {
                found = true;
            }
        }
    }
    cout<<found;
}