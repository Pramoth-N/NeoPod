/*
 Given a class GravitationalForce with private members mass1, mass2, and distance. 
 Implement a constructor to initialize these values and a public method to calculate and 
 print the gravitational force using the formula where a is the gravitational constant (approximately 6.67430). 
 Input Format 
 • The input consists of three floating-point numbers representing mass 1, mass 2, and distance. 
 Output Format 
 • Print the gravitational force between the two masses with six decimal places. 
 • If the input is negative, print Invalid input.
 */

 import java.util.*;

 class GravitationalField {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int k = sc.nextInt();
        
        int array[] = new int[n];
        for(int i=0;i<n;i++){
            array[i] = sc.nextInt();
        }
        Arrays.sort(array);
        System.out.println(array[k-1]);
    }
 }