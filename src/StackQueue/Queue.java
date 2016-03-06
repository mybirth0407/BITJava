package StackQueue;

public class Queue<T> {
    int size = 0;
    int front = 0, rear = -1;
    int capacity;
    Object queue[];

    Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new Object[capacity];
    }

    public boolean enqueue(T data) {
        if (data == null) {
            return false;
        }
        else if (size == capacity) {
            return false;
        }

        rear++;
        size++;
        queue[rear] = data;
        return true;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        else if (front == size) {
            return null;
        }

        T dequeueData = (T)queue[front];
        queue[front] = null;
        size--;
        front++;
        return dequeueData;
    }

    public void printQueue() {
        for (int i = front; i < rear + 1; i++) {
            System.out.print(queue[i] + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public int getFront() {
        return front;
    }

    public int getRear() {
        return rear;
    }
}
