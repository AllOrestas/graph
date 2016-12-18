package lt.kvk.i9.pavarde_vardas.core;

import lt.kvk.i9.pavarde_vardas.data.Data;

public class Vertex
{
    public String label;
    public boolean wasVisited;
    public Data data;


    public Vertex(String label, Data data)
    {
        this.label = label;
        wasVisited = false;
        this.data = data;
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

    @Override
    public String toString() {
        return "Vertex{" +
                "label='" + label + '\'' +
                ", wasVisited=" + wasVisited +
                ", " + data.toString() +
                '}';
    }
}