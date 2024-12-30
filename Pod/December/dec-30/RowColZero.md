## Problem Statement

Joseph is working on improving **data centre efficiency**. He manages a **grid of servers** as a **2D matrix**, where each cell is either **operational** (non-zero integer) or **non-operational** (zero). When a server becomes **non-operational** (zero), it causes all servers in its **row** and **column** to also become non-operational. 

Joseph needs a program to automate this process.

### Input format
The first line of input contains two integers **r** and **c**, representing the number of **rows** and **columns** of the matrix, respectively.

The next **r** lines each contain **c** integers, representing the matrix elements.

### Output format
The output should be the **modified matrix**, printed row by row, where the necessary rows and columns have been set to **non-operational** (zero).

### Code constraints
- 2 ≤ r, c ≤ 10
- 0 ≤ matrix elements ≤ 100

### Sample test cases
#### Input 1

3 3
1 1 1
1 0 1
1 1 1

#### Output 1

1 0 1 
0 0 0 
1 0 1 

#### Input 2

3 2
4 0
8 6
1 2

#### Output 2

0 0 
8 0 
1 0 


### Solution
 ``` java []
import java.util.*;

class Matrix{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = sc.nextInt();
            }
        }
        boolean firstRow = false , firstCol = false;
        for(int i=0;i<n;i++){
            if(grid[0][i] == 0){
                firstRow = true;
                break;
            }
        }
        
        for(int i=0;i<m;i++){
            if(grid[i][0] == 0){
                firstCol = true;
                break;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[i][j] == 0){
                    grid[i][0] = 0;
                    grid[0][j] = 0;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(grid[0][j] == 0 || grid[i][0] == 0){
                    grid[i][j] = 0;
                }
            }
        }
        
        if(firstCol){
            for(int i=0;i<n;i++){
                grid[i][0] = 0;
            }
            
        }
        if(firstRow){
            for(int i=0;i<m;i++){
                grid[0][i] = 0;
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}

```