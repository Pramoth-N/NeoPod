## Hot dogs

### Problem Statement
Raju has an l-length hot dog that he wants to chop in an efficient manner so that he can share it with as many friends as possible. Based on the chopped length product the maximum served friends are calculated.

### Example

**Input:**

4


**Output:**

Maximum friends served = 4


### Explanation:
```
1, 3      (1 × 3) = 3
2, 2      (2 × 2) = 4
3, 1      (3 × 1) = 3
1, 1, 2     (1 × 1 × 2) = 2
1, 2, 1     (1 × 2 × 1) = 2
2, 1, 1     (2 × 1 × 1) = 2
1, 1, 1, 1   (1 × 1 × 1 × 1) = 1
```

### Input Format
- The input corresponds to the length of the hot dog (`l`).

### Output Format
- The output prints the maximum number of friends served as an output.

### Sample Test Cases
**Input 1:**

4

**Output 1:**

Maximum friends served 4


**Input 2:**

5

**Output 2:**

Maximum friends served 6

``` c++ []

#include<iostream>
using namespace std;

int main() {
    int n;
    cin >> n;
    cout << "Maximum friends served ";
    if(n <= 3) {
        cout << n;
        return 0;
    } 
    
    int prod = 1;
    while(n > 4) {
        prod *= 3;
        n -= 3;
    }
    prod *= n;
    cout << prod;
}

```