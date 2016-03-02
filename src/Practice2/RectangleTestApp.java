/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice2;

public class RectangleTestApp {
    public static void main (String args[]) {
        Rectangle r = new Rectangle();
        Rectangle s = new Rectangle(1, 1, 2, 3);

        System.out.println(r);
        System.out.println(s);

        System.out.println("사각형 r의 넓이는" + r.square());
        System.out.println("사각형 s의 넓이는" + s.square());

        r.set(1, 1, 2, 3);
        System.out.println(r);

        if (r.equals(s)) {
            System.out.println("두 사각형은 같습니다");
        }
        else {
            System.out.println("두 사각형은 다릅니다");
        }
    }
}
