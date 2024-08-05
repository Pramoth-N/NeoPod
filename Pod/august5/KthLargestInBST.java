/*
 * 
 * 
 * You are preparing for a technical interview with a well-known tech company. During a mock interview, you are presented with a coding challenge related to Binary Search Trees (BSTs). 

The challenge is to write a program that finds the kth largest element in a BST, and you are required to implement an efficient solution. 



Your task is to complete the code and ensure that it correctly identifies the kth largest element in the given input tree.

Input format :
The first line of input consists of a sequence of integers representing the elements of the BST. The input is terminated by -1.

The second line consists of an integer k, representing the position of the desired largest element.

Output format :
The output prints a single integer, which is the kth largest element in the BST.



Refer to the sample output for the formatting specifications.

Code constraints :
1 ≤ Number of nodes in the BST ≤ 50

1 ≤ Values of nodes in the BST ≤ 150

1 ≤ k ≤ Number of nodes in the BST

Sample test cases :
Input 1 :
10 5 20 3 7 15 25 -1
2
Output 1 :
20
Input 2 :
45 30 60 20 35 55 70 15 25 40 50 58 65 75 -1
11
Output 2 :
30
 * 
 * 
 */


 import java.util.*;
class Node {
    int key;
    Node left , right;
    Node(int key){
        this.key = key;
        left = right = null;
    }
}
class BST{
    Node root ;
    public BST(){
        root = null;
    }
    void insert(int key){
        root = push(root , key);
    }
    
    Node push(Node root , int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        if(key < root.key){
            root.left = push(root.left , key);
        }
        if(key > root.key){
            root.right = push(root.right , key);
        }
        
        return root;
    }
    
    int findKthLargest(int k){
        Node cur = root;
        Node klarge = null;
        
        int cnt = 0;
        
        while(cur != null){
            if(cur.right == null){
                if(++cnt == k){
                    klarge = cur;
                }
                    cur = cur.left;
            } else {
                Node rev = cur.right;
                while(rev.left != null && rev.left != cur)
                    rev = rev.left;
                if(rev.left == null){
                    rev.left = cur;
                    cur = cur.right;
                } else {
                    rev.left = null;
                    
                    if(++cnt == k)
                        klarge = cur;
                    
                    cur = cur.left;
                }
            }
        }
        return klarge.key;
    }
}

class KthLargestInBST {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        BST bst = new BST();
        
        int k;
        while((k=sc.nextInt()) != -1){
            bst.insert(k);
        }
        k= sc.nextInt();
        
        System.out.print(bst.findKthLargest(k));
    }
}