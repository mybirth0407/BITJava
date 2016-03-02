package Practice3;

/**
 * Created by Yedarm Seong on 2016-03-02.
 */
public class Prob3 {
    public static void main(String args[]) {
        String str1 = "Hello Java";
        String str2 = "Java Programming";
        char c1[]= reverse(str1);
        char c2[] = reverse(str2);
        printCharArray(c1);
        printCharArray(c2);
    }

    public static char[] reverse(String str) {
        char ret[] = new char[str.length()];
        for (int i = 0; i < str.length(); i++) {
            ret[i] = str.charAt(str.length() - i - 1);
        }
        return ret;
    }

    public static void printCharArray(char []array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }
        System.out.println("");
    }
}
