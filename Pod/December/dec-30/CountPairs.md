## Problem Statement:

Given an array of `N` integers, and a number `sum`, find the number of pairs of integers in the array whose sum is equal to `sum`.

> **Note**: Use `HashMap` to solve this problem.

### Example:
If the input is `arr[] = {1, 5, 7, -1}` and the sum is `6`, then the output is `2`.

**Explanation**: The sum 6 pairs are `(1, 5)` and `(7, -1)`.

### Input format:

The first line of the input is N, which is the number of elements in that array, followed by the N elements.
The next line of the input consists of the sum.


### Output format:

The output prints the count of pairs with the given sum.


### Sample test cases:
**Input 1:**
``` Input  
4
1 5 7 -1 
6

```

**Output 1:**
```
Count of pairs 6 is 2
```
``` java []


import java.util.*;

class Pairs{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        
        int k = sc.nextInt() , cnt = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j] == k){
                    cnt++;
                }
            }
        }
        
        System.out.printf("Count of pairs %d is %d",k,cnt);
    }
}
```