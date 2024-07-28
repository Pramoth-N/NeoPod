import java.util.*;

class DiceSum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int m = sc.nextInt();
        int n = sc.nextInt();
        int x = sc.nextInt();
        
        int[][] dp = new int[n+1][x+1];
        
        dp[0][0] = 1;
        
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=x;j++) {
                for(int k =1;k<=m;k++) {
                    if(j>=k) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        
        System.out.print(dp[n][x]);
    }
}