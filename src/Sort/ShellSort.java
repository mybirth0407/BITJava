/**
 * Created by Yedarm Seong on 2016-03-01.
 */

package Sort;

public class ShellSort {
    public static void main(String args[]) {
        int arr[] = {2, 5, 3, 4, 3, 9, 3, 2, 5, 4, 1, 3};
        int distance = (arr.length / 3) + 1;

        ShellSort(arr, distance);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void ShellSort(int arr[], int distance) {

    }

    public static int[] SmallSort(int arr[]) {

        return arr;
    }
}
