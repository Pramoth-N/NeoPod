/*
 * 
 * You are given two sorted arrays a[] and b[], with sizes N and M respectively. The task is to find the median of the combined sorted array formed by merging these two arrays. The median is the middle element if the total number of elements is odd, or the average of the two middle elements if the total number of elements is even.



Example1

Input

5

-5 3 6 12 15

6

-12 -10 -6 -3 4 10

Output

3

Explanation

﻿The merged array is arr3[] = {-12, -10, -6, -5, -3, 3, 4, 6, 10, 12, 15}. So the median of the merged array is 3.



Example

Input

4

2 3 4 8

6

10 12 14 16 18 20

Output

11

Explanation

The merged array is arr3[] = {2, 3, 5, 8, 10, 12, 14, 16, 18, 20}. The total number of elements is even, so there are two middle elements.

Take the average between the two: (10 + 12) / 2 = 11

Input format :
The first line contains an integer N, the number of elements in the first array.

The second line contains N space-separated integers representing the elements of the first array.

The third line contains an integer M, the number of elements in the second array.

The fourth line contains M space-separated integers representing the elements of the second array.

Output format :
The output displays the median of the combined sorted array.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ N,M ≤ 10

-15 ≤ array elements ≤ 50

Sample test cases :
Input 1 :
5
-5 3 6 12 15
6
-12 -10 -6 -3 4 10
Output 1 :
3
Input 2 :
4
2 3 4 8
6
10 12 14 16 18 20
Output 2 :
11
 * 
 */

 import java.util.*;
class Solution {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        List<Integer> nums = new ArrayList<>();
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            nums.add(sc.nextInt());
        }
        n = sc.nextInt();
        for(int i=0;i<n;i++){
            nums.add(sc.nextInt());
        }
        Collections.sort(nums);
        n = nums.size();
        if(n%2==1){
            System.out.println(nums.get(n/2));
        } else {
            System.out.println((nums.get(n/2-1) + nums.get(n/2)) / 2);
        }
    }
}