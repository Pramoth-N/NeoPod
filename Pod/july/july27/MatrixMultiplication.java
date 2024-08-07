/*

 Given two matrices A and a of size ava, where n is a power of 2
 perform matrix multiplication using Strassen's algorithm.
 Strassen's algorithm is a divide-and-conquer method 
 that reduces the complexity of matrix multiplication compared to the conventional algorithm 
Input Format
     The first line contains an integer n, representing the size (rows and columns) of square matrices A and B 
     The next nxn lines contain integers, representing the elements of matrix A 
     The subsequent n x n lines contain integers, representing the elements of matrix & for operations requiring two matrices. 
Output Format
     -Display the result of matrix multiplication using Strassen's algorithm. 
     if the input is valid, 
     if the input is invalid (eg, non-square matrices), output Invalid Input. 
Constraints 
     The size should be a power of 2 (1,2,4,8-)

     
 */

import java.util.*;

public class MatrixMultiplication {
    public static void main(String ars[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n & (n-1)) != 0){
            System.out.print("Invalid input");
            return;
        }
        int a[][] = new int[n][n];
        int b[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                a[i][j] = sc.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                b[i][j] = sc.nextInt();
            }
        }
        int mul[][] = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++){
                mul[i][j] = 0;
                for(int k=0;k<n;k++){
                    mul[i][j] +=a[i][k]*b[k][j];
                }
            }
        }
        
        for(int[] row : mul) {
            for(int num : row) {
                System.out.print(num+" ");
            }
            System.out.println();
        }
    }

}
