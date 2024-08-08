/*
 * 
 * 
 * Given two natural numbers n and m. The task is to find the number of ways the numbers greater than or equal to m can be added to get the sum n.

    Write a program for the same.

    Note: Use Dynamic Programming

    Examples:

    Input : n = 3, m = 1

    Output : 3

    The following are three different ways to get sum n such that each term is greater than or equal to m

    1 + 1 + 1, 1 + 2, 3 



    Input : n = 2, m = 1

    Output: 2

    Two ways are 1 + 1 and 2

    Input format :
    The input consists of the values of n and m separated by space.

    Output format :
    The output prints the number of ways the numbers greater than or equal to m can be added to get the sum n.



    Refer to the sample output for the formatting specifications.

    Code constraints :
    1 <= n, m <= 100

    n > m

    Sample test cases :
    Input 1 :
    3 1
    Output 1 :
    3
    Input 2 :
    10 2
    Output 2 :
    12
    Input 3 :
    2 1
    Output 3 :
    2
 * 
 * 
 */


 import java.util.*;

class WaysToGetSum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[] dp = new int[n+1];
        
            dp[0] = 1;
        
        for(int i=m;i<=n;i++){
            for(int j=i;j<=n;j++){
                dp[j] += dp[j-i];
            }
        }
        
        System.out.println(dp[n]);
    }
}