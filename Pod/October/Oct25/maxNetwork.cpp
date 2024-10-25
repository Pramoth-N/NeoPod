
/*

Here's a clearer version of the **question** with an explanation and **sample test cases**:

---

### Question: Maximal Network Rank of Cities

A group of city planners is analyzing the connectivity of various cities. They want to find two cities with the **highest network rank**, which indicates the number of roads directly connected to either of the two cities.

**Task**:
- Given the number of cities and roads, your task is to help the planners determine the **maximal network rank** of the entire infrastructure.

**Input Format**:
1. The first line contains an integer `n`, the number of cities.
2. The second line contains an integer `m`, the number of roads.
3. The next `m` lines each contain two integers `a` and `b`, representing a road between cities `a` and `b`.

**Output Format**:
- If the input is valid, print the maximal network rank.
- If `n < 2` or if any city index is negative or greater than or equal to `n`, print `"Invalid input"`.

**Constraints**:
- \(2 \leq n \leq 100\)
- \(0 \leq m \leq \frac{n \times (n - 1)}{2}\) (This means `m` cannot exceed the total number of unique roads possible.)
- City indices `a` and `b` should satisfy \(0 \leq a, b < n\).

### Explanation:
- The **network rank** of two cities is the number of roads directly connected to them. If a road connects both cities, it should only be counted once.

### Sample Test Case 1:

#### Input:
```
4
4
0 1
0 3
1 2
1 3
```

#### Output:
```
4
```

#### Explanation:
- Cities 1 and 3 have 4 roads connected to them. Hence, the maximal network rank is 4.

### Sample Test Case 2:

#### Input:
```
3
3
0 1
0 2
1 2
```

#### Output:
```
3
```

#### Explanation:
- The highest network rank for any pair of cities is 3 (Cities 0 and 1 or Cities 1 and 2).

### Sample Test Case 3:

#### Input:
```
3
1
0 1
```

#### Output:
```
2
```

#### Explanation:
- Cities 0 and 1 have only 2 roads directly connected to them.

### Sample Test Case 4:

#### Input:
```
3
-1
```

#### Output:
```
Invalid input
```

#### Explanation:
- The number of cities or roads is invalid.

---

This question tests your ability to work with graphs and find the highest degree of connectivity between city pairs based on the provided roads. Let me know if you'd like more details!

*/

#include<bits/stdc++.h>
using namespace std;

int main(){
    int n,e;
    cin >> n >> e;
    if(n<2){
        cout <<"Invalid input";
        return 0;
    }
    
    vector<unordered_set<int>> roads(n);
    vector<int> degree(n,0);
    for(int i=0;i<e;i++){
        int u,v;
        cin >> u >> v;
        if(u < 0 || v < 0 || u >=n || v >= n){
            cout <<"Invalid input";
            return 0;
        }
        
        if(roads[u].find(v) == roads[u].end()){
            roads[u].insert(v);
            roads[v].insert(u);
            degree[u]++;
            degree[v]++;
        }
    }
    
    int maxrank = 0;
    
    for(int i=0;i<n;i++){
        for(int j=i+1;j<n;j++){
            int cur  = degree[i] + degree[j];
            if(roads[i].find(j) != roads[i].end()){
                cur--;
            }
            maxrank = max(maxrank , cur);
        }
    }
    
    cout << maxrank;
}