The problem described in your image is a classic **Travelling Salesman Problem (TSP)**. You are given a cost matrix representing the travel costs between galleries and are required to compute the **minimum cost** to start at one gallery, visit all others exactly once, and return to the starting gallery.

---

### Problem Breakdown:

* Input:

  * First line: Integer `n` (number of galleries)
  * Next `n` lines: Cost adjacency matrix (`n x n`)
* Output:

  * Print the **minimum cost** of a tour that visits all galleries once and returns to the start

---

### Sample Input:

```
4
0 10 15 20
10 0 35 25
15 35 0 30
20 25 30 0
```

### Sample Output:

```
Minimum Cost is: 80
```

---

### C++ Solution (Using Backtracking with Bitmasking):

```cpp
#include <iostream>
#include <vector>
#include <climits>
using namespace std;

int tsp(int mask, int pos, vector<vector<int>>& dist, vector<vector<int>>& dp, int n) {
    if (mask == (1 << n) - 1) {
        return dist[pos][0];  // return to starting point
    }

    if (dp[mask][pos] != -1)
        return dp[mask][pos];

    int ans = INT_MAX;
    for (int city = 0; city < n; city++) {
        if ((mask & (1 << city)) == 0) {
            int newAns = dist[pos][city] + tsp(mask | (1 << city), city, dist, dp, n);
            ans = min(ans, newAns);
        }
    }

    return dp[mask][pos] = ans;
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> dist(n, vector<int>(n));
    
    for (int i = 0; i < n; i++)
        for (int j = 0; j < n; j++)
            cin >> dist[i][j];

    vector<vector<int>> dp(1 << n, vector<int>(n, -1));

    int result = tsp(1, 0, dist, dp, n);
    cout << "Minimum Cost is: " << result << endl;

    return 0;
}
```

---