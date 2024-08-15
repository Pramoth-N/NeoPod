/*
 * 
    Arsh is tasked to sort an array of strings in lexicographical order.



He has to write a program that takes a list of strings as input and sorts them using the bubble sort algorithm. The sorted list should then be displayed.

Input format :
The first line contains an integer n, representing the number of strings.

The second line contains a string with a maximum length of 100 characters.

Output format :
The output displays the list of sorted words separated by space in a single line.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ n ≤ 10

3 < Length of characters in a word <100.

Sample test cases :
Input 1 :
4
apple orange banana pine
Output 1 :
apple banana orange pine 
 * 
 */


 import java.util.Scanner;

public class BubbleSortStrings {

    private static void bubbleSort(String[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    String temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt();
        scanner.nextLine();
        
        String line = scanner.nextLine();
        String[] words = line.split(" ");
        bubbleSort(words);
        
        System.out.println(String.join(" ", words));
    }
}
