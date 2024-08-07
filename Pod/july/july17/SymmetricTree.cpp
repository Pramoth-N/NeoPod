#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// Definition for a binary tree node
struct Node {
    int val;
    Node *left;
    Node *right;
    Node(int x) : val(x) {}
};

// Function to build a binary tree from level order traversal representation

Node* buildTree(vector<int>& nodes) {
    if (nodes.empty()) return nullptr;
    
    int index = 0;
    int n = nodes.size();
    
    Node* root = new Node(nodes[index++]);
    queue<Node*> q;
    q.push(root);
    
    while (index < n && !q.empty()) {
        Node* node = q.front();
        q.pop();
        
        // Left child
        if (index < n && nodes[index] != -1) {
            node->left = new Node(nodes[index]);
            q.push(node->left);
        }
        index++;
        
        // Right child
        if (index < n && nodes[index] != -1) {
            node->right = new Node(nodes[index]);
            q.push(node->right);
        }
        index++;
    }
    
    return root;
}

// Helper function to check if two trees are mirrors of each other
bool isMirror(Node* leftSubtree, Node* rightSubtree) {
    if (leftSubtree == nullptr && rightSubtree == nullptr)
        return true;
    
    if (leftSubtree == nullptr || rightSubtree == nullptr)
        return false;
    
    return isMirror(leftSubtree->left, rightSubtree->right) &&
           isMirror(leftSubtree->right, rightSubtree->left);
}

// Main function to determine if the binary tree is symmetric
bool isSymmetric(Node* root) {
    if (root == nullptr)
        return true;
    
    return isMirror(root->left, root->right);
}

int main() {
    int n;
    cin >> n;
    
    vector<int> nodes(n);
    for (int i = 0; i < n; ++i) {
        cin >> nodes[i];
    }
    
    // Build the binary tree
    Node* root = buildTree(nodes);

    // Check if the tree is symmetric
    if (isSymmetric(root)) {
        cout << "The binary tree is symmetric" << endl;
    } else {
        cout << "The binary tree is not symmetric" << endl;
    }
    
    // Level order traversal
    queue<Node*> q;
    q.push(root);
    vector<int> levelOrder;
    
    while (!q.empty()) {
        Node* node = q.front();
        q.pop();
        
        if (node == nullptr) {
            continue;
        }
        
        levelOrder.push_back(node->val);
        q.push(node->left);
        q.push(node->right);
    }
    
    // Output level order traversal
    for (int val : levelOrder) {
        cout << val << " ";
    }
    cout << endl;
    
    
    return 0;
}
