package Sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class ShellSort {
    public static void main(String args[]) {
        int arr[] = {2, 5, 3, 4, 3, 9, 3, 2, 5, 4, 1, 3};
        ShellSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println("");
    }

    public static void ShellSort(int arr[]) {
        Boolean isComplete = false;
        int gap = (arr.length / 3) + 1;

        while (true) {
            if (gap == 1) {
                isComplete = true;
            }

            ArrayList<Integer> arrayList[] = new ArrayList[gap];
            for (int i = 0; i < arrayList.length; i++) {
                arrayList[i] = new ArrayList<Integer>();
            }

            for (int i = 0; i < arr.length; i++) {
                int j = i % gap;
                arrayList[j].add(arr[i]);
            }

            for (int i = 0; i < gap; i++) {
                Collections.sort(arrayList[i]);
            }

            for (int i = 0; i < gap; i++) {
                int gapTmp = 0;
                for (int j = 0; j < arrayList[i].size(); j++) {
                    arr[i + gapTmp] = arrayList[i].get(j);
                    gapTmp += gap;
                }
            }

            gap = (gap / 3) + 1;

            if (isComplete == true) {
                break;
            }
        }
    }
}