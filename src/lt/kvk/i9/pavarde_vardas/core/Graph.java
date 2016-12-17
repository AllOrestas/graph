package lt.kvk.i9.pavarde_vardas.core;

import lt.kvk.i9.pavarde_vardas.data.Data;
import lt.kvk.i9.pavarde_vardas.stack.Stack;
import lt.kvk.i9.pavarde_vardas.util.ReadData;

import java.io.File;

public class Graph {

    private int MAX_VERTS = 20;

    Stack theStack = new Stack(MAX_VERTS);

    private Vertex vertexList[];    // vertex list
    private int adjMat[][];         // edges array if 0 false, if 1 true
    private int nVerts;             // number of current vertices

    // data to file object
    private ReadData data = new ReadData();
    String INPUT_FILE = "./res/result.csv";

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
        // vertex'ai pridedami i vertex'u masyva
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
            // jei vertex'as matricos eilėje v ir stulpelyje j yra neaplankytas
            // grąžinama jo vieta stulpelyje - j
            if (adjMat[v][j] == 1 && vertexList[j].wasVisited == false)
                return j;
        // jei nebėra nepalankytų vertex'ų, tai grąžinama -1
        return -1;
    }


    // depth first search
    // paieska gilyn
    public void dfs() {
        // pirmajį vertex'ą nustato kaip aplankytą
        vertexList[0].wasVisited = true;
        // išvedamas į terminalą aplankytas vertex'as
        displayVertex(0);
        // steke įvedama aplankyto vertex'o indeksas
        // ++top - į kurią vieetą įrašomas vertex'o indeksas
        theStack.push(0);

        // vykdoma kol stekas nepalieka tuščias
        while (!theStack.isEmpty()) {
            // get unvisited vertex adjacent to lt.kvk.i9.pavarde_vardas.stack top
            // theStack.peek() metodas grazina didziasiame taske esancio elemento indeksa
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                // nustato jog vertex'as v idekse aplankytas
                vertexList[v].wasVisited = true;
                // isvedamas vertex'as
                displayVertex(v);
                // i steka pridedamas elementas v
                theStack.push(v);
            }
        }

        // kai apeina visus vertex'as wasVisited nustato į null reikšmę
        for (int j = 0; j < nVerts; j++)
            vertexList[j].wasVisited = false;
    }

    //depth first bigger search


    // write data to result file
    public void updateInputFile() {
        data.writeData(INPUT_FILE, vertexList);
    }
}