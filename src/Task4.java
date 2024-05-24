import java.util.*;

public class Task4 {
    private Map<String, List<Edge>> adjList = new HashMap<>();

    private static class Edge {
        String destination;
        int weight;

        Edge(String destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }
    }

    public void addEdge(String source, String destination, int weight) {
        adjList.putIfAbsent(source, new ArrayList<>());
        adjList.get(source).add(new Edge(destination, weight));
        adjList.putIfAbsent(destination, new ArrayList<>()); // If the graph is undirected
        adjList.get(destination).add(new Edge(source, weight));
    }

    public void dijkstra(String start, String end) {
        Map<String, Integer> distances = new HashMap<>();
        Map<String, String> previousNodes = new HashMap<>();
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));

        for (String vertex : adjList.keySet()) {
            if (vertex.equals(start)) {
                distances.put(vertex, 0);
            } else {
                distances.put(vertex, Integer.MAX_VALUE);
            }
            pq.add(new Edge(vertex, distances.get(vertex)));
        }

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            for (Edge edge : adjList.get(current.destination)) {
                int newDist = distances.get(current.destination) + edge.weight;
                if (newDist < distances.get(edge.destination)) {
                    distances.put(edge.destination, newDist);
                    previousNodes.put(edge.destination, current.destination);
                    pq.add(new Edge(edge.destination, newDist));
                }
            }
        }

        printPath(previousNodes, start, end);
    }

    private void printPath(Map<String, String> previousNodes, String start, String end) {
        Deque<String> path = new LinkedList<>();
        for (String at = end; at != null; at = previousNodes.get(at)) {
            path.addFirst(at);
        }
        if (path.isEmpty() || !path.peek().equals(start)) {
            System.out.println("No path found from " + start + " to " + end);
        } else {
            System.out.println("Shortest path from " + start + " to " + end + ": " + String.join(" -> ", path));
        }
    }

    public static void main(String[] args) {
        Task4 graph = new Task4();

        // Example graph edges
        graph.addEdge("Edinburgh", "Dundee", 50);
        graph.addEdge("Edinburgh", "Glasgow", 80);
        graph.addEdge("Glasgow", "Dundee", 70);
        // Add more edges as needed...

        graph.dijkstra("Edinburgh", "Dundee");
    }
}
