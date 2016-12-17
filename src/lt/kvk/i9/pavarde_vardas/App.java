package lt.kvk.i9.pavarde_vardas;

import lt.kvk.i9.pavarde_vardas.core.Graph;

/**
 * Main class
 */
public class App {


    // run method
    public static void main(String[] args) {
        Graph graph = new Graph();

        graph.addVertex("1A", "s1", "s2", "s3");
        graph.addVertex("DFB", "s1", "s2", "s3");
        graph.addVertex("C", "s1", "s2", "s3");

        graph.addEdge(1, 0); // BA
        graph.addEdge(0, 1); // BC
        graph.addEdge(2, 0); // CA

//        graph.dfs();

        String str = "k";
        String strToCompare = "5";
        if ((str.compareTo(strToCompare)) == -1) {
            System.out.println(str + " daugiau uz " + strToCompare);
        } else if ((str.compareTo(strToCompare)) == 1) {
            System.out.println(str + " maziau uz " + strToCompare);
        } else {
            System.out.println("lygu");
        }
    }
}
