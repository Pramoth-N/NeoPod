/*
Krish is a warehouse manager, and he needs a program to efficiently manage items on the shelves. His task is to add, remove, display, and view a shelf using an array implementation of a stack. 



Add an Item to the Shelf: Krish can push an item onto the shelf. Each item is represented by an integer.
Remove an Item from the Shelf: Krish can pop an item from the shelf, removing and displaying the most recently added item.
Display Shelf Contents: Krish can view the current items on the shelf.
Exit the warehouse: Krish can choose to exit the warehouse management application.


Write a program to help him in developing the program to perform the given operations.

Input format :
The input consists of integers corresponding to the operation that needs to be performed:

Choice 1: Push the integer value onto the shelf. If the choice is 1, the following input is a space-separated integer, representing the element to be pushed onto the shelf.

Choice 2: Pop the integer from the shelf.

Choice 3: Display the elements on the shelf.

Choice 4: Exit the warehouse.

Output format :
The output displays messages according to the choice and the status of the shelf:

If the choice is 1, push the given item to the shelf and display the corresponding message.
If the choice is 2, pop the given item from the shelf and display the corresponding message.
If the choice is 2, and if the shelf is empty without any elements, print "No items in the shelf"
If the choice is 3, print the items on the shelf.
If the choice is 3, and there are no elements on the shelf, print "Shelf is empty"
If the choice is 4, exit the warehouse and display the corresponding message.
If any other choice is entered, print "Invalid choice"


Refer to the sample output for the exact text and format.

Code constraints :
The maximum size of the shelf is defined as 100.

Choice: 1, 2, 3, or 4

Sample test cases :
Input 1 :
1 5
1 9
2
3
4
Output 1 :
Item 5 is pushed onto the shelf
Item 9 is pushed onto the shelf
Item 9 is popped from the shelf
Items in the shelf: 5 
Exiting the warehouse
Input 2 :
1 97
1 56
2
2
3
2
4
Output 2 :
Item 97 is pushed onto the shelf
Item 56 is pushed onto the shelf
Item 56 is popped from the shelf
Item 97 is popped from the shelf
Shelf is empty
No items in the shelf
Exiting the warehouse
Input 3 :
1 45
1 36
2
3
1 58
3
4
Output 3 :
Item 45 is pushed onto the shelf
Item 36 is pushed onto the shelf
Item 36 is popped from the shelf
Items in the shelf: 45 
Item 58 is pushed onto the shelf
Items in the shelf: 58 45 
Exiting the warehouse
Input 4 :
9
4
Output 4 :
Invalid choice
Exiting the warehouse
*/

#include<bits/stdc++.h>
using namespace std;
void print(stack<int> q){
    if(q.empty()){
        cout<<"Shelf is empty\n";
        return;
    }
    cout<<"Items in the shelf: ";
    while(!q.empty()){
        cout<<q.top()<<" ";
        q.pop();
    }
    cout << endl;
}
int main(){
    stack<int> q;
    while(true){
        int t ;
        cin>>t;
        if(t==1){
            int n;
            cin>>n;
            cout<<"Item "<<n<<" is pushed onto the shelf\n";
            q.push(n);
        } else if (t==2){
            if(q.empty()){
                cout<<"No items in the shelf\n";
                continue;
            }
            int n = q.top();
            q.pop();
            cout<<"Item "<<n<<" is popped from the shelf\n";
        } else if(t==3){
            print(q);
        } else if(t==4){
            cout<<"Exiting the warehouse\n";
            break;
        } else {
            cout<<"Invalid choice\n";
        }
    }
}