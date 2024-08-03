/*
 * 
 * 
 * Implement a function to determines loan eligibility based on a person's credit score and income. 
 * 
 * Input Format 
 * • The first line contains creditscore, representing the person's credit score. 
 * • The second line contains income, representing the person's annual income. 
 * 
 * Output Format 
 * • The first line print approved if the creditScore is 700 or above, and the income is 50,000 or more. 
 * Print "Rejected" otherwise. • The second line prints the approved amount, 
 * The approved loan amount should be calculated as 50% of the annual income with two decimal point. 
 * 
 * Constraints 
 * • 300 <= creditScore <= 850 
 * • 0 <= income <= 1,000,000
 * 
 * 
 */


 
import java.util.*;
class CreditScore {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        double crd = sc.nextDouble();
        double income = sc.nextDouble();
        if(crd >=700 && income >= 50000){
            System.out.println("Approved");
            System.out.printf("%.2f",income/2);
        } else{
            System.out.println("Rejected");
        }
    }
}