
### 📄 **Excel Column Title Conversion**



Imagine you are working with a data processing system that needs to interpret Excel column numbers as titles. Each column number must be converted to a title using a specific formula, where:

* 1 → "A"
* 2 → "B"
* 27 → "AA"

Implement a function to convert a given column number into its corresponding title.

---

#### 🧾 Input Format

A single integer `n` represents the column number.

---

#### 📤 Output Format

Print the corresponding column title.

If the input is less than 0 or non-numeric, print:
`Invalid Input`

---

#### 📌 Constraints

-100 ≤ n ≤ 2,147,483,647
The input string must contain only ASCII characters.

---

#### 🧪 Sample Input 1

```
1
```

#### ✅ Sample Output 1

```
A
```

---

#### 🧪 Sample Input 2

```
-10
```

#### ❌ Sample Output 2

```
Invalid Input
```

---
## Code
``` cpp []
#include<iostream>
using namespace std;

int main(){
    int n;
    cin >> n;
    if( n < 1){
        cout << "Invalid input";
        return 0;
    }
    string res = "";
    while(n-- > 0){
        res = char('A' + (n % 26)) + res;
        n /= 26;
    }
    cout << res;
}
```