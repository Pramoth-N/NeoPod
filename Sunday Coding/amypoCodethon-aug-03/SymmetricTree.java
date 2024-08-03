import java.util.*;

class Node{
    int key;
    Node left , right;
    Node(){
        left = right = null;
    }
    Node(int key){
        if(key != -1)
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
    public void insert(int key){
        if(root == null){
            root = new Node(key);
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        
        while(!q.isEmpty()){
            Node temp = q.peek();
            q.remove();
            if(temp.left == null) {
                temp.left = new Node(key);
                break;
            } else {
                q.add(temp.left);
            }
            if(temp.right == null) {
                temp.right = new Node(key);
                break;
            } else {
                q.add(temp.right);
            }
        }
    }
    public boolean isSymmetric() {
        return root == null || isMirror(root.left , root.right);
    }
    
    private boolean isMirror(Node left , Node right){
        if(left == null && right == null )
        return true;
        if(left == null || right == null )
        return false;
        
        return isMirror(left.right , right.left) && isMirror(left.left , right.right);
    }
}

class Solution {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        BST bst = new BST();
        try{
        while(true){
            int k = sc.nextInt();
            if(k==-2){
                break;
            }
            bst.insert(k);
        }
        }catch(Exception ex){
            System.out.print("Invalid input");
            return;
        }
        if(bst.isSymmetric()){
            System.out.print("The tree is symmetric");
        } else {
            System.out.print("The tree is not symmetric");
        }
    }
}