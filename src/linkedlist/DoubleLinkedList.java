package linkedlist;

public class DoubleLinkedList<T> {
    Node head = null;
    Node tail = null;
    int size = 0;

    public class Node<T> {
        T data;
        Node prev;
        Node next;

        public Node(T data) {
            this.data = data;
            this.prev = null;
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
        Node<T> cursor = head;
        Node<T> newNode = new Node(data);
        size++;

        if (head == null) {
            addLast(data);
            return true;
        }
        else if (head.data == target) {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            return true;
        }

        while (true) {
            if (cursor == null) {
                return false;
            }
            else if (cursor.data == target) {
                newNode.prev = cursor.prev;
                cursor.prev.next = newNode;
                cursor.next.prev = newNode;
                newNode.next = cursor;
                return true;
            }
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
            newNode.prev = tail;
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
                newNode.prev = cursor;
                cursor.next.prev = newNode;
                cursor.next = newNode;
                return true;
            }
            cursor = cursor.next;
        }
    }

    public T remove(T target) {
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
                cursor.prev.next = cursor.next;
                if (cursor.next != null) {
                    cursor.next.prev = cursor.prev;
                }
                cursor = null;
                return target;
            }
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
