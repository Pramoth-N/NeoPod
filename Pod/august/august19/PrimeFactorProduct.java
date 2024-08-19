/*
 * 
 * Given a number n, we need to find the product of all of its unique prime factors. Prime factors: It is basically a factor of the number that is a prime number itself. 



Example 1 :  

Input: num = 10

Output: Product is 10

Explanation:

Here, the input number is 10 having only 2 prime factors and they are 5 and 2.

And hence their product is 10.



Example 2 :

Input : num = 25

Output: Product is 5

Explanation:

Here, for the input to be 25 we have only one unique prime factor i.e 5.

And hence the required product is 5.

Input format :
The input consists of a single integer n, representing the number.

Output format :
The output consists of a single integer, representing the product of the unique prime factors of the given number.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 100

Sample test cases :
Input 1 :
10
Output 1 :
10
Input 2 :
25
Output 2 :
5
 * 
 */

 import java.util.*;

 class PrimeFactorsProduct {
     public static void main(String args[]){
         int n = new Scanner(System.in).nextInt();
         int prod = 1;
         for(int i=2;i<n;i++){
             if(isPrime(i))
             if(n%i==0){
                 prod *= i;
             }
         }
         System.out.print(prod);
     }
     
     private static boolean isPrime(int n){
         for(int i=2;i*i<=n;i++){
             if(n%i==0)
             return false;
         }
         return true;
     }
 }