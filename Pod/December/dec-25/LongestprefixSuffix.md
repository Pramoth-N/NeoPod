# Problem Statement



Given a string s, find the length of the longest substring that will occur in front of any character, which also occurs in the rear of that same character without any overlap issues.



## Example



## Input:
```
aabcdaabc
```
## Output:
```
4
```

## Explanation:

The string **"aabc"** is the result for this problem.

### Input format :
The input consists of a string.

### Output format :
The output prints an integer representing the length of the longest substring according to the specified conditions.


---
Refer to the sample output for formatting specifications.
---

### Code constraints :
The input strings consists of lowercase characters.

### Sample test cases :
| Input/Output | Value |
|--------------|-------|
| Input 1      | aabcdaabc |
| Output 1     | 4 |
| | |
| Input 2      | zrtyuiqzrtyui |
| Output 2     | 6 |


``` java []
import java.util.*;

class PrefixString {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        
        int[] lps = computelps(s);
        
        System.out.println(lps[s.length() - 1]);
    }
    
    private static int[] computelps(String s){
        int len = 0;
        int i = 1;
        int[] lps = new int[s.length()];
        lps[0] = 0;
        while(i < s.length()){
            if(s.charAt(i) == s.charAt(len)){
                lps[i++] = ++len;
            } else {
                if(len != 0){
                    len = lps[len-1];
                } else {
                    i++;
                }
            }
        }
        
        return lps;
    }
}
```