package lt.kvk.i9.pavarde_vardas.core;

import lt.kvk.i9.pavarde_vardas.data.Data;
import lt.kvk.i9.pavarde_vardas.stack.Stack;
import lt.kvk.i9.pavarde_vardas.util.ReadData;

import java.io.File;
import java.util.ArrayList;

public class Graph {

    private int MAX_VERTS = 20;

    Stack theStack = new Stack(MAX_VERTS);

    private Vertex root;            // root vertex
    private ArrayList<ArrayList<Integer>> adjMat = null;         // edges array if 0 false, if 1 true
    private int nVerts;             // number of current vertices
    private int numberOfRows = 0;   //

    // data to file object
    private ReadData data = new ReadData();
    String INPUT_FILE = "./res/result.csv";

    public Graph() {
        root = null;
        adjMat = new ArrayList<ArrayList<Integer>>();
        nVerts = 0;
    }


    //-------------------------------
    //      METHODS
    //-------------------------------

    // add a vertex
    public void addVertex(String edgeName, String s1, String s2, String s3) {
        // vertex'ai pridedami i vertex'u masyva
        if (root == null) {
            updateArray();
            root = new Vertex(numberOfRows, edgeName, new Data(s1, s2, s3));
        } else {
            updateArray();
            Vertex temp = root;
            root = new Vertex(numberOfRows, edgeName, new Data(s1, s2, s3));
            root.next = temp;
        }
    }

    // connect vertexes
    public void addEdge(int start, int end) {
        adjMat.get(start).set(end, 1);
        adjMat.get(end).set(start, 1);
    }

    // update array list
    // matrica - adding element to graph
    // increases matrix by one
    // ie before 3x3 after 4x4
    private void updateArray() {
        numberOfRows++;
        adjMat.add(new ArrayList<Integer>());
        for (int i = 0; i <= numberOfRows - 2; i++)
            adjMat.get(numberOfRows - 1).add(0);
        for (int i = 0; i < numberOfRows; i++)
            adjMat.get(i).add(0);
    }


    // display vertex
    public void displayVertex(int v) {
        System.out.print(find(v).label + ":  ");
        System.out.println(find(v).data.toString());
        System.out.println("-----------------------------------------------------------------");
    }


    // returns an unvisited vertex adjacent to v
    public int getAdjUnvisitedVertex(int v) {
        for (int j = 0; j < nVerts; j++)
            // jei vertex'as matricos eilėje v ir stulpelyje j yra neaplankytas
            // grąžinama jo vieta stulpelyje - j
            if (adjMat.get(v).get(j) == 1 && find(v).wasVisited == false)
                return j;
        // jei nebėra nepalankytų vertex'ų, tai grąžinama -1
        return -1;
    }


    // depth first search
    // paieska gilyn
    public void dfs() {
        // pirmajį vertex'ą nustato kaip aplankytą
        find(1).wasVisited = true;
        // išvedamas į terminalą aplankytas vertex'as
        displayVertex(1);
        // steke įvedama aplankyto vertex'o indeksas
        // ++top - į kurią vieetą įrašomas vertex'o indeksas
        theStack.push(1);

        // vykdoma kol stekas nepalieka tuščias
        while (!theStack.isEmpty()) {
            // get unvisited vertex adjacent to lt.kvk.i9.pavarde_vardas.stack top
            // theStack.peek() metodas grazina didziasiame taske esancio elemento indeksa
            int v = getAdjUnvisitedVertex(theStack.peek());
            if (v == -1)
                theStack.pop();
            else {
                // nustato jog vertex'as v idekse aplankytas
                find(v).wasVisited = true;
                // isvedamas vertex'as
                displayVertex(v);
                // i steka pridedamas elementas v
                theStack.push(v);
            }
        }

        // kai apeina visus vertex'as wasVisited nustato į null reikšmę
        for (int j = 0; j < nVerts; j++)
            find(j).wasVisited = false;
    }

    //depth first bigger search


    // write data to result file
    public void updateInputFile() {
        data.writeData(INPUT_FILE, root);
    }

    public Vertex find(int id) {
        for (Vertex local = root; local != null; local = local.next)
            if (local.id == id)
                return local;
        return null;
    }
}