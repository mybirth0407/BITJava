/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice1;

public class Prob2 {
    public static void main(String args[]) {
        for (int i = 1; i  < 8; i++) {
            for (int j = i; j < i + 10; j++) {
                System.out.print(j + ", ");
            }
            System.out.println("");
        }
    }
}
