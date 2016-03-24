package linkedlist;

public class ListMain {
    public static void main(String args[]) {
//        SingleLinkedList<Integer> sList = new SingleLinkedList<Integer>();
//        sList.addLast(3);
//        sList.addLast(4);
//        sList.addLeft(4, 2);
//        sList.addLast(5);
//        sList.addRight(5, 7);
//        sList.addLast(6);
//        sList.printAllNode();
//        sList.remove(7);
//        sList.addLeft(3, 1);
//        sList.addRight(6, 9);
//        sList.remove(1);
//        sList.remove(9);
//        System.out.println("");
//        sList.printAllNode();

        DoubleLinkedList<Integer> dList = new DoubleLinkedList<Integer>();
        dList.addLast(3);
        dList.addLast(5);
        dList.addLast(9);
        dList.printAllNode();
        System.out.println("");
        dList.addLeft(3, 2);
        dList.addRight(9, 10);
        dList.addRight(5, 7);
        dList.remove(3);
        dList.addLeft(2, 1);
        dList.remove(1);
        dList.remove(10);
        dList.printAllNode();
    }
}
