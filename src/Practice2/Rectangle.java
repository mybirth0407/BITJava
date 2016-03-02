/**
 * Created by Yedarm Seong on 2016-03-02.
 */

package Practice2;

public class Rectangle {
    public int x1;
    public int y1;
    public int x2;
    public int y2;

    Rectangle() {
        this.x1 = 0;
        this.y1 = 0;
        this.x2 = 0;
        this.y2 = 0;
    }

    Rectangle(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    public int square() {
        int width = Math.abs(this.x1 - this.x2);
        int height = Math.abs(this.y1 - this.y2);

        return width * height;
    }

    public boolean equals(Rectangle r) {
        if (this.x1 == r.x1 && this.x2 == r.x2 &&
            this.y1 == r.y1 && this.y2 == r.y2) {
            return true;
        }
        return false;
    }

    public void set(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
}
