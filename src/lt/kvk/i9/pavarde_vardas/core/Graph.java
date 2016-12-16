package lt.kvk.i9.pavarde_vardas.core;

import lt.kvk.i9.pavarde_vardas.data.Data;
import lt.kvk.i9.pavarde_vardas.stack.Stack;

public class Graph {

    private int MAX_VERTS = 20;

    Stack theStack = new Stack(MAX_VERTS);

    private Vertex vertexList[];    // vertex list
    private int adjMat[][];         // edges array if 0 false, if 1 true
    private int nVerts;             // number of current vertices


    public Graph() {
        vertexList = new Vertex[MAX_VERTS];
        adjMat = new int[MAX_VERTS][MAX_VERTS];
        nVerts = 0;
        for (int j = 0; j < MAX_VERTS; j++) {
            for (int k = 0; k < MAX_VERTS; k++) {
                adjMat[j][k] = 0;
            }
        }
    }


    //-------------------------------
    //      METHODS
    //-------------------------------

    // add a vertex
    public void addVertex(String edgeName, String s1, String s2, String s3) {
        vertexList[nVerts++] = new Vertex(edgeName, new Data(s1, s2, s3));
    }

    // connect vertexes
    public void addEdge(int start, int end) {
        adjMat[start][end] = 1;
        adjMat[end][start] = 1;
    }

    // display vertex
    public void displayVertex(int v) {
        System.out.print(vertexList[v].label + ":  ");
        System.out.println(vertexList[v].data.toString());
        System.out.println("-----------------------------------------------------------------");
    }


    // returns an unvisited vertex adjacent to v
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        return -1;
    }


    // depth first search
    // paieska gilyn
    public void dfs() {
        vertexList[0].wasVisited = true;
        displayVertex(0);
        theStack.push(0);

        while (!theStack.isEmpty()) {
            // get unvisited vertex adjacent to lt.kvk.i9.pavarde_vardas.stack top
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                vertexList[v].wasVisited = true;
                displayVertex(v);
                theStack.push(v);
            }
        }

        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;

    }
}