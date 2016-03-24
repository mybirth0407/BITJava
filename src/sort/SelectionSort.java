package sort;

public class SelectionSort {
    public static void main(String args[]) {
        System.out.println("Selection sort");
        int arr[] = {9, 1, 6, 8, 4, 3, 2};

        SelectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void SelectionSort(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int minValIdx = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[minValIdx] > arr[j]) {
                    minValIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValIdx];
            arr[minValIdx] = temp;
        }
    }
}
