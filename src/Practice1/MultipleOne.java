/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice1;

import java.util.Scanner;

public class MultipleOne {
    public static void main(String args[]) {
        System.out.print("수를 입력하시오: ");
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();

        if (input % 3 == 0) {
            System.out.println("3의 배수");
            return;
        }
        System.out.println("3의 배수 아님");
    }
}
