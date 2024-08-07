/*

    Given an array arr[] of size n and a positive integer k. 
    Consider the series of natural numbers and remove the given array elements from it. 
    Now the task is to find kth smallest number in the remaining set of natural numbers. 

    Examples
    Input: 

    k = 1 and arr[] = {1}

    Output: 

    2

    Explanation:

    Natural numbers are {1, 2, 3, 4, ...}

    After removing {1}, we get {2, 3, 4, ...}

    Now, 1st smallest element = 2.

    Input: 

    k = 4 and arr[] = {1, 3}

    Output: 

    6

    Explanation:

    Natural numbers are {1, 2, 3, 4, 5, 6, 7, ...}

    After removing {1, 3}, we get {2, 4, 5, 6, 7, ...}

    Now, 4th smallest element = 6.

    Input format :
    The first line of input consists of an integer k, representing the kth smallest element to be found.

    The second line consists of an integer n, the number of elements in the array to remove.

    The third line consists of n space-separated integers, representing the array elements to be removed.

    Output format :
    The output should print a single integer representing the kth smallest element from the array.

    Refer to the sample output for formatting specifications.

    Code constraints :
    1 ≤ k, n ≤ 10

    1 ≤ array elements ≤ 100

    Sample test cases :
    Input 1 :
    1
    1
    1
    Output 1 :
    2
    Input 2 :
    4
    2
    1 3
    Output 2 :
    6
    Input 3 :
    3
    5
    2 4 6 8 10
    Output 3 :
    5

*/

import java.util.*;
class KthElement {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        arr[i] = sc.nextInt();
        int j=0,t=k;
        for(int i=1;i<=n+k;i++){
            if(j<n && i==arr[j]){
                j++;
                continue;
            }
            t--;
            if(t==0){
                System.out.print(i);
                return ;
            }
        }
    }
}