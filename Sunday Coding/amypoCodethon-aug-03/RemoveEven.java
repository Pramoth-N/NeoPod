/*
 * 
 * 
 * Given a 2D array matrix, replace all even elements in the array with zero. 
 * Input Format 
 * • The first line of input contains two integers and a representing the number of rows and columns respectively. 
 * • The next a lines of input contain a integers representing the elements of the array. 
 * Output Format 
 * Print lines where each line contains n integers representing the modified array where even elements are replaced with zero. 
 * If the array elements are non-integer, print Invalid input. 
 * Constraints -1000 ≤ n ≤ 1000
 * 
 * 
 */


import java.util.*;
class RemoveEven{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] nums = new int[n][m];
        try{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    nums[i][j] = sc.nextInt();
                }
            }
        }catch(Exception ex){
            System.out.println("Invalid input");
            return;
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                nums[i][j] = (nums[i][j] % 2 == 0) ? 0 : nums[i][j];
            }
        }
        
        for(int[] row : nums){
            for(int num : row)
            System.out.print(num + " ");
            System.out.println();
        }
    }
}