/*
 * 
 * You are tasked with implementing a circular queue to manage a list of integers. Your circular queue should support the following operations:



Insert an element: Add a new integer to the queue.
Delete an element: Remove an integer from the front of the queue.
Display the queue: Print all the elements in the queue in their current order.


Note: The queue can hold up to MAX = 10 elements.

Input format :
The input consists of an integer choice which determines the operation to be performed:



1: Insert an element into the queue, If the choice is 1, followed by an integer item which is the element to be inserted, separated by a space.

2: Delete an element from the queue.

3: Display the elements in the queue.

4: Exit the program.

Output format :
The output displays the following format:

For Insert Operation choice 1: If the queue is full, print "Queue Overflow". Otherwise, no output is generated for the insert operation.

For Delete Operation choice 2: If the queue is empty, print "Queue Underflow". Otherwise, print "Element deleted from queue is: X" where X is the integer that was removed from the queue.

For Display Operation choice 3: Print "Queue elements:" followed by the integers in the queue from front to rear.

If the queue is empty, print "Queue is empty".



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the given test cases will fall under the following constraints:

The queue has a maximum capacity of 10 elements.

The queue operations should be performed in a circular manner.

The operations will be continuous until the exit choice (4) is selected.

Sample test cases :
Input 1 :
1 11
1 22
1 33
2
1 44
1 55
3
4
Output 1 :
Element deleted from queue is: 11
Queue elements:
22 33 44 55 
Input 2 :
2
4
Output 2 :
Queue Underflow
Input 3 :
-1
4
Output 3 :
Wrong choice
Input 4 :
1 22
1 33
1 44
1 55
1 66
1 77
1 88
1 99
1 100
1 111
1 122
4
Output 4 :
Queue Overflow
Input 5 :
3
4
Output 5 :
Queue is empty
 * 
 */


 import java.util.*;

class QueueDeleteion {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Queue<Integer> q= new LinkedList<>();
        int cnt =0;
        while(true){
            int t = sc.nextInt();
            if(t==1){
                int n = sc.nextInt();
                if(cnt++ == 10){
                    
                    System.out.println("Queue Overflow");
                    return;
                }
                if(!q.offer(n)){
                    System.out.println("Queue Overflow");
                    return;
                } 
            }
            else if(t==2){
                if(q.size()!=0){
                    System.out.println("Element deleted from queue is: " + q.remove());
                }
                else {
                    System.out.println("Queue Underflow");
                }
            } else if(t==3){
                if(q.size()==0){
                    System.out.println("Queue is empty");
                    continue;
                }
                System.out.println("Queue elements:");
                for(int x : q){
                    System.out.print( x + " ");
                }
            } else if(t==4){
                break;
            } else {
                System.out.println("Wrong choice");
            }
        }
    }
}