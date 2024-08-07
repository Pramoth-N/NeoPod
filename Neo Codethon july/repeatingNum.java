/*

    Sarath is given an unsorted array of integers, 
    where the array size is N and the elements in the array are integers in the range from 1 to N inclusive. 

    However, there is one number missing from this range and one number appears twice in the array. 

    Your task is to create a program to assist Sarath that identifies and prints both the missing and the repeating numbers from the array.

    Input format :
    The first line of input consists of an integer N, representing the size of the array.

    The second line consists of N space-separated integers representing the unsorted array elements.

    Output format :
    The first line of output prints the repeating number.

    The second line prints the missing number.



    Refer to the sample output for the exact text and format.

    Code constraints :
    1 ≤ N ≤ 20

    1 ≤ array elements ≤ 20

    Sample test cases :
    Input 1 :
    5
    1 2 3 4 1
    Output 1 :
    The repeating number is 1
    The missing number is 5
    Input 2 :
    8
    1 4 7 3 5 6 8 5
    Output 2 :
    The repeating number is 5
    The missing number is 2

*/
import java.util.*;

class RepeatingNum {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int nums[] = new int[n];
        int count[] = new int[n+1];
        for(int i=0;i<n;i++){
            nums[i] = sc.nextInt();
        }
        int dup = -1 , miss = -1;
        for(int num : nums){
            count[num]++;
        }
        for(int i=1;i<=n;i++){
            if(count[i] == 0){
                miss = i;
            } else if(count[i]==2) {
                dup = i;
            }
        }
        
        System.out.printf("The repeating number is %d",dup);
        System.out.printf("\nThe missing number is %d",miss);
    }
}