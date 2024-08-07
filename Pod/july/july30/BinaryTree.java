/*
 * 
 * 
Amir needs a program to construct a binary tree from user-provided input and analyze it. The program takes the number of nodes and their values as input, constructs the binary tree, performs a pre-order traversal, and computes the sum of all node values encountered during traversal.

Input format :
The first line of input consists of an integer n, representing the number of nodes in the binary tree.

The second line consists of n space-separated integers, representing the values of the nodes in the binary tree.

Output format :
The first line of output prints "Preorder Traversal: " followed by the pre-order traversal of the constructed binary tree.

The second line prints "Sum: " followed by the sum of all node values in the binary tree.



Refer to the sample output for formatting specifications.

Code constraints :
1 ≤ n ≤ 15

1 ≤ node values ≤ 150

Sample test cases :
Input 1 :
4
15 62 34 27
Output 1 :
Preorder Traversal: 15 62 27 34 
Sum: 138
Input 2 :
6
9 5 3 7 1 2
Output 2 :
Preorder Traversal: 9 5 7 1 3 2 
Sum: 27
 * 
 * 
 */

 import java.util.*;

class Node {
    int key;
    Node left , right;
    Node(int key) {
        this.key = key;
        left = right = null;
    }
}

class BinaryTree {
    public Node insert(Node root , int num){
        if(root == null){
            root = new Node(num);
            return root;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            if(temp.left ==  null){
                temp.left = new Node(num);
                break;
            } else {
                q.add(temp.left);
            }
            if(temp.right == null){
                temp.right = new Node(num);
                break;
            } else {
                q.add(temp.right);
            }
            
        }
        
        return root;
    }
    public int  print(Node root){
        if(root == null)
        return 0;
        System.out.print(root.key + " ");
        int left = print(root.left);
        int right = print(root.right);
        
        return left + right + root.key;
    }
}
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        BinaryTree bt = new BinaryTree();
        Node root = null;
        while(n-- > 0){
            root = bt.insert(root , sc.nextInt());
        }
        
        System.out.print("Preorder Traversal: ");
        int sum = bt.print(root);
        System.out.print("\nSum: "+ sum);
    }
}