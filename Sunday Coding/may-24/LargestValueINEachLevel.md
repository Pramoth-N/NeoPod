
# Largest Value in Each Row of a Binary Tree

Given the **root** of a binary tree (in level order as a comma-separated list), return an array containing the **largest value in each row** of the tree.

---

### 🔢 Input Format:
- A single line of comma-separated node values (`null` for missing children).

### 📤 Output Format:
- Print a list of the largest values in each level.

---

### ✅ Constraints:
- Number of nodes: `0 <= nodes <= 10^4`

---

### 📌 Sample Input 1:
```

56,null,85,90,null,null

```

### 📌 Sample Output 1:
```

\[56, 85]

```

---

### 📌 Sample Input 2:
```

1,3,2,5,3,null,9

```

### 📌 Sample Output 2:
```

\[1, 3, 9]

```

---

### 📌 Sample Input 3:
```

10,20,30,40,50

```

### 📌 Sample Output 3:
```

\[10, 30, 50]

````

---

### 🌳 Explanation:
You perform level-order traversal and track the max value for each level.

---

### 💻 Code (Java):
```java
import java.util.*;

class Node {
    int val;
    Node left, right;
    Node(int x) {
        val = x;
        left = right = null;
    }
}

public class BinaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nodes = sc.nextLine().replaceAll("\\s+", "").split(",");
        Node root = build(nodes);
        System.out.println(largestValueInTheLevel(root));
    }

    private static Node build(String[] values) {
        if (values.length == 0 || values[0].equals("null")) return null;
        Node root = new Node(Integer.parseInt(values[0]));
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        int i = 1;
        while (i < values.length) {
            Node cur = q.poll();
            if (!values[i].equals("null")) {
                cur.left = new Node(Integer.parseInt(values[i]));
                q.offer(cur.left);
            }
            i++;
            if (i < values.length && !values[i].equals("null")) {
                cur.right = new Node(Integer.parseInt(values[i]));
                q.offer(cur.right);
            }
            i++;
        }
        return root;
    }

    private static List<Integer> largestValueInTheLevel(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int n = q.size(), max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                Node cur = q.poll();
                max = Math.max(max, cur.val);
                if (cur.left != null) q.offer(cur.left);
                if (cur.right != null) q.offer(cur.right);
            }
            res.add(max);
        }
        return res;
    }
}
```

