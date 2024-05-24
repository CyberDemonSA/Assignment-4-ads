public class Task3 {

    public static void main(String[] args) {

        MyGraph graph = new MyGraph(7);

        graph.addEdge(0, 2);
        graph.addEdge(0, 1);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(1, 6);
        graph.addEdge(2, 3);
        graph.addEdge(4, 6);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);

        graph.display();

        graph.DFS();
        System.out.println();
        graph.BFS(0);

    }
}