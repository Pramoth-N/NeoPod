
# Minimum Initial Health in a Dungeon

Arjun, a brave knight, is on a mission to rescue a princess imprisoned in the bottom-right corner of a perilous `m x n` dungeon. Each room contains:

- Demons (negative values),
- Magic orbs (positive values),
- Or is empty (zero).

Arjun can only move **right** or **down**.

Write a program to calculate the **minimum initial health** needed so Arjun can safely reach the princess, such that his health never drops to zero or below.

---

### 🔢 Input Format:
- The first line contains two space-separated integers `m` and `n`.
- The next `m` lines each contain `n` space-separated integers: the dungeon grid.

### 📤 Output Format:
- Print a single integer — the minimum initial health required.

---

### ✅ Constraints:
- `1 ≤ m, n ≤ 10`
- `-10 ≤ dungeon[i][j] ≤ 30`

---

### 📌 Sample Input 1:
```

3 3
-2 -3 3
-5 -10 1
10 30 -5

```

### 📌 Sample Output 1:
```

7

```

---

### 📌 Sample Input 2:
```

1 1
0

```

### 📌 Sample Output 2:
```

1

````

---

### 🧠 Explanation:
Arjun must begin with at least 7 health to survive the best path.

---

### 💻 Code (C++):
```cpp
#include <bits/stdc++.h>
using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    vector<vector<int>> g(n, vector<int>(m));
    for (int i = 0; i < n; i++)
        for (int j = 0; j < m; j++)
            cin >> g[i][j];

    vector<vector<int>> dp(n + 1, vector<int>(m + 1, INT_MAX));
    dp[n][m - 1] = dp[n - 1][m] = 1;

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            int req = min(dp[i + 1][j], dp[i][j + 1]) - g[i][j];
            dp[i][j] = max(1, req);
        }
    }

    cout << dp[0][0];
}
````

---
