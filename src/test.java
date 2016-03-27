import java.util.*;
import java.util.Scanner;

public class test
{
    class Node
    {
        int value;
        int index;

        public Node(int value, int index)
        {
            this.value = value;
            this.index = index;
        }
    }

    public static void main(String[] args)
    {
        new test().start();
    }

    private void start()
    {
        int arrSize = new Scanner(System.in).nextInt();
        Node[] nodeArray = new Node[arrSize];
        int[] indexArray = new int[arrSize];

        String[] arr = new Scanner(System.in).nextLine().split(" ");

        for (int i = 0; i < arr.length; i++)
        {
            nodeArray[i] = new Node(Integer.parseInt(arr[i]),i);
        }

        for (int n = 0; n < arr.length; n++)
        {

            int index = Arrays.binarySearch( nodeArray, nodeArray[n],
                new MyComparator());

            if (index == 0)
                indexArray[n] = 0;
            else
            {
                int i;
                for (i = index; i > 0; i--)
                {
                    if (nodeArray[i].value > nodeArray[index].value) {
                        indexArray[n] = nodeArray[i].index;
                        break;
                    }
                }
            }
        }

        //출력
        for (int i = 0; i < indexArray.length; i++)
        {
            if (indexArray[i] != 0)
                indexArray[i] += 1;
            System.out.print(indexArray[i]+" ");
        }
    }

    class MyComparator implements Comparator<Node>
    {
        @Override
        public int compare(Node o1, Node o2)
        {
            if (o1.index < o2.index)
                return -1;
            else if (o1.index > o2.index)
                return 1;

            return 0;
        }

        @Override
        public boolean equals(Object obj)
        {
            return false;
        }
    }

}