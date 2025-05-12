
### 🎁 **Fair Character Distribution in Gift-Wrapping Strings**


You are designing a gift-wrapping machine that prints decorative strings on paper strips. Each decorative string must be cut into as many equal parts as possible, with each part containing **identical frequencies of every character**.

Before making the cuts, you need to decide, based on the character frequencies, how many equal parts the given string can be divided into.

Your task is to determine the **maximum number of equal-sized parts** the string can be divided into **without rearranging the characters** and ensuring the character distribution is fair.

---

#### 🧾 Input Format

A single string `S` consisting of uppercase and lowercase English letters.

---

#### 📤 Output Format

Print the **maximum number of equal-sized parts** the string can be divided into.

If the input string contains **any non-alphabetic characters** (like digits, symbols, etc.), print:
`Invalid Input`

---

#### 📌 Constraints

* 1 ≤ |S| ≤ 1000
* S contains only ASCII characters.

---

#### 🧪 Sample Input 1

```
aaabbb
```

#### ✅ Sample Output 1

```
3
```

---

#### 🧪 Sample Input 2

```
ababc@2
```

#### ❌ Sample Output 2

```
Invalid Input
```

---
## Code
``` cpp []

#include<bits/stdc++.h>
using namespace std;

int gcd(int a , int b){
    return b == 0 ? a : gcd(b , a % b);
}

int main(){
    string s;
    cin >> s;
    unordered_map<char,int> freq;
    for(char c : s){
        if(!isalpha(c)){
            cout << "Invalid input";
            return 0;
        }
        freq[c]++;
    }
    
    int res = 0;
    for(auto& p : freq){
        res = gcd(res , p.second);
    }
    cout << res;
}

```
