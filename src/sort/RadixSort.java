package sort;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String args[]) {
        System.out.println("Radix sort");
        int arr[] = {170, 45, 75, 90, 2, 24, 802, 66};

        int sortedArr[] = RadixSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(sortedArr[i]);
        }
    }

    public static int[] RadixSort(int arr[]) {
        String strArr[] = new String[arr.length];

        int length = arr.length;

        for (int i = 0; i < length; i++) {
            String tempStr = String.valueOf(arr[i]);
            strArr[i] = String.format("%3s", tempStr);
            strArr[i] = strArr[i].replace(" ", "0");
        }

        ArrayList<String> arrayList[] = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            arrayList[i] = new ArrayList<String>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < length; j++) {
                int index = Integer.parseInt(
                    strArr[j].substring(
                        strArr[j].length() - 1 - i, strArr[j].length() - i));
                arrayList[index].add(strArr[j]);
            }

            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                int size = arrayList[j].size();
                for (int k = 0; k < size; k++) {
                    strArr[cnt++] = arrayList[j].get(0);
                    arrayList[j].remove(0);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }
        return arr;
    }
}
