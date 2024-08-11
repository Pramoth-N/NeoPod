/*
 * Given a matrix of dimensions mxn, calculate the sum of the elements in the upper triangle of the matrix. 
 * The upper triangle of the matrix includes all the elements above the main diagonal. 
 * Input Format 
 *  The first input line contains two integers and a representing the number of rows and columns. 
 *  The next lines of input contain a integers representing the elements of the matra 
 * Output Format 
 *  Print a single integer representing the sum of elements in the upper triangle of the matrix. 
 *  Print Invalid Input, if the character is entered as an element of the matrix 
 * Constraints 1smns 1000
 */

 import java.util.*;

class UpperTriangleSum {
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
        } catch (NoSuchElementException ex){
            System.out.println("Invalid input");
            return;
        }
        int sum = 0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<m;j++){
                sum += nums[i][j];
            }
        }
        System.out.println(sum);
    }
}