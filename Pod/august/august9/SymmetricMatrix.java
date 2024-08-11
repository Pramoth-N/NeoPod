/*
 * 
 * Given a square matrix and its size. Your task is to determine the type of matrix either Tymnatzic, 
 * the-Symmetric Of Reither. 
 * Input Format 
    * The first line contains on integers, 
    * representing the size of the matrix (nxn). 
    * The next n lines each contain integers, 
    * representing the elements of the matrix row-wise 
 * Output Format 
 *  Output Symmetric if the matrix is symmetric, 
 * show-symmetric if the matrix is skew-symmetric, or either if it is neither symmetric nor skew-symmetric 
 * If the matrix size is negative, output Invalid Input. 
 * Constraints 
 * -100 sns1000 -1000 s matrix elements 1000

Explanation 
    Symmetric Matrix: 
        A matrix A is symmetric if A = A^T. This means the element at position (i, j) is the same as the element at (j, i) for all i and j. 
    Skew-Symmetric Matrix: 
        A matrix B is skew-symmetric if B--BAT. This means the element at position (i, j) is the negative of the element at (j, i) for all i andį, and diagonal elements are zero.
 * 
 */

import java.util.*;

class SymmetricMatrix {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        if(n<=0){
            System.out.print("Invalid Input");
            return;
        }
        
        int[][] matrix = new int[n][n];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }
        }
        
        if(isSymmetric(matrix)){
            System.out.print("Symmetric");
        } else if(isSkewSymmetric(matrix)){
            System.out.print("Skew-Symmetric");
        } else {
            System.out.print("Neither");
        }
    }
    
    private static boolean isSymmetric(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(matrix[i][j] != matrix[j][i])
                return false;
            }
        }
        return true;
    }
    private static boolean isSkewSymmetric(int[][] matrix){
        int n = matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(matrix[i][j] != -matrix[j][i])
                return false;
            }
        }
        return true;
    }
}