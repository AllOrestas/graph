package graph.basic;



/**
 * Created by Pikis on 11/27/2016.
 */
public class App
{

    public static void main(String[] args) {
        graph.basic.Graph theGraph = new Graph();

        theGraph.addVertex('A');
        theGraph.addVertex('B');
        theGraph.addVertex('C');
        theGraph.addVertex('D');
        theGraph.addVertex('E');
        theGraph.addVertex('F');

        theGraph.addEdge(0, 1); // AB
        theGraph.addEdge(0, 2); // AC
        theGraph.addEdge(0, 4); // AE
        theGraph.addEdge(1, 3); // BD
        theGraph.addEdge(1, 2); // BC
        theGraph.addEdge(0, 3); // AD
        theGraph.addEdge(3, 4); // DE

        System.out.println("Visits: ");
        theGraph.dfs();
        System.out.println();
        
        App a = new App();
        a.gg();
    }
    
    
    public void gg()
    {
    	System.out.println("gg");
    }

}

