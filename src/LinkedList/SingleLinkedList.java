package linkedlist;

public class SingleLinkedList<T> {
    Node head = null;
    Node tail = null;
    int size = 0;

    public class Node<T> {
        T data;
        Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public void addLast(T data) {
        Node<T> newNode = new Node(data);
        size++;

        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public boolean addLeft(T target, T data) {
        Node<T> cursorPrev = head;
        Node<T> cursor = head;
        Node<T> newNode = new Node(data);
        size++;

        if (head.data == target) {
            newNode.next = cursor;
            head = newNode;
            return true;
        }

        while (true) {
            if (cursor == null) {
                return false;
            }
            else if (cursor.data == target) {
                cursorPrev.next = newNode;
                newNode.next = cursor;
                return true;
            }
            cursorPrev = cursor;
            cursor = cursor.next;
        }
    }

    public boolean addRight(T target, T data) {
        Node<T> cursor = head;
        Node<T> newNode = new Node(data);
        size++;

        if (head == null) {
            addLast(data);
            return true;
        }
        else if (tail.data == target) {
            tail.next = newNode;
            tail = newNode;
            return true;
        }

        while (true) {
            if (cursor == null) {
                return false;
            }
            else if (cursor.data == target) {
                newNode.next = cursor.next;
                cursor.next = newNode;
                return true;
            }
            cursor = cursor.next;
        }
    }

    public T remove(T target) {
        Node<T> cursorPrev = head;
        Node<T> cursor = head;
        size--;

        if (head.data == target) {
            head = head.next;
            cursor = null;
            return target;
        }

        while (true) {
            if (cursor == null) {
                break;
            }
            else if (cursor.data == target) {
                cursorPrev.next = cursor.next;
                cursor = null;
                return target;
            }
            cursorPrev = cursor;
            cursor = cursor.next;
        }
        return null;
    }

    public boolean find(T target) {
        Node<T> cursor = head;

        while (true) {
            if (cursor == null) {
                return false;
            }
            else if (cursor.data == target) {
                return true;
            }
            cursor = cursor.next;
        }
    }

    public void printAllNode() {
        Node<T> cursor = head;

        while (true) {
            if (cursor == null) {
                break;
            }
            System.out.print(cursor.data + " ");
            cursor = cursor.next;
        }
    }

    public int getSize() {
        return size;
    }
}
