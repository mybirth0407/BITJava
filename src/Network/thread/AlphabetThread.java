package Network.thread;

public class AlphabetThread extends Thread {
    @Override
    public void run() {
        for (char c = 'a'; c <= 'z'; c++) {
            System.out.print(c);
        }
    }
}
