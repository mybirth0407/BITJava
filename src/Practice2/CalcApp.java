/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice2;

import java.util.Scanner;

 public class CalcApp {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.print("두 정수와 연산자 입력: ");

        int x = sc.nextInt();
        int y = sc.nextInt();
        String operand = sc.next();

        if (operand.equals("+")) {
            Add a = new Add();
            a.setValue(x, y);
            System.out.println(a.calculate());
        }
        else if (operand.equals("-")) {
            Sub s = new Sub();
            s.setValue(x, y);
            System.out.println(s.calculate());
        }
        else if (operand.equals("/")) {
            Div d = new Div();
            d.setValue(x, y);
            System.out.println(d.calculate());
        }
        else if (operand.equals("*")) {
            Mul m = new Mul();
            m.setValue(x, y);
            System.out.println(m.calculate());
        }
        else {
            System.out.println("제대로 입력하렴");
        }
    }
}
