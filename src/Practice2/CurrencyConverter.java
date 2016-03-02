package Practice2;

/**
 * Created by Yedarm Seong on 2016-03-02.
 */
public class CurrencyConverter {
    private static double rate;

    public static void main(String args[]) {
        setRate(1223.04562);
        System.out.println("백만원은 " + toDollar(1000000) + "달러");
        System.out.println("백달러는 " + toKWR(1000000) + "원");
    }

    public static double toDollar(double won) {
        double ret = (won * CurrencyConverter.rate);
        return ret;
    }

    public static double toKWR(double dollar) {
        double ret = (dollar / CurrencyConverter.rate);
        return ret;
    }

    public static void setRate(double r) {
        CurrencyConverter.rate = r;
    }
}
