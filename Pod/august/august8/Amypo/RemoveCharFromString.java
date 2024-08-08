/*
 * 
 * 
 * Given a string atz and an integer x, remove all characters from the string that appear exactly a times. 
 * 
 * Input Format 
 *  The first line of the input contains a string atz. 
 *  • An integer & represents the number of times a letter occurs and needs to be removed. 
 * 
 * Output Format 
 *  Displays the string with all characters appearing exactly a times removed. 
 *  •Print Invalid input, if any numerical inputs present in string 
 *  Print-1, if there is no character presents k times. 
 * Constraints 
 *  1<= str.length <= 1000 
 *  1<= k <=4
 * 
 * 
 */

import java.util.*;

class RemoveCharFromString {
    public static void main(String args[]){
        Scanner scan = new Scanner(System.in);
        String s = scan.next();
        int k = scan.nextInt();
        
        Map<Character,Integer> count = new HashMap<>();
        
        for(char c : s.toCharArray()){
            if(Character.isDigit(c)){
                System.out.println("Invalid input");
                return;
            }
            count.put(c,count.getOrDefault(c,0) + 1);
        }
        
        StringBuilder result = new StringBuilder();
        
        boolean flag = false;
        for(char c : s.toCharArray()){
            if(count.get(c) != k) {
                result.append(c);
            } else {
                flag = true;
            }
        }
        if(!flag){
            System.out.println("-1");
        } else {
            System.out.println(result);
        }
    }
}