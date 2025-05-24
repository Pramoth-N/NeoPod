
# Text Justification

## Problem Statement

Given an array of strings `words` and an integer `maxWidth`, format the text such that each line has exactly `maxWidth` characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly `maxWidth` characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

The last line of text should be left justified, and no extra space should be inserted between words.

### Note:
- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed `maxWidth`.
- The input array `words` contains at least one word.

---

## Input Format

- The first line contains an integer `n`, representing the number of words.
- The following `n` lines each contain a string (a word).
- The last line contains an integer `maxWidth`.

---

## Output Format

Print the formatted text lines, each line having exactly `maxWidth` characters.

---

## Constraints

- 1 ≤ n ≤ 300
- 1 ≤ words[i].length ≤ 20
- words[i] consists of only English letters and symbols.
- 1 ≤ maxWidth ≤ 100
- words[i].length ≤ maxWidth

---

## Sample Test Cases

### Input 1:
```

7
This
is
an
example
of
text
justification.
16

```

### Output 1:
```

This    is    an
example  of text
justification.

```

---

### Input 2:
```

18
Science
is
what
we
understand
well
enough
to
explain
to
a
computer.
Art
is
everything
else
we
do
20

```

### Output 2:
```

Science  is  what we
understand      well
enough to explain to
a  computer.  Art is
everything  else  we
do

````

---

## Solution Code (C++)

```cpp
#include<bits/stdc++.h>
using namespace std;

vector<string> justify(vector<string> s, int w) {
    vector<string> res;
    int index = 0;
    int n = s.size();
    
    while (index < n) {
        int ttlChars = s[index].size();
        int last = index + 1;

        // Greedily add words to the current line
        while (last < n) {
            if (ttlChars + 1 + s[last].size() > w) break;
            ttlChars += 1 + s[last].size();
            last++;
        }

        string line = "";
        int cnt = last - index;  // number of words in the line

        // Last line or single word line: left justify
        if (last == n || cnt == 1) {
            for (int i = index; i < last; i++) {
                line += s[i];
                if (i != last - 1) line += " ";
            }
            line += string(w - line.size(), ' ');
        } else {
            // Fully justify
            int totalSpaces = w - (ttlChars - (cnt - 1)); // spaces to distribute
            int space = totalSpaces / (cnt - 1);
            int extra = totalSpaces % (cnt - 1);

            for (int i = index; i < last; i++) {
                line += s[i];
                if (i + 1 != last) {
                    int sp = space + ((i - index) < extra ? 1 : 0);
                    line += string(sp, ' ');
                }
            }
        }
        
        res.push_back(line);
        index = last;
    }

    return res;
}

int main() {
    int n, width;
    cin >> n;
    vector<string> s(n);
    for (int i = 0; i < n; i++) cin >> s[i];
    cin >> width;

    vector<string> result = justify(s, width);
    for (auto &line : result) {
        cout << line << endl;
    }
}
````

---

## Explanation

* The algorithm greedily packs as many words as possible into one line.
* It calculates the total characters used by words, then computes spaces to be inserted.
* If it’s the last line or the line contains only one word, it left-justifies.
* Otherwise, spaces are distributed evenly, with extra spaces added from left to right.
* Time complexity: O(n), where n is number of words.

---
