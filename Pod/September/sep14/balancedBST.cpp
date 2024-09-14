#include<bits/stdc++.h>
using namespace std;

struct node{
    int key;
    node *left , *right;
    node(int key) : key(key){}
};
void insert(node* &root , int key){
    if(root == nullptr){
        root = new node(key);
        return;
    }
    if(root->key > key){
        insert(root->left , key);
    } else if(root->key < key){
        insert(root->right , key);
    }
}

int height(node* root){
    if(root == NULL){
        return 0;
    }
    return max(height(root->left),height(root->right)) + 1;
}

bool isBalanced(node *root){
    
    if(root == NULL)
    return true;
    int left = height(root->left);
    int right = height(root->right);
    
    if(abs(left - right) > 1){
        return false;
    }
    return isBalanced(root->left) && isBalanced(root->right);
}

int main(){
    int n;
    cin>>n;
    if(n<0){
        cout<<"Invalid input";
        return 0;
    }
    node *root = nullptr;
    for(int i=0;i<n;i++){
        int t;
        cin>>t;
        insert(root,t);
    }
    
    if(isBalanced(root)){
        cout<<"Balanced BST";
    } else {
        cout<<"Unbalanced BST";
    }
}