package lt.kvk.i9.meilys_orestas.stack;


public class Stack {

    private int[] st;
    private int top;

    // size sets in Graph class
    public Stack(int SIZE) {
        st = new int[SIZE];
        top = -1;
    }

    // adds object in front
    public void push(int j) {
        st[++top] = j;
    }

    // removes object from beginning
    public int pop() {
        return st[top--];
    }

    //grazina didziasiame taske esancio elemento indeksa
    public int peek() {
        return st[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
