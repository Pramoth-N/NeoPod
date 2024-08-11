/*
 * 
 * 
 * Given an Array List of coine representing different denominations of currency and an integer sum, 
 * find the number of ways you can make a sum by using different combinations from coins. 
 * Assume that you have an infinite supply of each type of coin, and you can use any coin as many times as you want. 
 * Input Format 
 *  The first line contains an integer sum, representing the target sum to achieve. 
 *  The second line contains coins, where each element represents a denomination of coin 
 * Output Format 
 *  Output a single integer representing the number of ways to make the sum using the colne provided 
 *  If the sum is a non-integer, output Invalid input. 
 *  If all elements in coine are the same, output -1. 
 * Constraints 0<coine<= 10
 * 
 * 
 */



 import java.util.*;

 public class CoinChange {
 
     public static int countWays(int sum, List<Integer> coins) {
         
         if (sum < 0) {
             System.out.println("Invalid input");
             return -1;
         }
 
         boolean allSame = coins.stream().distinct().count() == 1;
         if (allSame) {
             System.out.println("-1");
             return -1;
         }
 
         int[] dp = new int[sum + 1];
 
         dp[0] = 1;
 
         for (int coin : coins) {
             for (int j = coin; j <= sum; j++) {
                 dp[j] += dp[j - coin];
             }
         }
 
         return dp[sum];
     }
 
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         try {
         int sum = scanner.nextInt();
         scanner.nextLine(); 
         String[] coinStrings = scanner.nextLine().split(" ");
         List<Integer> coins = new ArrayList<>();
         for (String coinStr : coinStrings) {
             coins.add(Integer.parseInt(coinStr));
         }
         
         int result = countWays(sum, coins);
 
         if (result != -1) {
             System.out.println(result);
         }
         } catch (InputMismatchException ex){
             System.out.println("Invalid input");
         }
     }
 }
 