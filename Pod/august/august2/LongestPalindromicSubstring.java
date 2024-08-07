/*
 * 
 * 
 * Given the word Implement a function to allocate memory for a dynamic 2D character array using malloc, 
 * read a matrix of characters from input, and implement a function to find the longest palindromic substring in any row of the matrix. 
 * Your function should output the position (row Index and starting column index) of the longest palindromic substring. 
 * Input Format 
 * • The first line contains two integers rand c, representing the number of rows and columns of the matrix, respectively. 
 * • The next r lines contain c characters, representing the elements of the matrix. 
 * Output Format 
 * Output the longest palindromic substring position found in the 2D character array (row and starting column). 
 * • If no palindromic substring is found, output Me palindromic substring. 
 * • If the input or dimensions are invalid, output Invalid Input.
 *  Constraints 
 * 1sr, c≤ 10 
 * • Time Complexity: O(r*c^2) 
 * • Space Complexity: 0(1)
 * 
 * 
 */


import java.util.*;

class LongestPalindromicSubstring{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        if(n<=0 ||m<=0 || n>10 || m>10){
            System.out.print("Invalid Input");
            return;
        }
        char[][] words = new char[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++) {
                words[i][j] = sc.next().charAt(0);
            }
        }
        int i =0 , row = -1 , len = 0;
        boolean pal = true;
        for(i =0;i<words.length;i++){
            int length = longestPal(words[i]);
            if(length > 1){
                pal = false;
            }
            if(length > len){
                len = length;
                row = i;
            }
            
        }
        if(pal){
            System.out.print("No palindromic substring");
            return;
        }
            System.out.print(row + " ");
            System.out.print(startIndex(words[row]));
    }
    
    private static int startIndex(char[] word) {
        int cnt =0 , index = -1;
        for(int i=0;i<word.length;i++){
            for(int j=i;j<word.length;j++){
                if(isPal(word,i,j)){
                    if(j-i+1 > cnt){
                        cnt = j-i+1;
                        index = i;
                    }
                }
            }
        }
        return index;
    }
    private static int longestPal(char[] word){
        int cnt =0;
        for(int i=0;i<word.length;i++){
            for(int j=i;j<word.length;j++){
                if(isPal(word,i,j))
                cnt = Math.max(cnt , j-i+1);
            }
        }
        return cnt;
    }
    private static boolean isPal(char[] word , int i , int j){
        while(i < j){
            if(word[i++] != word[j--]){
                return false;
            }
        }
        return true;
    }
}