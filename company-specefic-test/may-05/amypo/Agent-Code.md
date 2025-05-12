
### 🕵️‍♂️ **Agent Code Difference Detection**


In a secret spy network, agents communicate using coded numbers. To avoid detection, they sometimes communicate in such a way that the **difference between two agents' code numbers is exactly a known target value**.

You are assigned the mission to find how many **unique agent pairs** exist such that the **absolute difference** between their code numbers is equal to a given target difference.

Your task is to help the intelligence agency by finding out the number of valid agent pairs based on their code numbers and the given target difference.

---

#### 🧾 Input Format

1. An integer `n` – the number of agents.
2. A line of `n` space-separated integers – the agents’ code numbers.
3. An integer `diff` – the target difference between two agents' code numbers.

---

#### 📤 Output Format

Print the **total number of valid agent pairs** with the given target difference.

If `n` is not in the valid range or if `diff` is negative, print:
`Invalid Input`

---

#### 📌 Constraints

* -100 ≤ n ≤ 100
* -10⁵ ≤ code numbers ≤ 10⁵
* -10⁵ ≤ diff ≤ 10⁵

---

#### 🧪 Sample Input 1

```
5
1 5 3 4 2
2
```

#### ✅ Sample Output 1

```
3
```

---

#### 🧪 Sample Input 2

```
4
```

#### ❌ Sample Output 2

```
Invalid Input
```

---
## Code

``` cpp []
#include<iostream>
#include<vector>
using namespace std;


int main(){
    int n,k;
    cin >> n;
    if(n <= 0){
        cout << "Invalid input";
        return 0;
    }
    vector<int> nums(n);
    for(int i=0;i<n;cin >> nums[i++]);
    cin >> k;
    if(k < 0){
        cout << "Invalid input";
        return 0;
    }
    int cnt = 0;
    for(int i=0;i+1<n;i++){
        for(int j=i+1;j<n;j++){
            if(abs(nums[i] - nums[j]) == k) cnt++;
        }
    }
    cout << cnt;
    
}
```