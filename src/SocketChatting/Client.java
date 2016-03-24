package socketchatting;

import java.net.Socket;

public class Client {
    public static void main(String args[]) {
        try {
            Socket socket = new Socket("127.0.0.1", 12345);

            System.out.println("Client start");
            Sender sender = new Sender(socket);
            Receiver receiver = new Receiver(socket);

            sender.start();
            receiver.start();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
