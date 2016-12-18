package lt.kvk.i9.pavarde_vardas;

import lt.kvk.i9.pavarde_vardas.core.Graph;

/**
 * Main class
 */
public class App {


    // run method
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addEdge(0, 2); //DL
        graph.addEdge(0, 3); //DG
        graph.addEdge(0, 1); //DO
        graph.addEdge(1, 3); //OG
        graph.addEdge(2, 4); //LK
        
        graph.dfs();
        
    }
}
