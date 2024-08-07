/*
 * Given a Bitcoin legacy address, determine if the given address is valid or not. 
 * Bitcoin legacy addresses are strings that start with 1 or 3 followed by 25 to 34 alphanumeric characters (excluding 0, o, I,l ). 
 * Input Format 
 * • The input contains a string representing the Bitcoin address.
 * Output Format 
 * •Print "Legacy" if the address matches the legacy address pattern. 
 * Print "Invalid input" if the address does not match either pattern. Constraints 
 * • Input can be a printable ASCII Characters.
 */

 import java.util.Scanner;

class BitcoinLegacy{
    public static void main(String args[]) {
        String address = new Scanner(System.in).nextLine();
        
        int len = address.length();
        if(len < 25 || len > 34 ||(address.charAt(0) !='1' && address.charAt(0) != '3')) {
            System.out.println("Invalid input");
            return;
        }
        
        for(char c : address.toCharArray()) {
            if(c == '0' || c == 'o' || c == 'I' || c == 'l'){
                System.out.println("Invalid input");
                return;
            }
        }
        
        System.out.println("Legacy");
    }
}