### Question: Count Distinct Island Shapes

An **archipelago** is represented as a grid where land cells are marked as `1` and water cells are marked as `0`. A cluster of connected land cells (connected horizontally or vertically) forms an **island**. Two islands are considered the same if their shapes (relative arrangements of land cells) are identical, regardless of their locations on the grid.

Your task is to determine the **number of distinct island shapes** in the given grid.

#### Input Format:
1. An integer `r` representing the number of rows in the grid.
2. An integer `c` representing the number of columns in the grid.
3. Followed by `r` rows of `c` integers (`0` or `1`) representing the grid.

#### Output Format:
1. An integer representing the number of distinct island shapes.
2. If there are any negative inputs, print `Invalid Input`.

#### Constraints:
- `1 <= r, c <= 50`
- Grid values must be `0` or `1`.

---

### Explanation:

#### Key Concepts:
1. **Island Definition**:
   - An island is a group of connected cells with value `1`.
   - Connectivity is considered **only horizontal or vertical** (not diagonal).
   
2. **Identical Islands**:
   - Two islands are identical if their shapes are the same when their relative cell positions are compared.
   - Example: A vertical island at `(0,0)` and another vertical island at `(2,3)` are considered identical.

3. **Distinct Shapes**:
   - Shapes are determined by relative positions of cells starting from a base cell.
   - Example:
     ```
     1 1        1
     0 1  and   1 1
     ```
     These two islands are different because their cell arrangements differ.

---

### Example Input/Output:

#### Example 1:
**Input**:
```
r = 5, c = 5
1 0 0 0 0
1 1 0 0 1
0 1 1 0 1
0 0 0 0 1
0 0 1 1 1
```

**Output**:
```
3
```

**Explanation**:
There are 3 distinct island shapes:
1. A straight vertical line.
2. An "L" shape.
3. A different smaller shape.

---

#### Example 2:
**Input**:
```
r = 3, c = 3
1 1 0
1 0 0
0 0 1
```

**Output**:
```
2
```

**Explanation**:
There are 2 distinct island shapes:
1. A 2x2 square.
2. A single isolated cell.

---

#### Invalid Input Example:
**Input**:
```
r = -5, c = 3
```

**Output**:
```
Invalid Input
```

**Explanation**:
Negative dimensions are invalid.

---

### Steps to Solve:
1. **Input Validation**:
   - Ensure `r` and `c` are positive and within bounds.
   - Ensure grid values are either `0` or `1`.

2. **Traversal**:
   - Use **DFS (Depth First Search)** to traverse the grid and find islands.
   - Record the **relative positions** of all cells in an island, starting from a base cell.

3. **Compare Shapes**:
   - Store each island's relative shape in a `set`. Duplicate shapes will automatically be ignored.

4. **Count Distinct Shapes**:
   - The size of the `set` gives the count of distinct island shapes.


``` c++ []
#include <iostream>
#include <vector>
#include <set>
#include <string>

using namespace std;

void dfs(int x, int y, vector<vector<int>>& grid, vector<pair<int, int>>& shape, int baseX, int baseY) {
    // Check boundaries and stop recursion if out of bounds or the cell is water
    if (x < 0 || y < 0 || x >= grid.size() || y >= grid[0].size() || grid[x][y] == 0)
        return;

    // Mark the cell as visited
    grid[x][y] = 0;

    // Record the relative position of the cell to the base position
    shape.emplace_back(x - baseX, y - baseY);

    // Explore the four neighboring cells
    dfs(x + 1, y, grid, shape, baseX, baseY);
    dfs(x - 1, y, grid, shape, baseX, baseY);
    dfs(x, y + 1, grid, shape, baseX, baseY);
    dfs(x, y - 1, grid, shape, baseX, baseY);
}

int countDistinctIslands(vector<vector<int>>& grid) {
    set<vector<pair<int, int>>> distinctShapes;

    for (int i = 0; i < grid.size(); ++i) {
        for (int j = 0; j < grid[0].size(); ++j) {
            if (grid[i][j] == 1) {
                vector<pair<int, int>> shape;
                dfs(i, j, grid, shape, i, j);
                distinctShapes.insert(shape);
            }
        }
    }

    return distinctShapes.size();
}

int main() {
    int r, c;
    cin >> r >> c;

    if (r <= 0 || r > 50 || c <= 0 || c > 50) {
        cout << "Invalid Input" << endl;
        return 0;
    }

    vector<vector<int>> grid(r, vector<int>(c));
    for (int i = 0; i < r; ++i) {
        for (int j = 0; j < c; ++j) {
            cin >> grid[i][j];
            if (grid[i][j] != 0 && grid[i][j] != 1) {
                cout << "Invalid Input" << endl;
                return 0;
            }
        }
    }

    cout << countDistinctIslands(grid) << endl;

    return 0;
}
```