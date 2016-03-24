package stackqueue;

public class StackQueueMain {
    public static void main(String args[]) {
//        Stack s = new Stack(2);
//        s.push(1);
//        s.push(2);
//        s.push(3);
//        s.printStack();
//        System.out.println(s.getSize() + "");
//        s.pop();
//        s.printStack();
//        System.out.println(s.getSize() + "");

//        Queue q = new Queue(5);
//        q.enqueue("A");
//        q.enqueue("B");
//        q.enqueue("C");
//        q.enqueue("D");
//        q.enqueue("E");
//        System.out.println(q.getSize());
//        q.enqueue("F");
//        q.printQueue();
//        System.out.println("");
//        q.dequeue();
//        q.dequeue();
//        q.dequeue();
//        q.printQueue();

        Queue cq = new Queue(5);
        cq.enqueue("A");
        cq.enqueue("B");
        cq.enqueue("C");
        cq.enqueue("D");
        cq.enqueue("E");
        System.out.println(cq.getSize());
        cq.enqueue("F");
        cq.printQueue();
        System.out.println("");
        cq.dequeue();
        cq.dequeue();
        cq.dequeue();
        cq.printQueue();
    }
}
