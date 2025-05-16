The task is to perform a **zigzag diagonal traversal** of a square matrix as described:

### Problem Breakdown:

1. **Input:**

   * First line: integer `n` (matrix size)
   * Next `n` lines: each line has `n` space-separated integers

2. **Constraints:**

   * `1 <= n <= 10`
   * Elements range from `-1000` to `1000`

3. **Invalid input:**

   * Non-integer `n`
   * `n` not in valid range
   * Rows not having exactly `n` integers or non-integers

4. **Output:**

   * A single line showing the zigzag diagonal traversal (up-right and down-left alternately)
   * If input is invalid, print `"Invalid input"`

---

### Sample Input:

```
3
1 2 3
4 5 6
7 8 9
```

### Sample Output:

```
1 2 4 7 5 3 6 8 9
```

---

### C++ Code Template:

```cpp
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n ;
    cin >> n;
    if( cin.fail() ||  n < 1){
        cout << "Invalid input";
        return 0;
    }
    
    int a[n][n];
    for(int i=0;i<n;i++){
        for(int j=0;j<n;j++){
            cin >> a[i][j];
            if( cin.fail() ||  a[i][j] < 1){
                cout << "Invalid input";
                return 0;
            }
        }
    }
    for(int i=0;i< 2 * n - 1;i++){
        if(i % 2 == 0){
            int r = min(i , n - 1);
            int c = i - r;
            while(r >= 0 && c < n){
                cout << a[r--][c++] << " "; 
            }
        }
        else{
            int c = min(i , n - 1);
            int r = i - c;
            while( c >= 0 && r < n){
                cout << a[r++][c--] << " ";
            }
        }
    }
}
```