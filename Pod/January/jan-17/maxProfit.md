### Question: Maximum Profit by Scheduling Non-Overlapping Projects

A company manages several projects, each with a defined start time, end time, and profit. The manager needs to determine the maximum profit achievable by scheduling projects such that no two projects overlap. Help the company optimize their scheduling to maximize profit.

---

### Input Format:
1. The first line contains an integer `n` representing the number of projects (1 ≤ n ≤ 10).
2. The second line contains `n` integers representing the start times of the projects (1 ≤ start time ≤ 100).
3. The third line contains `n` integers representing the end times of the projects (1 ≤ end time ≤ 100, and end time ≥ start time for each project).
4. The fourth line contains `n` integers representing the profits of the projects (1 ≤ profit ≤ 100).

---

### Output Format:
- A single integer representing the maximum profit that can be achieved by scheduling the projects.
- If any input is invalid (non-integer values or values outside constraints), print `Invalid Input`.

---

### Example 1:

**Input**:
```
4
1 2 3 3
3 4 5 6
50 10 40 70
```

**Output**:
```
120
```

---

### Example 2:

**Input**:
```
4
1 2 3 a
3 4 5 6
50 10 40 70
```

**Output**:
```
Invalid Input
```

---

### Constraints:
1. Ensure the inputs conform to the given ranges.
2. If any input violates the constraints or contains non-integer characters, output "Invalid Input."
3. Optimize the project schedule to ensure no two projects overlap, maximizing the total profit.


``` c++ []
#include <bits/stdc++.h>

using namespace std;

struct Node
{
    int start, end, profit;
};

int lastNonConflict(vector<Node> a, int i)
{
    for (int j = i - 1; j >= 0; j--)
    {
        if (a[j].end <= a[i].start)
        {
            return j;
        }
    }
    return -1;
}
int main()
{
    int n;
    cin >> n;
    if (cin.fail())
    {
        cout << "Invalid Input";
        return 0;
    }
    vector<Node> a(n);
    for (int i = 0; i < n; i++)
    {
        cin >> a[i].start;
        if (cin.fail())
        {
            cout << "Invalid Input";
            return 0;
        }
    }
    for (int i = 0; i < n; i++)
    {
        cin >> a[i].end;
        if (cin.fail())
        {
            cout << "Invalid Input";
            return 0;
        }
    }
    for (int i = 0; i < n; i++)
    {
        cin >> a[i].profit;
        if (cin.fail())
        {
            cout << "Invalid Input";
            return 0;
        }
    }
    sort(a.begin(), a.end(), [](Node &x, Node &y)
         { return x.end < y.end; });

    vector<int> dp(n);
    dp[0] = a[0].profit;

    for (int i = 1; i < n; i++)
    {
        int prof = a[i].profit;
        int last = lastNonConflict(a, i);
        if (last != -1)
        {
            prof += dp[last];
        }

        dp[i] = max(prof, dp[i - 1]);
    }
    cout << dp[n - 1];
}
```