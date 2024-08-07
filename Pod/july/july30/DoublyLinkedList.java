/*
 * 
 * 
Tom is a software developer working on a project where he has to check if a doubly linked list is a palindrome. He needs to write a program to solve this problem. Write a program to help Tom check if a given doubly linked list is a palindrome or not.

Input format :
The first line consists of an integer N, representing the number of elements in the linked list.

The second line consists of N space-separated integers representing the linked list elements.

Output format :
The first line displays the space-separated integers, representing the doubly linked list.

The second line displays one of the following:

If the doubly linked list is a palindrome, print "The doubly linked list is a palindrome".

If the doubly linked list is not a palindrome, print "The doubly linked list is not a palindrome".

Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the test cases fall under the following constraints:

2 ≤ N ≤ 20

-50 ≤ elements ≤ 50

Sample test cases :
Input 1 :
5
1 2 3 2 1
Output 1 :
1 2 3 2 1 
The doubly linked list is a palindrome
Input 2 :
5
1 2 3 4 5
Output 2 :
1 2 3 4 5 
The doubly linked list is not a palindrome
Input 3 :
6
-1 -2 -3 -3 -2 -1
Output 3 :
-1 -2 -3 -3 -2 -1 
The doubly linked list is a palindrome
 * 
 * 
 */

// Java program to check if doubly
// linked list is palindrome or not

import java.util.Scanner;

class DoublyLinkedList
{

    static class Node
    {
        int key;
        Node next;
        Node prev;
        Node(int key ){
            this.key = key;
        }
    };


    static Node push(Node head, int key)
    {
        Node new_node = new Node(key);
        new_node.key = key;
        new_node.next = head;
        new_node.prev = null;
        if (head != null)
        head.prev = new_node ;
        head = new_node;
        return head;
    }

    static boolean isPalindrome(Node left)
    {
        if (left == null)
        return true;

        Node right = left;
        while (right.next != null)
            right = right.next;

        while (left != right)
        {
            if (left.key != right.key)
                return false;

            left = left.next;
            right = right.prev;
        }

        return true;
    }

    static void print(Node head){
        while(head != null){
            System.out.print(head.key + " ");
            head = head.next;
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Node head = null;
        while(n-- > 0){
            head = push(head , sc.nextInt());
        }
        print(head);
        if (isPalindrome(head))
        System.out.println("\nThe doubly linked list is a palindrome");
        else
        System.out.println("\nThe doubly linked list is not a palindrome");
            
    }
}