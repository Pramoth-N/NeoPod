/*
 * 
 * 
    * You are given a 2D array of integers envelopes where envelopes[i] = [wi, hi] represent the width and the height of an envelope.

    One envelope can fit into another if and only if both the width and height of one envelope are greater than the other envelope's width and height.

    Return the maximum number of envelopes you can Russian doll (i.e., put one inside the other).

    Note: You cannot rotate the envelopes.

    Example

    Input: 

    envelopes = [[5,4],[6,4],[6,7],[2,3]]

    Output:

    3

    Explanation: 

    The maximum number of envelopes that can be nested inside each other is 3 ([2,3] => [5,4] => [6,7]).

    Input format :
    The first line of input consists of an integer N, representing the number of envelopes.

    The next N lines of input consist of two integers wi and hi, representing the width and height of N envelopes.

    Output format :
    The output prints the maximum number of envelopes that can be nested inside each other.

    ﻿Refer to the sample output for formatting specifications.

    Code constraints :
    1 ≤ N ≤ 20

    1 ≤ wi, hi ≤ 20

    Sample test cases :
    Input 1 :
    3
    1 1
    1 1
    1 1
    Output 1 :
    1
    Input 2 :
    4
    5 4
    6 4
    6 7
    2 3
    Output 2 :
    3
 * 
 * 
 */

 import java.util.*;

public class Envelope {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> envelopes = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            envelopes.add(new int[]{scanner.nextInt(), scanner.nextInt()});
        }
        System.out.println(maxEnvelopes(envelopes));
    }

    public static int maxEnvelopes(List<int[]> envelopes) {
        if (envelopes.isEmpty()) {
            return 0;
        }
        Collections.sort(envelopes, (a, b) -> a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        int[] dp = new int[envelopes.size()];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < envelopes.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (envelopes.get(i)[0] > envelopes.get(j)[0] && envelopes.get(i)[1] > envelopes.get(j)[1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}