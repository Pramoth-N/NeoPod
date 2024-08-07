/*
 * 
 * 
 * You are given a task to sort the number of windmills in various states of India, which are currently unsorted. 
 * 
Your task is to develop a program that sorts the windmill counts in ascending order using the selection sort algorithm. This will facilitate better analysis of the distribution of windmills across states.

Input format :
The first line of input consists of an integer N, representing the number of states.

The second line consists of N space-separated integers, representing the number of windmills in each state.

Output format :
The output prints the sorted windmill counts in ascending order, separated by space.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the given test cases will fall under the following constraints:

1 ≤ N ≤ 15

1 ≤ each windmill count ≤ 105

Sample test cases :
Input 1 :
5
274 121 196 300 286
Output 1 :
121 196 274 286 300 
Input 2 :
7
85 99 58 97 66 33 44
Output 2 :
33 44 58 66 85 97 99 
 * 
 * 
 */



 import java.util.*;

class SelectionSort {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        
        for(int i=0;i<n-1;i++){
            int min = i;
            for(int j=i+1;j<n;j++){
                if(nums[j] < nums[min]){
                    min = j;
                }
            }
            if(min != i){
                nums[i] =(nums[i] + nums[min]) - (nums[min] = nums[i]);
            }
        }
        for(int i=0;i<n;i++){
            System.out.print(nums[i] + " ");
        }
        
    }
}