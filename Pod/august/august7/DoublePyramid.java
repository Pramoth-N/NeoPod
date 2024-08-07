/*
 * 
 * 
 * Stephen wants to create a double pyramid pattern using asterisks based on a specified height. 
 * Write a program that reads the height of the pyramid and prints two mirrored pyramids side by side,
 *  with spaces between them. The pyramids should be aligned and centered correctly.

Example

Input: 

7 // height

Output:

Input format :
The input consists of an integer N, representing the height.

Output format :
The output displays the required pattern.

Refer to the sample input and output for formatting specifications.

Code constraints :
2 ≤ N ≤ 20

Sample test cases :
Input 1 :
7
Output 1 :
      *             * 
     * *           * * 
    * * *         * * * 
   * * * *       * * * * 
  * * * * *     * * * * * 
 * * * * * *   * * * * * * 
* * * * * * * * * * * * * * 
Input 2 :
4
Output 2 :
   *       * 
  * *     * * 
 * * *   * * * 
* * * * * * * * 
 * 
 * 
 */


 import java.util.*;

class DoublePyramid {
    public static void main(String args[]){
        int n = new Scanner(System.in).nextInt();
        
        
        for(int i=1;i<=n;i++) {
            if(i!=n)
            System.out.printf("%"+(n-i)+"s","");
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            if(i!=n)
            System.out.printf("%"+2*(n-i)+"s","");
            for(int j=1;j<=i;j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}