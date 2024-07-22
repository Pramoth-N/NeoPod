#include<iostream>
#include<vector>
using namespace std;

struct node{
    int key;
    node *left,*right;
    node(int key) : key(key){}
};

node* insert(vector<int>& arr , int s, int e)
{
    if(s>e)
    return NULL;
    
    int mid = (s+e) / 2;
    node* root = new node(arr[mid]);
    root->left = insert(arr,s,mid-1);
    root->right = insert(arr,mid+1,e);
    
    return root;
}

void print(node *root)
{
    if(!root)
    return;
    cout<<root->key<<" ";
    print(root->left);
    print(root->right);
}
int main()
{
    int n;
    cin>>n;
    vector<int> arr(n);
    for(int i=0;i<n;i++)
    cin>>arr[i];
    
    node *root = insert(arr,0,n-1);
    
    print(root);
}