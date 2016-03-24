package sort;

public class InsertionSort {
    public static void main(String args[]) {
        System.out.println("Insertion sort");
        int arr[] = {22, 10, 54, 25, 1, 5, 7};

        InsertionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void InsertionSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {
            int idx = arr.length;
            int temp = arr[0];

            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    idx = j;
                    temp = arr[i];
                    break;
                }
            }

            if (idx == arr.length) {
                continue;
            }

            for (int k = i; k > idx; k--) {
                arr[k] = arr[k - 1];
            }
            arr[idx] = temp;
        }
    }
}
