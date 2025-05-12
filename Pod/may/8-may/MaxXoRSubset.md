### **Question:**

Given an array of integers `arr` of size `n`, find the **maximum XOR** that can be obtained from **any subset** of at most `n/2` elements.

### **Constraints:**

* `1 <= n <= 20` (for brute-force version)
* `1 <= arr[i] <= 10^6`

---

### **Example:**

**Input:**

```
arr = [3, 10, 5, 25, 2, 8]
```

**Output:**

```
28
```

**Explanation:**
Subset `[5, 25]` gives `5 ^ 25 = 28`, which is the maximum XOR possible from any subset of ≤ 3 elements (since n = 6, n/2 = 3).

---

### **C++ Solution:**

```cpp
#include<bits/stdc++.h>
using namespace std;

int main(){
    int n;
    cin >> n;
    
    if( n < 1){
        cout << "Invalid input";
        return 0;
    }
    vector<int> nums(n);
    for(int i=0;i<n;i++){
        cin >> nums[i];
    }
    
    int maxXor = 0;
    int limit = 1 << n;
    
    for(int i=1;i<limit;i++){
        int cnt = __builtin_popcount(i);
        if(cnt > n / 2) continue;
        
        int x = 0;
        for(int j=0;j<n;j++){
            if(i & ( 1 << j)){
                x ^= nums[j];
            }
        }
        
        maxXor = max(x , maxXor);
    }
    
    cout << maxXor;
}
```

---

Let me know if you want the **optimized version** for larger arrays using XOR basis.
