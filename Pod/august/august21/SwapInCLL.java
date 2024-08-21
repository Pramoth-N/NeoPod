/*
 * 
 * Lalit and his friends are playing cards sitting around a circular table. Each player is represented by a node in a circular linked list, where the data in the node represents the player's unique identifier. After the first game, the first player and the last player exchange their positions. Pranav, who is watching the game, wants to simulate this scenario using a circular linked list.



Help Pranav write a program to manage this scenario by implementing the following operations:



Insert nodes (players) into the circular linked list.
Traverse the circular linked list to display the players.
Exchange the first and last nodes (players) in the circular linked list.
Input format :
The first line of input contains an integer m, the number of players.

The second line contains m space-separated integers representing the unique identifiers of the players.

Output format :
The output displays the list of players before and after the exchange of the first and last nodes in separate lines.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

2 ≤ m ≤ 20

1 ≤ unique idenitifiers ≤ 100

Sample test cases :
Input 1 :
10
3 4 5 6 7 8 1 2 3 9
Output 1 :
Before Swap: 3 4 5 6 7 8 1 2 3 9 
After Swap: 9 4 5 6 7 8 1 2 3 3 
Input 2 :
3
10 20 30
Output 2 :
Before Swap: 10 20 30 
After Swap: 30 20 10
 * 
 */


 import java.util.*;

 class SwapInCLL {
     public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int[] nums = new int[n];
         for(int i=0;i<n;i++){
             nums[i] = sc.nextInt();
         }
         sc.close();
         System.out.print("Before Swap: ");
         for(int i=0;i<n;i++){
             System.out.print(nums[i] + " ");
         }
         nums[0] = nums[n-1]+nums[0] -(nums[n-1] = nums[0]);
         System.out.println();
         System.out.print("After Swap: ");
         for(int i=0;i<n;i++){
             System.out.print(nums[i] + " ");
         }
     }
 }