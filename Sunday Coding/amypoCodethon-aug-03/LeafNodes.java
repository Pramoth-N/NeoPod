import java.util.*;

class Node{
    int key;
    Node left , right;
    
    Node(int key){
        this.key = key;
        left = null;
        right = null;
    }
}

class BST {
    public Node root;
    public BST(){
        root = null;
    }
    public Node insert(Node root , int key){
        if(root == null){
            root = new Node(key);
            return root;
        }
        
        if(root.key > key){
            root.left = insert(root.left , key);
        }
        if(key > root.key){
            root.right = insert(root.right , key);
        }
        return root;
    }
    
    void leafNode(Node root) {
        if(root == null)
        return;
        if(root.left == null && root.right == null){
            System.out.print(root.key + " ");
        }
        leafNode(root.left);
        leafNode(root.right);
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<=0){
            System.out.print("Invalid input");
            return;
        }
        BST bst = new BST();
        for(int i=0;i<n;i++){
            bst.root = bst.insert(bst.root , sc.nextInt());
        }
        bst.leafNode(bst.root);
    }
}