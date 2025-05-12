
### 🛡️ **Zig-Zag Warrior Formation**

A group of warriors is standing in a line for a battle formation. Each warrior has a unique power level represented by a **non-negative integer**. The commander wants to rearrange them in a **special zig-zag pattern**:

* Start with the **strongest** warrior (highest power)
* Then the **weakest** (lowest power)
* Then the **second strongest**,
* Then the **second weakest**, and so on...

Your task is to take the list of power levels and rearrange them in this specific pattern so that the battle formation alternates between high and low.

---

#### 🧾 Input Format

A single line containing **space-separated integers** representing the warriors' power levels.

---

#### 📤 Output Format

A single line containing the rearranged power levels in the zig-zag pattern, separated by spaces.

If **any power level is negative or non-integer**, print:
`Invalid Input`

---

#### 📌 Constraints

* 1 ≤ Number of warriors ≤ 1000
* 0 ≤ Power levels ≤ 10⁵

---

#### 🧪 Sample Input 1

```
1 3 5 7 9
```

#### ✅ Sample Output 1

```
9 1 7 3 5
```

---

#### 🧪 Sample Input 2

```
-5 -3 -10 12 4
```

#### ❌ Sample Output 2

```
Invalid Input
```

---
## Code

``` java []
import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().trim().split(" ");
        int[] nums = new int [s.length];
        try{
            for(int i=0;i<s.length;i++){
                nums[i] = Integer.parseInt(s[i]);
            }
        } catch(Exception e){
            System.out.println("Invalid input");
            return;
        }
        
        Arrays.sort(nums);
        if(nums[0] < 0){
            System.out.println("Invalid input");
            return;
        }
        int i=0 , j = nums.length - 1;
        while(i <= j){
            System.out.print( i != j ?(nums[j--] + " " + nums[i++] + " ") : (nums[i++] + " "));
        }
    }
}

```
