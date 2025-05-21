
## Problem Statement

Ram is tasked with finding the shortest path between two routers in a network represented by a collection of routers connected by links, each with a certain weight. He will input the number of routers, the number of links, and the details of the connections between routers. 

The program will then use Dijkstra’s algorithm to find and print the shortest path from a specified source router to a destination router.

### Input format :
The first line contains an integer N, representing the number of routers.

The second line contains an integer M, representing the number of links.

The next M lines each contain three space-separated integers: r1, r2, and w, representing a link between routers r1 and r2 with the given w.

The next line contains an integer, s, representing the source router.

The last line contains an integer, d, representing the destination router.

### Output format :
The output prints the shortest distances from the source router to all other routers in the network.

Each line should contain two integers separated by a space, representing the router and its distance from the source.

### Code constraints :
The given test cases fall under the following specifications:

- 2 ≤ N ≤ 8  
- 1≤ M ≤ 12  
- 0 ≤ w ≤ 7

### Sample test cases :
**Input 1 :**
```

4
5
0 1 1
0 2 3
1 2 1
1 3 4
2 3 1
0
3

```

**Output 1 :**
```

0 0
1 1
2 2
3 3

```

**Input 2 :**
```

3
3
0 1 2
0 2 4
1 2 1
0
2

```

**Output 2 :**
```

0 0
1 2
2 3

````

### Java Code:
```java
import java.util.*;

class Sol{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int e = sc.nextInt();
        
        List<int[]>[] graph = new ArrayList[n];
        
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<e;i++){
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new int[]{v , w});
            graph[v].add(new int[]{u , w});
        }
        
        
        int src = sc.nextInt();
        int dest = sc.nextInt();
        
        int[] res = find(graph , src , dest);
        
        for(int i=0;i<n;i++){
            System.out.println(i + " " + res[i]);
        }
    }
    
    private static int[] find(List<int[]>[] graph , int src , int dest){
        int n = graph.length;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        int[] dist = new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src] = 0;
        
        pq.offer(new int[] {0 , src});
        
        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int d = cur[0];
            int u = cur[1];
            
            if(d > dist[u]) continue;
            
            for(int[] node : graph[u]){
                int v = node[0];
                int w = node[1];
                if(dist[v] > dist[u] + w){
                    dist[v] = dist[u] + w;
                    pq.offer(new int[] {dist[v] , v});
                }
            }
        }
        
        return dist;
    }
}
````

