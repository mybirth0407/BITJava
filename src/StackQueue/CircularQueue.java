package StackQueue;

public class CircularQueue<T> {
    int size = 0;
    int front = 0, rear = -1;
    int capacity;
    Object circualrQueue[];

    CircularQueue(int capacity) {
        this.capacity = capacity;
        this.circualrQueue = new Object[capacity];
    }

    public boolean enqueue(T data) {
        if (data == null) {
            return false;
        }
        else if (size == capacity) {
            return false;
        }

        rear++;
        rear %= capacity;
        size++;
        circualrQueue[rear] = data;
        return true;
    }

    public T dequeue() {
        if (size == 0) {
            return null;
        }
        else if (front == size) {
            return null;
        }

        T dequeueData = (T) circualrQueue[front];
        circualrQueue[front] = null;
        size--;
        front++;
        front %= capacity;
        return dequeueData;
    }

    public void printQueue() {
        for (int i = front; i < rear + 1; i++) {
            System.out.print(circualrQueue[i] + " ");
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
