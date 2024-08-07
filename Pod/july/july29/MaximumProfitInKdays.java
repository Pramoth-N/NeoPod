/*
 * 
 * Imagine you are a sales manager at a retail store, and you need to analyze the daily sales data 
 * to determine the maximum revenue you can achieve from any continuous period of K days.

Example 1

Input: 

4 2

100 200 300 400

Output: 

700

Explanation:

300 + 400 = 700, which is the maximum.

Example 2

Input:

4 4

100 200 300 400

Output:

1000

Explanation:

100 + 200 + 300 + 400 = 1000, which is maximum.
 * 
 * 
 */

import java.util.*;

class MaximumProfitInKdays {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int sales[] = new int[n];
        
        for(int i=0;i<n;i++) {
            sales[i] = sc.nextInt();
        }
        
        int maxProfit = 0;
        
        for(int i=0;i<=n-k;i++) {
            int sum = 0;
            for(int j=i;j<i+k;j++){
                sum+=sales[j];
            }
            maxProfit = Math.max(maxProfit , sum);
        }
        System.out.println(maxProfit);
    }
}