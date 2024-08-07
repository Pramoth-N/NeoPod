/*
 * 
 * 
 * Sandhya is a very intelligent programmer. She is given the task of arranging the given string in a twisted pattern. 

For example, consider the string APPLABXYJK with 3 rows, and the twisted pattern of the string will be formed as shown below:

After rearranging the given string in a twisted pattern, the new string has to be read line by line. So the output of the above string will be AAJPLBYKPX.

Help Sandhya write the code that will take a string and make this conversion using the given number of rows.

Input format :
The first line of input consists of the string, that has to be rearranged.

The second line consists of an integer N, representing the number of rows.

Output format :
The output prints the twisted string.

Code constraints :
The input string consists of lower-case and upper-case letters.

N = 3

Sample test cases :
Input 1 :
IamNeoIsHiring
3
Output 1 :
IeHnaNosiigmIr
Input 2 :
APPLABXYJK
3
Output 2 :
AAJPLBYKPX
 * 
 * 
 */

import java.util.*;
 class ZigZagConversion {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = sc.nextInt();
        System.out.println(convert(s , n));
    }

    private static  String convert(String s, int numRows) {
      StringBuilder sb = new StringBuilder();
      List<Character>[] rows = new List[numRows];
      int k = 0;
      int direction = numRows == 1 ? 0 : -1;
  
      for (int i = 0; i < numRows; ++i)
        rows[i] = new ArrayList<>();
  
      for (final char c : s.toCharArray()) {
        rows[k].add(c);
        if (k == 0 || k == numRows - 1)
          direction *= -1;
        k += direction;
      }
  
      for (List<Character> row : rows)
        for (final char c : row)
          sb.append(c);
  
      return sb.toString();
    }
  }