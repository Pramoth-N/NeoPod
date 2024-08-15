/*
 * 
    Arjun is working on a navigation system for a city that consists of multiple landmarks connected by roads. Each landmark is represented as a vertex in a directed graph, and the roads between landmarks are represented as edges in the graph. 



Your task is to implement a function that finds all possible routes between a given source landmark and a destination landmark in the city's road network using a Depth-First Search (DFS) algorithm.

Input format :
The first line contains two space-separated integers V and E, representing the number of landmarks and roads in the city.

Each of the next E lines contains two integers, u and v, separated by a space, representing a road from landmark u to landmark v.

The last line contains two integers, s, and d, separated by a space, representing the source and destination landmarks for which routes need to be found.

Output format :
The output prints all the possible routes from the source landmark to the destination landmark, each route on a separate line.

Each route should be represented as a space-separated sequence of landmarks visited in the order of traversal.



Refer to the sample output for the formatting specifications.

Code constraints :
In this scenario, the given test cases will fall under the following constraints:

1 ≤ V ≤ 100

0 ≤ E ≤ V * (V - 1)

0 ≤ u, v < V

0 ≤ s, d < V

Sample test cases :
Input 1 :
4 6
0 1
0 2
0 3
2 0
2 1
1 3
2 3
Output 1 :
2 0 1 3
2 0 3
2 1 3
Input 2 :
5 6
0 1
0 2
1 3
1 4
2 3
3 4
0 4
Output 2 :
0 1 3 4
0 1 4
0 2 3 4
 * 
 */


 import java.util.*;

public class CityNavigation {

    // Function to find all possible routes from source to destination using DFS
    public static void findAllRoutes(int V, List<List<Integer>> adjList, int s, int d) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        boolean[] visited = new boolean[V];
        
        // Start DFS from source
        dfs(adjList, s, d, visited, path, result);
        
        // Print all paths
        for (List<Integer> r : result) {
            System.out.println(String.join(" ", r.stream().map(String::valueOf).toArray(String[]::new)));
        }
    }
    
    // Recursive DFS function to find all paths
    private static void dfs(List<List<Integer>> adjList, int current, int destination, boolean[] visited, List<Integer> path, List<List<Integer>> result) {
        visited[current] = true;
        path.add(current);
        
        // If we reached the destination, add the path to result
        if (current == destination) {
            result.add(new ArrayList<>(path));
        } else {
            // Visit all neighbors
            for (int neighbor : adjList.get(current)) {
                if (!visited[neighbor]) {
                    dfs(adjList, neighbor, destination, visited, path, result);
                }
            }
        }
        
        // Backtrack
        visited[current] = false;
        path.remove(path.size() - 1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read number of landmarks (vertices) and roads (edges)
        int V = scanner.nextInt();
        int E = scanner.nextInt();
        
        // Initialize adjacency list for the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Read edges and construct the graph
        for (int i = 0; i < E; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            adjList.get(u).add(v);
        }
        
        // Read source and destination landmarks
        int s = scanner.nextInt();
        int d = scanner.nextInt();
        
        // Find and print all possible routes from source to destination
        findAllRoutes(V, adjList, s, d);
    }
}
