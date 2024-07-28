/*
You are given a string a containing both digits and non-digit characters. 
Your task is to reverse the order of digits in the string while keeping the non-digit characters in their original positions. 
If digits are present, return the modified string with the digits reversed. 
Input Format 
• A single line containing a string which may contain alphabets, digits, and special characters. 
Output Format 
• Output the modified string with digits reversed 
• Print No integer character, if no digits are found in the string.
 */

import java.util.*;;

public class ReverseDigitsInString {

    public static void main(String[] args) {
        String input = "a1b2c3d4"; // Example input, you can replace it with any other string
        String result = reverseDigits(input);
        System.out.println(result);
    }

    public static String reverseDigits(String s) {
        // Extract digits from the string
        StringBuilder digits = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            }
        }

        // If no digits found, return the message
        if (digits.length() == 0) {
            return "No integer character";
        }

        // Reverse the digits
        digits.reverse();

        // Rebuild the string with reversed digits in place
        StringBuilder result = new StringBuilder();
        int digitIndex = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                result.append(digits.charAt(digitIndex++));
            } else {
                result.append(c);
            }
        }

        return result.toString();
    }
}
