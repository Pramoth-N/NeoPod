/*
 Given an m x n matrix, find and return the saddle point if it exists. 
 A saddie point is an element which is the minimum in its row and maximum in its column. 
 If multiple saddle points exist, return the first value. 
 Input Format 
    • The first line of input contains two integers and a representing the number of rows and columns respectively. 
    • The next m lines of input contain n integers representing the elements of the matrix. 
 Output Format 
    • Print two integers representing the row and column indices (0-based) of the saddle point. 
    Print-1 if none exists. •Print Invalid input, if any non-numerical inputs present
 */

import java.util.*;

class SaddlePoint{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int nums[][] = new int[n][m];
        try{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++)
                    nums[i][j] = sc.nextInt();
            }
        }catch(Exception ex){
            System.out.print("Invalid input");
            return;
        }
        for(int i=0;i<n;i++){
            int rowmin = rowMinima(nums[i]);
            int colmax = colMaxima(nums,rowmin);
            
            if(colmax == i){
                System.out.println(colmax+" "+ rowmin);
                return;
            }
        }
        
        System.out.print(-1);
        
    }
    
    private static int rowMinima(int[] row){
        int min = 0;
        for(int i=1;i<row.length;i++){
            if(row[min] > row[i])
            min = i;
        }
        return min;
    }
    
    private static int colMaxima(int[][] arr, int i){
        int max = 0;
        for(int j=1;j<arr.length;j++){
            if(arr[j][i]> arr[max][i]){
                max = j;
            }
        }
        return max;
    }
}