/*
 * 
 * Given that there are in meetings in the form of (start[i], and[1]), 
 * determine the maximum number of meetings that can be accommodated in a single meeting room. 
 * Only one meeting can be held in the meeting room at a particular time. 
 * The start time of one chosen meeting can't equal the end time of another. 
 * Input Format 
 *  The first line contains an integer s, representing the number of meetings. 
 *  The second line contains n, representing the start times of the meetings in a queue. 
 *  The third line contains n, representing the end times of the meetings in a queue. 
 * Output Format 
 *  Output the maximum number of meetings that can be held in the meeting room. 
 *  if n is a non-integer, output Invalid input. 
 *  if all the times are the same, output-1. 
 * Constraints Os start[i], and [1] $10000
 * 
 */

 import java.util.*;

class MettingRoom {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        if(!sc.hasNextInt()){
            System.out.println("Invalid input");
            return;
        }
        int n = sc.nextInt();
        int[] start = new int[n] , end = new int[n];
        boolean unique = true;
        for(int i=0;i<n;i++){
            start[i] = sc.nextInt();
        }
        for(int i=0;i<n;i++){
            end[i] = sc.nextInt();
        }
        
        for(int i=1;i<n;i++){
            if(start[i] != start[i-1] || end[i] != end[i-1]){
                unique = false;
                break;
            }
        }
        if(unique){
            System.out.println("-1");
            return;
        }
        int i=0,j=1, count = 1;
        for(;j<n;j++){
            if(end[i]<start[j]){
                ++count;
                i++;
            }
        }
        System.out.println(count);
    }
}