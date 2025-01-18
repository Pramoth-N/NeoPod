**Question:**  

A company offers `n` courses, each labeled from `0` to `n-1`. Some courses have prerequisites that must be completed before taking them. Write a program to determine a valid order in which these courses can be completed or return `-1` if it's not possible due to cyclic dependencies between courses.  

Additionally, if the input contains invalid characters (non-integers), the program should output "Invalid Input."  

### **Input Format:**  
1. An integer `n`, representing the number of courses (1 ≤ `n` ≤ 104).  
2. A list of pairs, where each pair `(a, b)` represents that course `b` is a prerequisite for course `a`.  
   - The prerequisites list length will not exceed `105`.

### **Output Format:**  
- A list of integers representing the order in which the courses can be taken.  
- If no valid order exists due to cyclic dependencies, return `-1`.  
- If the input contains invalid characters or malformed input, print "Invalid Input."  

### **Constraints:**  
1. The courses are labeled as integers from `0` to `n-1`.  
2. Each prerequisite pair contains two integers in the range `[0, n-1]`.  
3. Special characters or invalid inputs should result in "Invalid Input."  

### **Example Input 1:**  
```
n = 4  
prerequisites = [[1, 0], [2, 1], [3, 2]]  
```

### **Example Output 1:**  
```
[0, 1, 2, 3]  
```

### **Example Input 2:**  
```
n = 3  
prerequisites = [[1, 0], [0, 1]]  
```

### **Example Output 2:**  
```
-1  
```

### **Example Input 3:**  
```
n = 2  
prerequisites = [[1, 'a']]  
```

### **Example Output 3:**  
```
Invalid Input  
```


``` c++ []
#include<bits/stdc++.h>

using namespace std;

vector<int> findOrder(vector<pair<int,int>>& prereq){
    int n = prereq.size();
    vector<vector<int>> graph(n);
    vector<int> inDegree(n,0);
    
    for(auto& p : prereq){
        graph[p.second].push_back(p.first);
        inDegree[p.first]++;
    }
    
    queue<int> q;
    for(int i=0;i<n;i++){
        if(inDegree[i] == 0){
            q.push(i);
        }
    }
    
    vector<int> courseOrder;
    
    while(!q.empty()){
        int c = q.front();
        q.pop();
        courseOrder.push_back(c);
        
        for(int u : graph[c]){
            inDegree[u]--;
            if(inDegree[u] == 0){
                q.push(u);
            }
        }
    }
    
    if(courseOrder.size() != n){
        return {-1};
    }
    return courseOrder;
}

int main(){
    int n;
    cin >> n;
    if(cin.fail()){
            cout << "Invalid Input";
            return 0;
        }
    vector<pair<int,int>> prerequisites;
    for(int i=0;i<n;i++){
        int course , prereq;
        cin >> course >> prereq;
        if(cin.fail()){
            cout << "Invalid Input";
            return 0;
        }
        prerequisites.push_back({course,prereq});
        
        
    }
        vector<int> res = findOrder(prerequisites);
        if(res.size() == 1 && res[0] == -1){
            cout << "-1";
        } else {
            for(int v : res){
                cout << v << " ";
            }
        }
}
```


``` java []
import java.util.*;

public class CourseScheduler {
    
    public static List<Integer> findOrder(List<int[]> prerequisites) {
        int n = prerequisites.size();
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDegree = new int[n];
        
        // Initialize graph
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        // Build the graph and in-degree array
        for (int[] prereq : prerequisites) {
            int course = prereq[0];
            int prereqCourse = prereq[1];
            graph.get(prereqCourse).add(course);
            inDegree[course]++;
        }
        
        // Initialize queue for BFS
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        List<Integer> courseOrder = new ArrayList<>();
        
        // Process courses using BFS
        while (!queue.isEmpty()) {
            int course = queue.poll();
            courseOrder.add(course);
            
            for (int nextCourse : graph.get(course)) {
                inDegree[nextCourse]--;
                if (inDegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // If we couldn't process all courses, return -1
        if (courseOrder.size() != n) {
            return Collections.singletonList(-1);
        }
        
        return courseOrder;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Read number of prerequisites
        int n = sc.nextInt();
        
        // Validate input
        if (n <= 0) {
            System.out.println("Invalid Input");
            return;
        }
        
        List<int[]> prerequisites = new ArrayList<>();
        
        // Read prerequisite pairs
        for (int i = 0; i < n; i++) {
            int course = sc.nextInt();
            int prereq = sc.nextInt();
            if (course < 0 || prereq < 0) {
                System.out.println("Invalid Input");
                return;
            }
            prerequisites.add(new int[]{course, prereq});
        }
        
        // Find the course order
        List<Integer> res = findOrder(prerequisites);
        
        // Output result
        if (res.size() == 1 && res.get(0) == -1) {
            System.out.println("-1");
        } else {
            for (int course : res) {
                System.out.print(course + " ");
            }
        }
        
        sc.close();
    }
}

```