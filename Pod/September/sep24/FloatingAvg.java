/*
 * 
 * 
Liam is developing a financial application that calculates the moving average of stock prices over a series of time intervals. He wants a program using a queue to process a stream of stock prices and return the moving average of the prices seen so far.



Example

Input

3

1 2 3

Output

1.00 1.50 2.00 

Explanation

The moving average of the first element is 1.00.

The next elements are 1 and 2, the moving average is (1 + 2) / 2 = 1.50.

The next elements are 1, 2, and 3, the moving average is (1 + 2 + 3) / 3 = 2.00.

Input format :
The first line of input consists of an integer n, representing the number of stock prices

The second line consists of n space-separated integers, representing a stock price.

Output format :
The output displays space-separated double values representing the moving average of the stock prices up to the current price, each rounded to two decimal places.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

1 ≤ n ≤ 15

10 ≤ queue elements ≤ 100

Sample test cases :
Input 1 :
3
1 2 3
Output 1 :
1.00 1.50 2.00 
Input 2 :
5
40 26 22 12 83
Output 2 :
40.00 33.00 29.33 25.00 36.60 
 * 
 */

 import java.util.*;

class FloatingAvg{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt() , sum = 0;
        for(int i=1;i<=n;i++){
            sum+= sc.nextInt();
            System.out.printf("%.2f ",(double)sum/i);
        }
    } 
}