/*
 * 
 * 
 * Given an array of integers nums, you need to compute the prefix sum of the array. 
 * The prefix sum of an array is a new array where the value at each index & is the sum of the elements 
 * from the start of the array up to index 1 inclusive. 
 * 
 * Input Format 
 * • The first line of input contains an integer a representing the number of elements in the array. 
 * • The second line of input contains a integers representing the elements of the array. 
 * 
 * Output Format 
 * • The output must be a integers representing the prefix sum of the array. 
 * •Print Invalid input, if characters present in the value of the array. 
 * 
 * Constraints 1<=n≤ 10000
 * 
 * 
 */

import java.util.*;
class ArraySum{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        try{
            for(int i=0;i<n;i++){
                nums[i] = sc.nextInt();
            }
        }catch(Exception ex){
            System.out.println("Invalid input");
            return;
        }
        
        for(int i=n-1;i>0;i--){
            for(int j= i-1;j>=0;j--){
                nums[i]+=nums[j];
            }
        }
        
        for(int num : nums){
            System.out.print(num + " ");
        }
    }
}