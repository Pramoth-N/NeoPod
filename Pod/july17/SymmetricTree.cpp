#include <iostream>
#include <queue>
#include <vector>

using namespace std;

// Definition for a binary tree node
struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
};

// Function to build a binary tree from level order traversal representation
TreeNode* buildTree(vector<int>& nodes) {
    if (nodes.empty()) return nullptr;
    
    int index = 0;
    int n = nodes.size();
    
    TreeNode* root = new TreeNode(nodes[index++]);
    queue<TreeNode*> q;
    q.push(root);
    
    while (index < n && !q.empty()) {
        TreeNode* node = q.front();
        q.pop();
        
        // Left child
        if (index < n && nodes[index] != -1) {
            node->left = new TreeNode(nodes[index]);
            q.push(node->left);
        }
        index++;
        
        // Right child
        if (index < n && nodes[index] != -1) {
            node->right = new TreeNode(nodes[index]);
            q.push(node->right);
        }
        index++;
    }
    
    return root;
}

// Helper function to check if two trees are mirrors of each other
bool isMirror(TreeNode* leftSubtree, TreeNode* rightSubtree) {
    if (leftSubtree == nullptr && rightSubtree == nullptr)
        return true;
    
    if (leftSubtree == nullptr || rightSubtree == nullptr)
        return false;
    
    return isMirror(leftSubtree->left, rightSubtree->right) &&
           isMirror(leftSubtree->right, rightSubtree->left);
}

// Main function to determine if the binary tree is symmetric
bool isSymmetric(TreeNode* root) {
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
    TreeNode* root = buildTree(nodes);
    
    // Level order traversal
    queue<TreeNode*> q;
    q.push(root);
    vector<int> levelOrder;
    
    while (!q.empty()) {
        TreeNode* node = q.front();
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
    
    // Check if the tree is symmetric
    if (isSymmetric(root)) {
        cout << "The binary tree is symmetric" << endl;
    } else {
        cout << "The binary tree is not symmetric" << endl;
    }
    
    return 0;
}
