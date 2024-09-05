/*
 * 
 * You are given a sentence where each word contains an embedded number (from 0
 * to 9) that indicates the position of that word in the final sorted sentence.
 * Your task is to reconstruct and sort the sentence based on these embedded
 * numbers. Each number represents the index of the word in the sorted sentence,
 * starting from 0. Input format A single line containing a sentence with words,
 * where each word includes a single digit (0-9) indicating its position in the
 * final sorted sentence. Output format A single line containing the
 * reconstructed and sorted sentence based on the embedded numbers. •Print
 * Invalid input, if more than one word contains same integers. Constraints The
 * sentence will only contain words separated by single spaces. Each word will
 * have exactly one embedded digit (0-9). -1<= Length of string <= 100 There
 * will be no duplicate positions in the sentence.
 * 
 */

 import java.util.*;

class SortWords{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String sentence = sc.nextLine();
        String[] s = sentence.split(" ");
        
        String[] words = new String[s.length];
        boolean[] v = new boolean[s.length];
        for(String x : s){
            StringBuilder sb = new StringBuilder();
            int index =-1;
            for(char c : x.toCharArray()){
                if(Character.isDigit(c)){
                    index = c-'0';
                } else {
                    sb.append(c);
                }
            }
                if(index == -1 || v[index]){
                    System.out.println("Invalid input");
                    return;
                }
                v[index] = true;
                words[index] = sb.toString();
        }
        
        for(String word : words){
            System.out.print(word + " ");
        }
    }
}