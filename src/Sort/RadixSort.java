/**
 * Created by Yedarm Seong on 2016-03-01.
 */

package Sort;

import java.util.ArrayList;

public class RadixSort {
    public static void main(String args[]) {
        System.out.println("Radix Sort");
        int intArr[] = {170, 45, 75, 90, 2, 24, 802, 66};
        String strArr[] = new String[intArr.length];

        int length = intArr.length;

        for (int i = 0; i < length; i++) {
            String tempStr = String.valueOf(intArr[i]);
            strArr[i] = String.format("%3s", tempStr);
            strArr[i] = strArr[i].replace(" ", "0");
        }

        ArrayList<String> arr[] = new ArrayList[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = new ArrayList<String>();
        }

        for (int l = 0; l < 3; l++) {
            for (int i = 0; i < length; i++) {
                int index = Integer.parseInt(
                    strArr[i].substring(
                        strArr[i].length() - 1 - l, strArr[i].length() - l));
                arr[index].add(strArr[i]);
            }

            int k = 0;
            for (int i = 0; i < 10; i++) {
                int size = arr[i].size();
                for (int j = 0; j < size; j++) {
                    strArr[k++] = arr[i].get(0);
                    arr[i].remove(0);
                }
            }
        }

        for (int i = 0; i < length; i++) {
            System.out.println(strArr[i]);
        }
    }
}
