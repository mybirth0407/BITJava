/**
 * Created by Yedarm Seong on 2016-03-02.
 */
package Practice3;

import java.util.Scanner;

public class Prob4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int intArray[] = new int[5];
        double sum = 0;

        /* 키보드에서 배열 크기만큼 입력 받아 배열에 저장하는 코드 */
        for (int i = 0; i < intArray.length; i++) {
            int temp = in.nextInt();
            intArray[i] = temp;
            /* 배열에 저장된 정수 값 더하기 */
            sum += temp;
        }
        /* 출력 */
        System.out.println(sum);
    }
}
