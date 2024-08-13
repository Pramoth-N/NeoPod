
/*
 * 
 * Abdul is tasked with managing a catalog of plants in his garden. 
Each plant is Identified by a unique numerical code Abdul needs a program that allows him to efficiently add new plants to the catalog and 
maintain the catalog in a balanced structure to facilitate quick retrieval of plant information 
He seeks a solution that enables him to input the numerical codes of plants automatically balances the catalog using an AVL tree, 
and displays the catalog in a pre-order traversal 
Input format: 
      The first line consists of an integer n, denoting the number of plants in Abdul's garden 
      The second line consists of n space-separated integers representing the unique numerical codes of the plants. 
Output format: 
      The output displays a single line containing integers, representing the numerical codes of the plants in the catalog, 
arranged in the pre-order traversal of the constructed AVL tree, separated by a space.
 * 
 */


 import java.util.Scanner;

// Define the AVL Tree Node
class AVLNode {
    int key;
    AVLNode left, right;
    int height;

    public AVLNode(int item) {
        key = item;
        left = right = null;
        height = 1;
    }
}

// AVL Tree Class
class AVLTree {
    private AVLNode root;

    // Get the height of a node
    private int height(AVLNode N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Get the balance factor of a node
    private int getBalance(AVLNode N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Right rotate subtree rooted with y
    private AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    private AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert a key in the subtree rooted with node
    public AVLNode insert(AVLNode node, int key) {
        // 1. Perform the normal BST insert
        if (node == null)
            return new AVLNode(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else
            return node; // Duplicate keys are not allowed in the AVL tree

        // 2. Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // 3. Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Pre-order traversal of the AVL tree
    public void preOrder(AVLNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Public method to start insertion
    public void insert(int key) {
        root = insert(root, key);
    }

    // Public method to start pre-order traversal
    public void preOrder() {
        preOrder(root);
        System.out.println();
    }
}

// Main class to run the AVL Tree operations
public class AVLTreeDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of plants
        int n = scanner.nextInt();
        // Read the plant codes
        int[] plantCodes = new int[n];
        for (int i = 0; i < n; i++) {
            plantCodes[i] = scanner.nextInt();
        }

        // Create AVL tree and insert codes
        AVLTree tree = new AVLTree();
        for (int code : plantCodes) {
            tree.insert(code);
        }

        // Output pre-order traversal
        tree.preOrder();

        scanner.close();
    }
}
