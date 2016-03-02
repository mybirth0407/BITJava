/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice3;

import java.util.Scanner;

public class Prob2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("금액: ");
        int money = sc.nextInt();

        int arr[] = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 1};
        String strArr[] = {"오만원 권", "만원 권", "오천원 권", "천원 권",
            "500원 동전", "100원 동전", "50원 동전", "10원 동전", "1원 동전"};
        int countArr[] = new int[9];

        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            while (true) {
                if (money < arr[i]) {
                    break;
                }
                money -= arr[i];
                count++;
            }
            countArr[i] = count;
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(strArr[i] + ": " + countArr[i] + "개");
        }
    }
}
