/*

  Problem Statement 
  In a company's customer service center, each customer interaction is logged with a unique numerical ID. 
  A customer support representative needs to search through these logs to find the position of a specific customer interaction ID 
  and also analyze the overall interaction data. 
  Implement a tool to search for a specific customer interaction ID in a log of interaction IDs, 
  determine its position if it exists, and report the total number of comparisons made during the search. 
  Additionally, calculate and display the total number of interactions and the average number of interactions per ID. 
  
  Input format: 
  The first line contains an integer n, representing the number of customer interactions recorded. 
  The second line contains n integers, each representing the unique interaction ID recorded, 
  The third line contains an integer x, representing the interaction ID to be searched. 
  
  Output format:  
  The output displays the following format:  
  Answered Bookmarked Print an integer the position (0-based index) of the interaction ID x if found. 
  If not found, print a message stating that the interaction ID x is not present. 
  Print an integer the total number of comparisons made during the search process, prefixed by "Total comparisons made: ".
 Print an integer the total sum of all interaction IDs, prefixed by "Sum of all interaction:".
 Print double value the average of all interaction IDs, prefixed by "Average of all interaction:".
 
 
 */
import java.util.*;

class SearchID {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(),sum=0;
        int arr[] = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
            sum+=arr[i];
        }
        int key = sc.nextInt();
        sc.close();
        int index = search(arr,key);
        if(index == -1) {
        System.out.println("Interaction ID " + key + " is not present");
        System.out.println("Total comparisons made: " + n);
        } else {
        System.out.println("Interaction ID " + key + " is present at index " + index);
        System.out.println("Total comparisons made: " + (index+1));
        }
        System.out.println("Sum of all interaction: " + sum);
        System.out.printf("Average of all interaction: %.2f" , (double)(sum/(double)n));
        
    }
    
    private static int search(int nums[] , int key) {
        for(int i=0;i<nums.length;i++) {
            if(nums[i] == key)
            return i;
        }
        return -1;
    }
}