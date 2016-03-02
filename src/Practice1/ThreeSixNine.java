/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice1;

public class ThreeSixNine {
    public static void main(String args[]) {
        for (int i = 1; i < 100; i++) {
            int temp = i;
            int clap = 0;

            if ((temp / 10) == 3 ||
                (temp / 10) == 6 ||
                (temp / 10) == 9) {
                clap++;
            }

            temp %= 10;

            if (temp == 3 ||
                temp == 6 ||
                temp == 9) {
                clap++;
            }

            if (clap != 0) {
                System.out.print(i + " ");

                for (int j = 0; j < clap; j++) {
                    System.out.print("짝");
                }
                System.out.println("");
            }
        }
    }
}
