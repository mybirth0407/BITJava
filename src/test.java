/**
 * Created by Yedarm Seong on 2016-03-03.
 */

import java.util.ArrayList;

public class test {
    public static void main(String args[]) {
        int i = 1;
        int j = 1;

        while (i <= 9) {
            while (j <= 9) {
                System.out.println(i + "*" + j + "=" + (i * j));
                j++;
            }
            i++;
        }
    }
}
