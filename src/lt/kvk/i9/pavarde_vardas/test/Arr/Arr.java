package lt.kvk.i9.pavarde_vardas.test.Arr;

import java.util.ArrayList;

/**
 * Created by Pikis on 12/17/2016.
 */
public class Arr {
    public static void main(String[] args) {
        Arr arr = new Arr();
        arr.fill(5, 5);
//        arr.printArr();
        arr.addEdge(2, 0);
        arr.printArr();
        arr.addByOne();
        arr.printArr();
        arr.addEdge(5, 4);
        arr.printArr();
    }

    int rows = 0;

    private ArrayList<ArrayList<Integer>> adjMat = new ArrayList<ArrayList<Integer>>();

    // fill adjMat
    public void fill(int row, int column) {
        for (int i = 0; i < row; i++) {
            adjMat.add(new ArrayList<Integer>());
            rows++;
            for (int j = 0; j < column; j++)
                adjMat.get(i).add(0);
        }

    }

    // print all adjunct
    public void printArr() {
        for (int i = 0; i < adjMat.size(); i++) {
            System.out.println(adjMat.get(i).toString());
        }
        System.out.println();
    }

    // add edge
    public void addEdge(int start, int end) {
        adjMat.get(start).set(end, 1);
        adjMat.get(end).set(start, 1);
    }

    public void addByOne() {
        rows++;
        adjMat.add(new ArrayList<Integer>());
        for (int i = 0; i <= rows - 2; i++)
            adjMat.get(rows - 1).add(0);
        for (int i = 0; i < rows; i++)
            adjMat.get(i).add(0);
    }
}
