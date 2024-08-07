/*

    In a local election, each candidate is assigned a unique numeric ID. 
    After collecting the votes, you need to determine if any candidate received more than n−2 votes, 
    where n is the total number of votes cast. This will help in identifying if there is a clear winner with significant support.

    Your task is to write a program that determines if there is a candidate ID that received more than n−2 votes. 
    If such a candidate exists, return their ID. Otherwise, return "No majority candidate found."

    Input format :
    The first line contains an integer n — the total number of votes cast.

    The second line contains n space-separated integers, each representing the candidate ID for each vote.

    Output format :
    The output displays the following format:

    If a candidate received more than n−2 votes, output their ID.

    If no candidate meets this criterion, output "No majority candidate found."

    Refer to the sample output for formatting specifications.

    Code constraints :
    1 ≤ n ≤ 10

    1 ≤ candidate ID ≤ 100

    Sample test cases :
    Input 1 :
    5
    1 4 1 1 1
    Output 1 :
    1
    Input 2 :
    8
    12 12 12 12 13 12 12 12
    Output 2 :
    12
    Input 3 :
    5
    56 58 45 54 55
    Output 3 :
    No majority candidate found.


*/
import java.util.*;

class Election {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] votes = new int[n];
        for(int i=0;i<n;i++){
            votes[i] = sc.nextInt();
        }
        Arrays.sort(votes);
        int v = votes[0] , cnt = 0;
        for(int vote : votes){
            if(v == vote){
                cnt++;
                if(cnt > n-2){
                    System.out.print(v);
                    return;
                }
            } else {
                v = vote;
                cnt = 1;
            }
        }
        System.out.print("No majority candidate found.");
    }
}