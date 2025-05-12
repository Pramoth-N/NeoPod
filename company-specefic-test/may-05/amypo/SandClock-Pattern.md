

### ⏳ **Sand Clock Number Pattern**


Alex is fascinated by number patterns and wants to generate a **sand clock pattern using numbers**. Given an integer `N`, the task is to print a sand clock pattern where:

* The **largest number (`N`) appears at the top and bottom**.
* The numbers **decrease** toward the center.
* The pattern is **symmetrical** along the middle row.

---

#### 🧾 Input Format

A single integer `N` representing the size of the sand clock.

---

#### 📤 Output Format

A sand clock pattern of numbers with `N` rows in the **upper half** and `N-1` rows in the **lower half**.

Each row should be **centered with spaces**.

If the input is invalid (i.e., N ≤ 0), print:
`Invalid Input`

---

#### 📌 Constraints

-10 ≤ N ≤ 10

---

#### 🧪 Sample Input 1

```
5
```

#### ✅ Sample Output 1

```
555555555
 4444444
  33333
   222
    1
   222
  33333
 4444444
555555555
```

---

#### 🧪 Sample Input 2

```
-9
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
    int n;
    cin >> n;
    if(n < 1){
        cout << "Invalid input";
        return 0;
    }
    
    for(int i=n;i>0;i--){
        for(int j=n;j>i;j--) cout << "  ";
        for(int j=1;j< i * 2;j++)cout << i <<" ";
        cout << endl;
    }
    for(int i=2;i<=n;i++){
        for(int j=n;j>i;j--) cout << "  ";
        for(int j=1;j< i * 2;j++)cout << i <<" ";
        cout << endl;
    }
}

```
