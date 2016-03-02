/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice2;

import java.util.Scanner;

public class GoodsApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Goods g[] = new Goods[3];

        for (int i = 0; i < 3; i++) {
            String tempName = sc.next();
            int tempPrice = sc.nextInt();
            int tempCount = sc.nextInt();

            g[i] = new Goods();
            g[i].name = tempName;
            g[i].price = tempPrice;
            g[i].count = tempCount;
        }

        for (int i = 0; i < 3; i++) {
            System.out.println(g[i].name + "(가격: " + g[i].price + ")" +
                "이 " + g[i].count + "개 입고 되었습니다.");
        }
    }
}
