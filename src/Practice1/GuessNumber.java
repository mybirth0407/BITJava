/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice1;

import java.util.Random;
import java.util.Scanner;

public class GuessNumber {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();
        int guessNumber;
        String isContinue;
        int i = 1;

        while (true) {
            int n = rand.nextInt(99) + 1;
            System.out.println("수를 결정했다 덤벼라");

            if (GuessNumber(n) == 1) {
                continue;
            }
            else {
                break;
            }
        }
    }

    public static int GuessNumber(int n) {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; ; i++) {
            System.out.print(i + ">>");
            int myNumber = sc.nextInt();

            if (myNumber == n) {
                System.out.println("맞았음!\n" + "다시 할래? y/n?");
                String isContinue = sc.next();

                if (isContinue.equals("y")) {
                    return 1;
                }
                else {
                    return 0;
                }
            }
            else if (myNumber > n) {
                System.out.println("낮춰라");
            }
            else if (myNumber < n) {
                System.out.println("높여라");
            }
        }
    }
}
