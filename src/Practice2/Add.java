package Practice2;

/**
 * Created by Yedarm Seong on 2016-03-02.
 */
public class Add {
    int a;
    int b;

    void setValue(int a, int b) {
        this.a = a;
        this.b = b;
    }

    int calculate() {
        int ret = (this.a + this.b);
        return ret;
    }
}
