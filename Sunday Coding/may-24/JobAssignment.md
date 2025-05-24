
# Job Assignment Problem

## Problem Statement

A company has **N** workers and **N** jobs to be assigned. Each worker can do any job but with different costs. The manager wants to assign each worker to exactly one job such that the total cost is minimized.

Write a program to find the minimum cost for assigning jobs and print the assignments of workers to jobs.

---

## Input Format

- The first line contains an integer **N**, the number of workers and jobs.
- The next **N** lines each contain **N** space-separated integers, where the j-th integer of the i-th line represents the cost of assigning Worker i to Job j.

---

## Output Format

- For each worker i (0-indexed), print a line:  
  `Assign Worker X to Job Y`  
  where **X** is the worker label starting from 'A' and **Y** is the job ID (0-indexed).
- Finally, print the minimum total cost on a new line.

---

## Constraints

- 1 ≤ N ≤ 5
- 1 ≤ cost[i][j] ≤ 100

---

## Sample Test Cases

### Input 1:
```

4
9 2 7 8
6 4 3 7
5 8 1 8
7 6 9 4

```

### Output 1:
```

Assign Worker A to Job 1
Assign Worker B to Job 0
Assign Worker C to Job 2
Assign Worker D to Job 3
13

```

---

### Input 2:
```

2
4 6
7 5

```

### Output 2:
```

Assign Worker A to Job 0
Assign Worker B to Job 1
9

````

---

## Solution Code (C++)

```cpp
#include<bits/stdc++.h>
using namespace std;

void dfs(vector<vector<int>>& cost, vector<bool>& visited, vector<int>& assign, vector<int>& result, int worker, int currentCost, int &minCost) {
    int n = cost.size();
    if (worker == n) {
        if (currentCost < minCost) {
            minCost = currentCost;
            result = assign;
        }
        return;
    }

    for (int job = 0; job < n; job++) {
        if (!visited[job]) {
            visited[job] = true;
            assign[worker] = job;
            dfs(cost, visited, assign, result, worker + 1, currentCost + cost[worker][job], minCost);
            visited[job] = false;
        }
    }
}

int main() {
    int n;
    cin >> n;
    vector<vector<int>> cost(n, vector<int>(n));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> cost[i][j];
        }
    }

    vector<bool> visited(n, false);
    vector<int> assign(n);
    vector<int> result(n);
    int minCost = INT_MAX;

    dfs(cost, visited, assign, result, 0, 0, minCost);

    for (int i = 0; i < n; i++) {
        cout << "Assign Worker " << char('A' + i) << " to Job " << result[i] << endl;
    }
    cout << minCost << endl;
}
````

---

## Explanation

* The solution uses DFS with backtracking to try all possible assignments.
* For each worker, it tries assigning every unvisited job.
* It keeps track of the current assignment cost and updates the minimum cost found.
* Time complexity is O(N!), feasible for N ≤ 5 as per constraints.

---
