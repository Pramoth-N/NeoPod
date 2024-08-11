/*
 * 
 * Given a set of balls categorized by color: red, blue, and green. Formulate a method to count all possible arrangements where no two balls of the same color are adjacent. Implement the function to calculate the number of valid arrangements based on the input quantities of red, blue, and green balls.
Input Format
• The input consists of three integers: r, b, and g, representing the number of red, blue, and green balls respectively.
Output Format
• The output must be a single integer representing the total number of valid arrangements.
• If the input is invalid, print Invalid input.
Constraints
• -10 <= r, b, g <= 10.
Explanation
For the input 111, these arrangements (RGB, RBG, GRB, GBR, BRG, BGR) illustrate the different ways one red, one blue, and one green ball can be arranged without any two balls of the same color being adjacent.
 * 
 */


import java.util.*;

class BallColor {
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int r = sc.nextInt();
        int b = sc.nextInt();
        int g = sc.nextInt();
        
        if(r<0 || b<0 || g<0)
        {
            System.out.print("Invalid input");
            return ;
        }
        System.out.println(countValidArragements(r ,b ,g));
    }
    
    private static int countValidArragements(int r ,int b ,int g) {
        if(r==0 || b==0 || g==0)
        return 1;
        
        int count = 0;
        
        if(r>0){
            count +=countValidArragements(r-1 ,b ,g) * (b+g);
        }
        if(b>0){
            count +=countValidArragements(r ,b-1 ,g) * (r+g);
        }
        if(g>0){
            count +=countValidArragements(r ,b ,g-1) * (r+b);
        }
        return count;
    }
}