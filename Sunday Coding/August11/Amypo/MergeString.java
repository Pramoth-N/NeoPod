/*
 * 
 * Given two strings wordi and wozda, merge them by adding letters in alternating order, starting with werdi. 
 * If a string is longer than the other, append the additional letters to the end of the merged string. 
 * Input Format 
 *  The first line contains the first string wordi. 
 *  The second line contains the second string word2. 
 * Output Format 
 *  Print the merged string starting with werdi and continue with werd2. 
 *  Print Invalid input, if either word of word is not an Alphabet. 
 * Constraints 
 *  1s wordl,word2s 100 
 *  The input string will contain only printable ASCII characters.
 * 
 */


import java.util.*;

class MergeStrings {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        
        int l1 = s1.length() , l2 = s2.length() ,i=0,j=0;
        StringBuilder sb = new StringBuilder();
        
        while(i<l1 && j<l2){
            if(!Character.isAlphabetic(s1.charAt(i)) || !Character.isAlphabetic(s2.charAt(j))){
                System.out.println("Invalid input");
                return;
            }
            sb.append(s1.charAt(i++));
            sb.append(s2.charAt(j++));
        }
        
        if(i<l1){
            sb.append(s1.substring(i));
        }
        if(j<l2){
            sb.append(s2.substring(j));
        }
        System.out.println(sb);
    }
}