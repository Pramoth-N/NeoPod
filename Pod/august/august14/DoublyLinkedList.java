/*
 * 
 * Vanessa is learning about the doubly linked list data structure and is eager to play around with it. She decides to find out how the elements are inserted in the beginning and end of the list.



Help her implement a program for the same.

Input format :
The first line of input contains an integer N, representing the size of the doubly linked list.

The next line contains N space-separated integers, each representing the values to be inserted into the doubly linked list.

Output format :
The first line of output prints the integers, after inserting at the beginning, separated by space.

The second line prints the integers, after inserting at the end, separated by space.



Refer to the sample output for formatting specifications.

Code constraints :
The given test cases fall under the following constraints:

1 ≤ N ≤ 10

1 ≤ elements ≤ 1000

Sample test cases :
Input 1 :
5
1 2 3 4 5
Output 1 :
5 4 3 2 1 
1 2 3 4 5 
Input 2 :
6
78 63 25 94 16 15
Output 2 :
15 16 94 25 63 78 
78 63 25 94 16 15 
 * 
 */

 import java.util.Scanner;

 public class DoublyLinkedList {
     
     // Node class for doubly linked list
     static class Node {
         int data;
         Node next;
         Node prev;
         
         Node(int data) {
             this.data = data;
             this.next = null;
             this.prev = null;
         }
     }
     
     // Doubly Linked List class
     static class DoublyLinkedListOperations {
         Node head;
         Node tail;
         
         // Insert node at the beginning
         void insertAtBeginning(int data) {
             Node newNode = new Node(data);
             if (head == null) {
                 head = tail = newNode;
             } else {
                 newNode.next = head;
                 head.prev = newNode;
                 head = newNode;
             }
         }
         
         // Insert node at the end
         void insertAtEnd(int data) {
             Node newNode = new Node(data);
             if (tail == null) {
                 head = tail = newNode;
             } else {
                 tail.next = newNode;
                 newNode.prev = tail;
                 tail = newNode;
             }
         }
         
         // Print list from beginning
         void printFromBeginning() {
             Node temp = head;
             while (temp != null) {
                 System.out.print(temp.data + " ");
                 temp = temp.next;
             }
             System.out.println();
         }
         
         // Print list from end
         void printFromEnd() {
             Node temp = tail;
             while (temp != null) {
                 System.out.print(temp.data + " ");
                 temp = temp.prev;
             }
             System.out.println();
         }
     }
     
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         
         int N = scanner.nextInt();
         int[] elements = new int[N];
         
         for (int i = 0; i < N; i++) {
             elements[i] = scanner.nextInt();
         }
         
         DoublyLinkedListOperations dll = new DoublyLinkedListOperations();
         
         // Insert elements at the beginning
         for (int i = 0; i < N; i++) {
             dll.insertAtBeginning(elements[i]);
         }
         dll.printFromBeginning();
         
         dll.printFromEnd();
         
         scanner.close();
     }
 }
 