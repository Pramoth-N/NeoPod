
# Knight Probability on a Chessboard

## Problem Statement

Given an **8x8 chessboard** and a Knight starting at position `(0, 0)`. The Knight has to take exactly `K` steps, where at each step it chooses any of the **8 possible moves** uniformly at random. 

If the Knight moves outside the chessboard, it cannot re-enter.

The task is to calculate the **probability** that the Knight remains on the chessboard after taking exactly `K` steps.

### Knight's Moves

The Knight moves according to the following rules, defined by changes in the `x` and `y` coordinates:

``` java []
dx = {1, 2, 2, 1, -1, -2, -2, -1};
dy = {2, 1, -1, -2, -2, -1, 1, 2};
```

---

## Input Format

- The input consists of a single integer `K`, representing the number of steps the Knight must take.

---

## Output Format

- Print the probability that the Knight remains on the chessboard after taking exactly `K` steps.
- The output should be rounded to **4 decimal places**.

---

## Constraints

- \( 1 \leq K \leq 10 \)

---

## Example

### Input 1:
```
1
```

### Output 1:
```
0.2500
```

### Explanation:
For \( K = 1 \):
- The Knight starts at `(0, 0)`.
- After one step, it can move to **8 possible positions**, but only **2 positions** are valid (inside the board).
- Thus, the probability is \( 2/8 = 0.25 \).

---

### Input 2:
```
4
```

### Output 2:
```
0.0986
```

---

## Notes

- Use **Dynamic Programming** to optimize the solution.
- At each step, check all **8 possible moves** of the Knight, and accumulate the probabilities for valid positions.

---

## Sample Test Cases

| Input | Output  |
|-------|---------|
| 1     | 0.2500  |
| 4     | 0.0986  |
---

``` java []

import java.util.*;

class Solution{
    static final int[] dx = {1,2,2,1,-1,-2,-2,-1};
    static final int[] dy = {2,1,-1,-2,-2,-1,1,2};
    
    private static double findProbability(int k){
        double[][][] dp = new double[k+1][8][8];
        dp[0][0][0] = 1d;
        
        for(int step = 1;step <= k ; step++){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(dp[step-1][i][j] > 0){
                        for(int m=0;m<8;m++){
                            int x = i+dx[m];
                            int y = j+dy[m];
                            
                            if(x>=0 && x<8 && y>=0 && y < 8){
                                dp[step][i][j] += dp[step-1][i][j] / 8d;
                            }
                        }
                    }
                }
            }
        }
        
        double prob = 0;
        
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                prob += dp[k][i][j];
            }
        }
        
        return prob;
    }
    
    public static void main(String[] args){
        int k = new Scanner(System.in).nextInt();
        
        System.out.printf("%.4f",findProbability(k));
    }
}

```