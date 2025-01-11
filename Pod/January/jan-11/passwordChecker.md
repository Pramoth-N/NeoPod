The task involves creating a **password strength checker** using a class `PasswordChecker`. The password must satisfy the following conditions to be considered **strong**:

### Password Strength Criteria
1. **Length**:
   - Must be between 6 and 20 characters.
2. **Character Types**:
   - Must include:
     - At least one **lowercase letter**.
     - At least one **uppercase letter**.
     - At least one **digit**.
3. **No Repeated Characters**:
   - Cannot have three or more consecutive repeating characters (e.g., `aaa`).
   
If the password is weak, calculate the **minimum steps** to make it strong by:
- Adding characters.
- Deleting characters.
- Replacing characters.

---

### Implementation Plan
1. **Class Design**:
   - Define a class `PasswordChecker` with:
     - A constructor to accept the password string.
     - A function to calculate the steps needed to make the password strong.

2. **Steps to Solve**:
   - Check the current **length** of the password.
   - Check for missing character types:
     - Lowercase, uppercase, and digits.
   - Identify groups of consecutive repeated characters.
   - Handle cases where:
     - Password is too short (`< 6`).
     - Password is too long (`> 20`).

---

### C++ Code

```cpp
#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
using namespace std;

class PasswordChecker {
    string password;

public:
    // Constructor
    PasswordChecker(string pwd) : password(pwd) {}

    // Function to check the minimum steps to make the password strong
    int strongPasswordChecker() {
        int n = password.length();
        bool hasLower = false, hasUpper = false, hasDigit = false;
        int replaceCount = 0;  // Tracks replacements for consecutive characters
        vector<int> repeats;  // Tracks groups of consecutive repeated characters

        // Check character requirements and consecutive repeats
        for (int i = 0; i < n;) {
            if (islower(password[i])) hasLower = true;
            if (isupper(password[i])) hasUpper = true;
            if (isdigit(password[i])) hasDigit = true;

            int j = i;
            while (j < n && password[j] == password[i]) j++;
            int repeatLength = j - i;
            if (repeatLength >= 3) repeats.push_back(repeatLength);
            i = j;
        }

        // Missing character types
        int missingTypes = !hasLower + !hasUpper + !hasDigit;

        if (n < 6) {
            // Too short: Add characters to meet length and missing types
            return max(6 - n, missingTypes);
        }

        int excessLength = max(0, n - 20);
        replaceCount = 0;

        // Optimize replacements for repeated characters
        for (int& repeat : repeats) {
            if (excessLength > 0) {
                int reduce = min(repeat - 2, excessLength);
                repeat -= reduce;
                excessLength -= reduce;
            }
            if (repeat >= 3) {
                replaceCount += repeat / 3;
            }
        }

        // Total steps
        return excessLength + max(missingTypes, replaceCount);
    }
};

int main() {
    string password;
    cin >> password;

    PasswordChecker checker(password);
    cout << checker.strongPasswordChecker() << endl;

    return 0;
}
```

---

### Explanation of Code

1. **Missing Character Types**:
   - Check for at least one lowercase letter, one uppercase letter, and one digit.
   - Count the number of missing types.

2. **Handling Consecutive Repeats**:
   - Identify groups of three or more consecutive repeating characters.
   - Calculate how many replacements are needed.

3. **Length Adjustments**:
   - If the password is **too short** (`< 6`), add characters to meet both the length and missing type requirements.
   - If the password is **too long** (`> 20`), delete characters to reduce the length to 20 while optimizing for consecutive repeats.

4. **Final Steps**:
   - Combine the steps for length adjustment, missing types, and replacements to calculate the total changes needed.

---

### Example Outputs

#### Input:
```
aA1
```

#### Output:
```
3
```

#### Input:
```
aA1aaaaaaa
```

#### Output:
```
2
```
