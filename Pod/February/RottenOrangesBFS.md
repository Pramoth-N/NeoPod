**Rotten Oranges Problem**  

### **Problem Statement**  
You are managing a warehouse with fresh and rotten oranges placed in a grid. Each minute, fresh oranges adjacent to rotten ones become rotten. You need to calculate the minimum time required for all oranges to become rotten or determine if it's not possible.  

### **Input Format**  
- The first line contains two integers **m** and **n**, representing the dimensions of the grid.  
- The next **m** lines contain **n** integers, where:  
  - `2` represents a **rotten orange**.  
  - `1` represents a **fresh orange**.  
  - `0` represents an **empty cell**.  

### **Output Format**  
- Print the **minimum number of minutes** required for all fresh oranges to rot.  
- If it's not possible, print **`-1`**.  
- Print **`Invalid Input`** if `m` or `n` is zero.  

### **Constraints**  
- `0 ≤ m, n ≤ 100`  
- `grid[i][j]` ∈ `{0, 1, 2}`  

### **Example Input 1**  
```
3 3  
2 1 0  
1 1 0  
0 2 1  
```  

### **Example Output 1**  
```
2  
```

### **Explanation**  
- Initially, there are rotten oranges at positions `(0,0)` and `(2,1)`.  
- In **1 minute**, adjacent fresh oranges become rotten:  
  ```
  2 2 0  
  2 1 0  
  0 2 2  
  ```
- In **2 minutes**, all fresh oranges rot:  
  ```
  2 2 0  
  2 2 0  
  0 2 2  
  ```
- Output is **2 minutes**.  

```cpp []

#include<bits/stdc++.h>
using namespace std;

struct Node{
    int x , y , time;  
};

int minTimeToRot(vector<vector<int>>& grid , int n , int m){
    queue<Node> q;
    int cnt = 0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j] == 2){
                q.push({i,j,0});
            } else if(grid[i][j] == 1){
                cnt++;
            }
        }
    }
    if(cnt == 0) return 0;
    int time = 0;
    vector<pair<int,int>> dir = {
      {-1,0},  
      {1,0},  
      {0,-1},  
      {0,1}  
    };
    
    while(!q.empty()){
        Node cur = q.front();
        q.pop();
        
        for(auto d : dir){
            int x = cur.x + d.first;
            int y = cur.y + d.second;
        
            if(x < 0 || x >= n || y < 0 || y >= m || grid[x][y] != 1) continue;
            
            grid[x][y] = 2;
            cnt--;
            q.push({x,y,cur.time+1});
            time = cur.time + 1;
        }
    }
    
    return time;
}
int main(){
    int n , m;
    cin >> n >> m;
    if(n < 1 || m < 1){
        cout << "Invalid input";
        return 0;
    }
    
    vector<vector<int>> grid(n , vector<int>(m));
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            cin >> grid[i][j];
        }
    }
    cout << minTimeToRot(grid , n ,m) ;
    // cout << 1;
}

```
