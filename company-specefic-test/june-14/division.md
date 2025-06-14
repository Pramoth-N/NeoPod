### Question

Write a function `count_fits(l, s)` that divides two numbers `l` and `s` (given as strings), and returns the quotient as a string rounded to two decimal places. Do not use the division operator (`/`) or (`%`). If the divisor is zero or the input is invalid, return `"Invalid input"`. The result should include a negative sign if the result is negative.

#### Input

Two lines, each containing an integer as a string:
```
15
4
```

#### Output

A single line containing the result as a string rounded to two decimal places:
```
3.75
```

#### Example

**Input**
```
-22
7
```

**Output**
```
-3.14
```

---

```python
def count_fits(l , s):
    try:
        a = int(l)
        b = int(s)
        
        if b == 0:
            return "Invalid input"
            
        neg = (a < 0) ^ (b < 0)
        a = abs(a)
        b = abs(b)
        
        q = 0
        
        while a >= b:
            t = b
            mul = 1
            while a >= (t + t):
                t += t
                mul += mul
                
            a -= t
            q += mul
            
        dec = []
        for _ in range(3):
            a *= 10
            d = 0
            while a >= b:
                a -= b
                d += 1
            dec.append(d)
            
        if dec[2] >= 5 :
            dec[1] += 1
            if dec[1] > 9:
                dec[0] += 1
                dec[1] = 0
        dec.pop()
        res = str(q)
        
        r = False
        for d in dec:
            if d > 0:
                r = True
                break
        if dec and r:
            res += "." + "".join(str(d) for d in dec)
        
        if neg:
            res = '-' + res
        
        return res
    except ValueError:
        return 'Invalid input'
        
print(count_fits(input() , input()))
```
