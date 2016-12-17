package lt.kvk.i9.pavarde_vardas.core;

import lt.kvk.i9.pavarde_vardas.data.Data;

public class Vertex
{
    public int id;
    public String label;
    public boolean wasVisited;
    public Data data;
    public Vertex next;


    public Vertex(int id, String label, Data data)
    {
        this.id = id;
        this.label = label;
        this.data = data;
        wasVisited = false;
    }

    public String getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public Data getData() {
        return data;
    }
}