package FatherWallet;

public class FirstChild {
    public boolean takeMoney(int money) {
        if (FatherWallet.MONEY < 1) {
            return false;
        }
        FatherWallet.MONEY -= money;
        return true;
    }
}
