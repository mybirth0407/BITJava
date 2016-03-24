package stackqueue;

import java.util.ArrayList;

public class Stack<T> {
    int top = -1;
    int size = 0;
    int capacity;
    ArrayList<T> stack = new ArrayList<T>();

    Stack(int capacity) {
        this.capacity = capacity;
    }

    public boolean push(T data) {
        if (data == null) {
            return false;
        }
        else if (size == capacity) {
            return false;
        }

        stack.add(data);
        size++;
        top++;
        return true;
    }

    public T pop() {
        if (size == 0) {
            return null;
        }

        T popData = stack.get(top);
        stack.remove(top);
        top--;
        size--;
        return popData;
    }

    public void printStack() {
        for (int i = 0; i < size; i++) {
            System.out.print(stack.get(i) + " ");
        }
    }

    public int getTop() {
        return top;
    }

    public int getSize() {
        return size;
    }
}
