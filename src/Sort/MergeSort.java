package Sort;

public class MergeSort {
    public static void main(String args[]) {
        int arr[] = {2, 4, 5, 7, 1, 2, 3, 6};
        MergeSort(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void Merge(int arr[], int left, int mid, int right) {
        int sortedArr[] = new int[arr.length];
        int sortedIdx = left;
        int leftIdx = left;
        int rightIdx = mid + 1;

        while (true) {
            if (leftIdx > mid) {
                break;
            }
            else if (rightIdx > right) {
                break;
            }

            if (arr[leftIdx] < arr[rightIdx] + 1) {
                sortedArr[sortedIdx] = arr[leftIdx++];
            }
            else {
                sortedArr[sortedIdx] = arr[rightIdx++];
            }
            sortedIdx++;
        }

        if (leftIdx > mid) {
            for (int i = rightIdx; i < right + 1; i++, sortedIdx++) {
                sortedArr[sortedIdx] = arr[i];
            }
        }
        else {
            for (int i = leftIdx; i < mid + 1; i++, sortedIdx++) {
                sortedArr[sortedIdx] = arr[i];
            }
        }

        for (int i = left; i < right + 1; i++) {
            arr[i] = sortedArr[i];
        }
        sortedArr = null;
    }

    public static void MergeSort(int arr[], int left, int right) {
        if (left < right) {
            int i;
            int mid = (left + right) / 2;

            MergeSort(arr, left, mid);
            MergeSort(arr, mid + 1, right);
            Merge(arr, left, mid, right);
        }
    }
}
