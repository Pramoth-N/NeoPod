/*
 * Given the head of a sorted linked list, remove all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list after removing duplicates.



Example 1





Input:

7

1 2 3 3 4 4 5



Output: 

1 2 5 



Example 2





Input:

5

1 1 1 2 3



Output:

2 3 

Input format :
The first line of input consists of an integer n, representing the number of nodes in the linked list.

The second line of input consists of n space-separated integers, denoting the values of the nodes in the linked list.

Output format :
The output prints the values of the nodes in the linked list after removing duplicates and maintaining the sorted order.



Refer to the sample output for the formatting specifications

Code constraints :
1 ≤ n ≤ 20

-100 ≤ Elements of the node ≤ 100

The list is guaranteed to be sorted in ascending order.

Sample test cases :
Input 1 :
7
1 2 3 3 4 4 5
Output 1 :
1 2 5 
Input 2 :
5
1 1 1 2 3
Output 2 :
2 3 
 */

 import java.util.*;


 class RemoveDuplicates{
     public static void main(String args[]){
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();
         int nums[] = new int[n];
         
         for(int i=0;i<n;nums[i++] = sc.nextInt());
         
         Map<Integer,Integer> mp = new HashMap<>();
         
         for(int num : nums){
             mp.put(num,mp.getOrDefault(num,0) + 1);
         }
         for(int num : nums){
             if(mp.get(num) == 1)
             System.out.printf("%d ",num);
         }
     }
 }