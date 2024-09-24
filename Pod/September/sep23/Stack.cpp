/*


Meet Alex, a computer science student who loves solving programming challenges.



Today, Alex is tasked with creating a program to simulate a stack data structure using linked lists.



The objective is to provide a menu-driven interface for performing essential stack operations.

Push elements onto the stack
Pop elements from the stack 
Display the current stack contents


Additionally, Alex needs to ensure that the program handles stack underflow conditions. Help him to accomplish the task.

Input format :
The input consists of integers corresponding to the operation that needs to be performed:

Choice 1: If the choice is 1, the following integer input represents the element to be pushed onto the stack.

Choice 2: Pop the integer from the stack.

Choice 3: Display the elements in the stack.

Choice 4: Exit the program.

Output format :
The output displays messages according to the choice and the status of the stack:



If the choice is 1, push the given integer to the stack and display the following: "[value] is pushed onto the stack"
If the choice is 2, pop the integer from the stack and display the following: "[value] is popped from the stack"
If the choice is 2, and if the stack is empty without any elements, print "Stack Underflow"
If the choice is 3, print the elements in the stack in the format: "Elements in the stack: ", followed by the space-separated integer values.
If the choice is 3, and there are no elements in the stack, print "Stack is empty"
If the choice is 4, exit the program and display the following: "Exiting the program"
If any other choice is entered, print "Invalid choice"


Refer to the sample output for the formatting specifications.

Code constraints :
Choice: 1, 2, 3, or 4

Sample test cases :
Input 1 :
1 2
1 3
3
2
3
4
Output 1 :
2 is pushed onto the stack
3 is pushed onto the stack
Elements in the stack: 3 2 
3 is popped from the stack
Elements in the stack: 2 
Exiting the program
Input 2 :
5
4
Output 2 :
Invalid choice
Exiting the program
Input 3 :
2
4
Output 3 :
Stack Underflow
Exiting the program
Input 4 :
3
4
Output 4 :
Stack is empty
Exiting the program

*/

#include<bits/stdc++.h>
using namespace std;

void print(stack<int> st){
    while(!st.empty()){
        cout<<st.top()<<" ";
        st.pop();
    }
    cout<<endl;
}
int main(){
    stack<int> st;
    while(true){
        int a;
        cin>>a;
        if(a==1){
            int t;
            cin>>t;
            st.push(t);
            cout<<t<<" is pushed onto the stack\n";
        } else if(a==2){
            if(st.empty()){
                cout<<"Stack Underflow\n";
            } else{
                int t = st.top();
                st.pop();
                cout<<t<<" is popped from the stack\n";
            }
        } else if(a==3){
            if(st.empty()){
                cout<<"Stack is empty\n";
                continue;
            }

            cout<<"Elements in the stack: ";
            print(st);
        } else if( a==4){
            cout<<"Exiting the program\n";
            break;
        } else {
            cout<<"Invalid choice\n";
        }
    }
}