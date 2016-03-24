package sort;

public class QuickSort {
    public static void main(String args[]) {
        System.out.println("Quick sort");
        int arr[] = {2, 8, 7, 1, 3, 5, 6, 4};

        QuickSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static int Partiton(int arr[], int left, int right) {
        int pivot = arr[right];
        int low = left;
        int high = right - 1;

        while (true) {
            if (low + 1 > high) { // low >= high
                break;
            }

            while (true) {
                try {
                    if (pivot < arr[low]) {
                        break;
                    }
                    else if (low + 1 > right) { // low >= right
                        break;
                    }
                    low++;
                }
                catch (Exception e) {
                    break;
                }
            }

            while (true) {
                try {
                    if (pivot > arr[high]) {
                        break;
                    }
                    else if (high < left + 1) { // high <= left
                        break;
                    }
                    high--;
                }
                catch (Exception e) {
                    break;
                }
            }

            if (low < high + 1) { // low <= high
                int temp = arr[low];
                arr[low] = arr[high];
                arr[high] = temp;
            }
        }

        int temp = arr[right];
        arr[right] = arr[low];
        arr[low] = temp;

        return low;
    }

    public static void QuickSort(int arr[], int left, int right) {
        if (left < right + 1) { // left <= right
            int pivot = Partiton(arr, left, right);
            QuickSort(arr, left, pivot - 1);
            QuickSort(arr, pivot + 1, right);
        }
    }
}
