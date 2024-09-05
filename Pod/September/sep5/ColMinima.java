/*
 * 
 * Given a two-dimensional array matrix with rows and columns, implement a
 * function that retums the index of the column with the minimum sum. The
 * function should take the number of rows, columns, and the matrix as input and
 * return the 0-based index of the column that has the smallest sum of its
 * elements. Input Format The first input line contains two integers m and
 * representing the number of rows and columna respectively. The next in lines
 * of input contain a space-separated integers representing the elements of the
 * array. Output Format The output must be a single integer representing the
 * index of the column with the minimum sum (0-based indexing). -If any of the
 * input is a non-integer, print "Invalid input". if the values of m or n are
 * negative, print "-1"
 * 
 */

 import java.util.*;
class ColMinima {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        if(m<=0 || n<=0){
            System.out.println("-1");
            return;
        }
        int[][] nums = new int[n][m];
        try{
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    nums[i][j] = sc.nextInt();
                }
            }
        } catch(InputMismatchException ex){
            System.out.println("Invalid input");
            return;
        }
        int[] sum = new int[m];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                sum[i]+=nums[j][i];
            }
        }
        int min = 0;
        for(int i=1;i<m;i++){
            if(sum[min] > sum[i]){
                min = i;
            }
        }
        System.out.println(min);
    }
}