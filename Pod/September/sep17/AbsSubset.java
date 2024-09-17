/*
 * 
 * Given a set of integers, the task is to divide it into two sets S1 and S2 such that the absolute difference between their sums is minimum. 



If there is a set S with n elements, then if we assume Subset1 has m elements, Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.



Example

Input 

4

1 6 11 5

Output 

1

Explanation:

Subset1 = {1, 5, 6}, sum of Subset1 = 12 

Subset2 = {11}, sum of Subset2 = 11     

Input format :
The first line contains an integer n, representing the number of elements in the array.

The second line contains n space-separated integers, representing the elements of the array.

Output format :
The output prints a single integer representing the minimum difference between the sums of two subsets of the given array.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 10

0 ≤ elements ≤ 100

Sample test cases :
Input 1 :
6
3 1 4 2 2 1
Output 1 :
1
Input 2 :
4
1 6 11 5
Output 2 :
1
 * 
 */

 import java.util.*;
class AbsSubset{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++)
            nums[i] = sc.nextInt();
        Arrays.sort(nums);
        int sum = Arrays.stream(nums).sum();
        int target = sum/2;
        boolean dp[][] = new boolean[n+1][target+1];
        for(int i=0;i<n;i++)
        dp[i][0] = true;
        for(int i=1;i<=n;i++){
            for(int j =1;j<=target;j++){
                dp[i][j] = dp[i-1][j];
                if(j>=nums[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-nums[i-1]];
                }
            }
        }
        int max_sum  = 0;
        for(int j = target;j>=0;j--){
            if(dp[n][j]){
                max_sum = j;
                break;
            }
        }
        System.out.print(sum - 2*max_sum);
    }
}