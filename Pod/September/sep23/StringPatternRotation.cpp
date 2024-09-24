/*

In the realm of creative programming, Samantha is presented with an intriguing task that fuses strings and artistry. 



Given the string and the number of rows, she is challenged to fashion an exquisite visual by arranging the string in a row-wise chevron style across the specified rows. 



This entails crafting an arrangement that imitates the unfolding elegance of a chevron pattern, where each row contributes to the artwork's final form. 



With her imaginative spirit ignited, Samantha ingeniously orchestrates the characters into a delightful pattern, conjuring a vibrant canvas that combines the magic of strings with the art of visualization.



Example



Input: 

str = "ABCDEFGH"

x = 2



Output: 

ACEGBDFH



Explanation: 

Let us write the input string in a Zig-Zag fashion in 2 rows.







Now concatenate the two rows and ignore spaces in every row. We get "ACEGBDFH".

Input format :
The first line of input consists of the string.

The second line consists of an integer x, the number of rows.

Output format :
The output prints the string after concatenating x rows in a zigzag (otherwise called a chevron) form.



Refer to the sample input and output for better understanding.

Code constraints :
1 ≤ x ≤ 1000

Sample test cases :
Input 1 :
qrrc
3
Output 1 :
qrcr
Input 2 :
ABCDEFGH
2
Output 2 :
ACEGBDFH
*/

#include<iostream>
#include<vector>
using namespace std;

int main(){
    string s;
    int n;
    cin>>s>>n;
    
    if(n <=1 || s.length() <= n){
        cout<<s;
        return 0;
    }
    
    vector<string> rows(n);
    int l = s.length();
    bool d = true;
    int cur =0;
    for(char c : s){
        rows[cur] +=c;
        if(d){
            cur++;
            if(cur == n){
                cur = n-2;
                d = false;
            }
        } else {
            cur--;
            if(cur < 0){
                cur=1;
                d = true;
            }
        }
    }
    
    string result="";
    for(string c : rows){
        result += c;
    }
    
    cout<<result;
}