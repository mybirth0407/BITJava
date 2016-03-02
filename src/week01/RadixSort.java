/**
 * Created by Yedarm Seong on 2016-03-01.
 */

package week01;

public class RadixSort {
    public static void main(String args[]) {
        System.out.println("Radix Sort");
        int intArr[] = {170, 45, 75, 90, 2, 24, 802, 66};
        String strArr[] = new String[intArr.length];

        for (int i = 0; i < intArr.length; i++) {
            strArr[i] = Integer.toString(intArr[i]);
        }

        System.out.println(strArr[0]);

        char charArr[] = new char[strArr.length];

        for (int i = 0; i < strArr.length; i++) {
        }

        for (int i = 0; i < strArr.length; i++) {
            System.out.print(strArr[i] + ", ");
        }
        System.out.println("");
    }
}
