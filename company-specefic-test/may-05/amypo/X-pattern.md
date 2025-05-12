

### ❌ **X-Shaped Secret Message Display**


In a futuristic city, secret messages are displayed in an **X-shaped pattern** for security purposes. Your task is to generate this pattern from a given **alphabetic string** to ensure clarity in communication.

If the input:

* Contains **non-alphabetic characters**
* Is **empty**
* **Exceeds 50 characters**

...then display `Invalid Input`.

---

#### 🧾 Input Format

A single string `S`, consisting of **uppercase and lowercase English letters**.

---

#### 📤 Output Format

Print the **X pattern** formed by the given string.
If the input is invalid, print:
`Invalid Input`

---

#### 📌 Constraints

* The input must contain only ASCII characters.
* Length: 1 ≤ |S| ≤ 50

---

#### 🧪 Sample Input 1

```
PROGRAM
```

#### ✅ Sample Output 1

```
P     P
 R   R 
  O O  
   G   
  R R  
 A   A 
M     M
```

---

#### 🧪 Sample Input 2

```
HELLO1
```

#### ❌ Sample Output 2

```
Invalid Input
```

---
## Code

```cpp []
#include<iostream>
using namespace std;

int main(){
    string s;
    cin >> s;
    for(char c : s){
        if(!isalpha(c)){
            cout << "Invalid input";
            return 0;
        }
    }
    for(int i=0;i<s.length();i++){
        for(int j=0;j<s.length();j++){
            cout << ((i == j || i + j + 1 == s.length()) ? s[i] : ' ');
        }
        cout << endl;
    }
}
```
