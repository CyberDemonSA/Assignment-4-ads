import java.util.LinkedList;
import java.util.Queue;

public class MyGraph {

    private int V, E;
    LinkedList<Integer>[] adj;

    public MyGraph(int nodes) {
        this.V = nodes;
        this.E = 0;
        this.adj = new LinkedList[V];
        for (int i = 0; i < V; i++) {
             adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int v, int w) {
        adj[v].add(w);
        adj[w].add(v);
        E++;
    }

    public void display() {
        for (int i = 0; i < V; i++) {
            System.out.print("AdjList[" + i + "]: ");
            for (int j = 0; j < adj[i].size(); j++) {
                System.out.print(adj[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    public void DFS() {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                visitNode(i, visited);
            }
        }
    }

    private void visitNode(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int i = 0; i < adj[v].size(); i++) {
            if (!visited[adj[v].get(i)]) {
                visitNode(adj[v].get(i), visited);

            }
        }
    }

    public void BFS(int v) {
        boolean[] visited = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int u = q.poll();
            visited[u] = true;
            System.out.print(u + " ");
            for (int i = 0; i < adj[u].size(); i++) {
                if (!visited[adj[u].get(i)]) {
                    visited[adj[u].get(i)] = true;
                    q.add(adj[u].get(i));
                }
            }
        }
    }
}