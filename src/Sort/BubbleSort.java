package Sort;

public class BubbleSort {
    public static void main(String args[]) {
        System.out.println("Bubble sort");
        int arr[] = {3, 2, 1, 5, 4, 7, 8, 0, 6};

        BubbleSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void BubbleSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
