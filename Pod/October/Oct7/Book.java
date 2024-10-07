/*
 * 
 * 
 * Create a class named Book with the following private attributes.







Include getters and setters. Include default and parameterized constructors.



The format for the parameterized constructor is

Public Book(int id, String name, String author, String publisher, int quantity)



Create a Main class and in the main method get the details of the books and store them in the linked hashSet.



Display all the book details and search for a book name in the set, whether the entered book is present in the set or not.

Input format :
The first line of input consists of an integer N, representing the number of books.



Following N sets of input:

An integer representing the book ID.
A string representing the book name.
A string representing the author's name.
A string representing the publisher.
An integer representing the quantity of the book available.
The last name of the input consists of the book name that you want to search in the set.
Output format :
The output consists of:

For each book, output its details in the format: "ID Name Author Publisher Quantity".

Finally, the output prints whether the searched book name is present in the set or not.



Refer to the sample output for the formatting specifications.

Code constraints :
N (number of books) ranges from 1 to 10.

id ranges from 1 to 1000.

Each string input (book name, author, publisher) is limited to 50 characters.

The search for the book name is case-sensitive.

Sample test cases :
Input 1 :
2
1
Let us C
Yashwanth
BPB
8
2
Operating Systems
Galvin
Wiley
6
Operating Systems
Output 1 :
1 Let us C Yashwanth BPB 8
2 Operating Systems Galvin Wiley 6
Operating Systems is present in the set
Input 2 :
2
1
Let us C
Yashwanth
BPB
8
2
Operating Systems
Galvin
Wiley
6
Java
Output 2 :
1 Let us C Yashwanth BPB 8
2 Operating Systems Galvin Wiley 6
Java is not present in the set
 * 
 * 
 */
import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<String> st = new HashSet<>();
        for(int i=0;i<n;i++){
            int id = sc.nextInt();
            sc.nextLine();
            String name = sc.nextLine();
            String author = sc.nextLine();
            String Publisher = sc.nextLine();
            int qty = sc.nextInt();
            sc.nextLine();
            st.add(name);
            
            System.out.println(id + " " + name + " " + author + " " + Publisher + " " + qty);
        }
        String key = sc.nextLine();
        if(st.contains(key)){
            System.out.println(key + " is present in the set");
        } else {
            System.out.println(key + " is not present in the set");
        }
    }
}
