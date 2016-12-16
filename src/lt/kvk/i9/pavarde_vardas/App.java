package lt.kvk.i9.pavarde_vardas;

import lt.kvk.i9.pavarde_vardas.core.Graph;

/**
 * Main class
 */
public class App {


    // run method
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("A", "s1", "s2", "s3");
        graph.addVertex("B", "s1", "s2", "s3");

        graph.addEdge(0, 1);
        graph.addEdge(1, 0);

        graph.dfs();
    }
}
