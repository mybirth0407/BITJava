package Network.thread;

public class UpperCaseAlphabetRunnableImplements
    extends UpperCaseAlphabet implements Runnable {
    @Override
    public void run() {
        print();
    }
}
