## Problem Statement

David is analyzing matrices and needs to find the count of square sub-matrices whose sum of elements is equal to a given value `S`. He needs your help in writing a program that can efficiently find all such sub-matrices in a given matrix.

---

### Example

**Input:**
```
3
1 2 3
4 5 6
7 8 9
16
```

**Output:**
```
1
```

**Explanation:**

In the given matrix, the sub-matrix from (0, 1) to (1, 2) with sum = 2 + 3 + 5 + 6 = 16. So, the output is the count of all the square sub-matrices whose sum of elements is equal to `S`, which is 1.

---

### Input Format

- The first line of input consists of a single integer `N`, denoting the size of the input matrix.
- The following `N` lines consist of `N` space-separated positive integers, denoting the matrix elements.
- The last line consists of a single positive integer `S`, denoting the required sum.

### Output Format

- The output prints an integer representing the count of all square sub-matrices whose sum of elements is equal to `S`.

Refer to the sample output for formatting specifications.

---

### Code Constraints

- `1 ≤ N ≤ 5`
- `1 ≤ matrix elements ≤ 100`
- `1 ≤ S ≤ 100`

---

### Sample Test Cases

#### Input 1
```
3
6 3 5 
1 8 2 
4 8 0
21
```
**Output 1**
```
1
```

#### Input 2
```
3
1 2 3
4 5 6
7 8 9
16
```
**Output 2**
```
1
```

---

### Solution (Python)

```python
def sub_sum(a, n, k):
    prefix = [[0] * (n + 1) for _ in range(n + 1)]
    for i in range(n):
        for j in range(n):
            prefix[i + 1][j + 1] = a[i][j] + prefix[i][j + 1] + prefix[i + 1][j] - prefix[i][j]
    cnt = 0
    for size in range(1, n + 1):
        for i in range(n - size + 1):
            for j in range(n - size + 1):
                x, y = i + size, j + size
                sq_sum = prefix[x][y] - prefix[i][y] - prefix[x][j] + prefix[i][j]
                if sq_sum == k:
                    cnt += 1
    return cnt

def main():
    n = int(input())
    grid = [list(map(int, input().split())) for _ in range(n)]
    k = int(input())
    print(sub_sum(grid, n, k))

main()
```