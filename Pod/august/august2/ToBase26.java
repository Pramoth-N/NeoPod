/*
 * 
 * 
 * Given a number, you need to convert it into a base-26 string representation, 
 * similar to sxeel column naming where numbers map to letters ('a' for 1, ..., '8' for 26, repeating). 
 * Implement two conversion methods: one for integers and one for floats, input the key type (1 for integer, 2 for float)
 *  and the number to convert 
 * Input Format 
 * The first line contains an sategae keyType. - 
 * If keyType is 1, the second line contains an sateger num to convert. 
 * If keyType is 2, the second line contains a leat num to convert. 
 * Output Format 
 * • The program outputs a single line containing the alphabetic representation of the number num. 
 * if input is other than 1 and 2, print Invalid input.
 *  Constraints 1 s IntNums 2147483647 1.0 ≤ floatNurn ≤ 100000.0
 * 
 * 
 */


 import java.util.*;

class ToBase26 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String ans = "";
        if(k==1){
            int n = sc.nextInt();
            StringBuilder sb = new StringBuilder();
            while(n > 0){
                int  rem = n % 26;
                sb.insert(0 , (char)('A' + rem - 1));
                n/=26;
            }
            System.out.println(sb);
            
        } else if( k == 2){
            float n = sc.nextFloat();
            int m = (int)n;
            StringBuilder sb = new StringBuilder();
            while( m> 0){
                int  rem = m % 26;
                sb.insert(0 , (char)('A' + rem - 1));
                m/=26;
            }
            System.out.println(sb);
        } else {
            System.out.println("Invalid input");
        }
    }
}