package LAB4.Q16_Stack;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    private List<Integer> elements;
    private int topIndex;
    private int capacity;

    public Stack() {
        this(5);
    }

    public Stack(int capacity) {
        this.elements = new ArrayList<>(capacity);
        this.topIndex = -1;
        this.capacity = capacity;
    }

    public void push(int value) {
        if (!isFull()) {
            topIndex++;
            elements.add(topIndex, value);
        }
    }

    public int pop() {
        int removedValue = -1;

        if (!isEmpty()) {
            removedValue = elements.remove(topIndex);
            topIndex--;
        }

        return removedValue;
    }

    public boolean isEmpty() {
        if (topIndex < 0) {
            System.out.println("Stack is empty!");
            return true;
        }

        return false;
    }

    public boolean isFull() {
        if (topIndex >= capacity - 1) {
            System.out.println("Stack overflow!");
            return true;
        }

        return false;
    }

    public int getTop() {
        if (topIndex < 0) {
            return -1;
        }

        return elements.get(topIndex);
    }

    @Override
    public String toString() {
        return "Stack{" +
                "\n\telements=" + elements +
                ",\n\ttopIndex=" + topIndex +
                "\n}";
    }
}