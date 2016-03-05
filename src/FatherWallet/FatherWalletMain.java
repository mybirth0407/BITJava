package FatherWallet;

public class FatherWalletMain {
    public static void main(String args[]) {
        System.out.println(FatherWallet.MONEY);
        FirstChild firstChild = new FirstChild();
        System.out.println(firstChild.takeMoney(100));
        System.out.println(FatherWallet.MONEY);
        SecondChild secondChild = new SecondChild();
        System.out.println(firstChild.takeMoney(100));
        System.out.println(FatherWallet.MONEY);
        ThirdChild thirdChild = new ThirdChild();
        System.out.println(firstChild.takeMoney(100));
        System.out.println(FatherWallet.MONEY);
    }
}
