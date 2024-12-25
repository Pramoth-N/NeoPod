## Problem Statement



You are given an array of n pairs where **pairs[i] = [lefti, righti]** and lefti < righti. A pair ` p2 = [c, d] `follows a pair ` p1 = [a, b] if b < c `. A chain of pairs can be formed in this fashion. Return the length longest chain that can be formed. You do not need to use up all the given intervals. You can select pairs in any order.



### Example 1



## Input:
```
3

1 2

2 3

3 4
```
## Output:
```
 2
```
## Explanation: 
The longest chain is [1,2] -> [3,4].



### Example 2



## Input:
```
3

1 2

7 8

4 5
```
## Output: 
```
3
```
## Explanation: 

The longest chain is [1,2] -> [4,5] -> [7,8].

## Input Format
- The first line of input consists of an integer `n`, representing the number of pairs.
- Each of the next `n` lines consists of two space-separated integers `lefti` and `righti`, representing the values of the ith pair.

## Output Format
- The output prints a single line containing an integer, representing the length of the longest chain that can be formed from the given pairs.

## Code Constraints
- 1 ≤ n ≤ 100
- -100 ≤ lefti < righti ≤ 100





| Test Case | Input | Output |
|------------|--------|--------|
| 1 | 3<br>1 2<br>2 3<br>3 4 | 2 |
| 2 | 3<br>1 2<br>7 8<br>4 5 | 3 |



``` java []
import java.util.*;

class Pairs{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] chain = new int[n][2];
        
        for(int i=0;i<n;i++){
            chain[i][0] = sc.nextInt();
            chain[i][1] = sc.nextInt();
        }
        
        Arrays.sort(chain , (a,b) -> a[0] - b[0]);
        int last = chain[0][1];
        int length = chain[0][1] - chain[0][0];
        for(int i=1;i<n;i++){
            if(chain[i][0] > last){
                length += chain[i][1] - chain[i][0];
                last = chain[i][1];
            }
        }
        System.out.println(length);
    }
}

```