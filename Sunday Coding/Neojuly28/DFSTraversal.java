import java.util.*;

class Graph {
    private int V;
    private LinkedList<Integer> adj[];
    
    Graph(int v) {
        V = v;
        adj = new LinkedList[v];
        for(int i=0;i<v;++i) {
            adj[i] = new LinkedList<>();
        }
    }
    
    void addEdge(int v ,int w) {
        adj[v].add(w);
    }
    
    void DFS(int v , boolean visited[]) {
        visited[v] = true;
        System.out.print(v + " ");
        
        Iterator<Integer> i = adj[v].listIterator();
        
        while(i.hasNext()) {
            int n = i.next();
            if(!visited[n]) {
                DFS(n, visited);
            }
        }
    }
    
    void DFS(int v) {
        boolean visited[] = new boolean[V];
        DFS(v, visited);
    }
}

class GraphDFS {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        int v = sc.nextInt();
        int e = sc.nextInt();
        
        Graph g = new Graph(v);
        for(int i=0;i<e;i++) {
            g.addEdge(sc.nextInt() ,sc.nextInt());
        }
        
        int start = sc.nextInt();
        
        g.DFS(start);
    }
}