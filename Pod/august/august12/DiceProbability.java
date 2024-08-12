/*
 * 
 * Given n dice, each with m faces numbered from 1 to m, determine the number of ways to get a given sum X. X is the summation of values on each face when all the dice are thrown.



Note: Use Dynamic Programming

﻿

Example

Input:

faces = 4 throws = 2 sum =4 

Output: 3

Explanation:

Ways to reach a sum equal to 4 in 2 throws can be { (1, 3), (2, 2), (3, 1) }

Input format :
The input consists of three integers separated by spaces:

The number of faces on each dice (m).
The number of dice (n).
The target sum (X).
Output format :
The output prints a single integer representing the number of ways to achieve the target sum.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ m,n,X ≤ 15

Sample test cases :
Input 1 :
6 3 8
Output 1 :
21
Input 2 :
6 3 12
Output 2 :
25
Input 3 :
4 2 4
Output 3 :
3
 * 
 */


 import java.util.*;

class DiceProbability {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int faces = sc.nextInt();
        int n = sc.nextInt();
        int sum = sc.nextInt();
        int[][] dp = new int[n+1][sum+1];
        
        
        dp[0][0] = 1;
        
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j] = 0;
                for(int k=1;k<=faces;k++){
                    if(j>=k){
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        
        System.out.println(dp[n][sum]);
    }
}