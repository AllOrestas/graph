package core;

import data.Data;

public class Vertex
{
    public char label;
    public boolean wasVisited;
    public Data data;


    public Vertex(char lab, Data data)
    {
        label = lab;
        wasVisited = false;
        this.data = data;
    }

    public char getLabel() {
        return label;
    }

    public boolean isWasVisited() {
        return wasVisited;
    }

    public Data getData() {
        return data;
    }
}