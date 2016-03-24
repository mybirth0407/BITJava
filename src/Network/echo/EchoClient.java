package network.echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient {
    private static final String SERVER_IP = "192.168.1.191";
    private static final int SERVER_PORT = 5050;

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        Socket socket = null;

        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(SERVER_IP, SERVER_PORT));

            BufferedReader br = new BufferedReader(
                new InputStreamReader(socket.getInputStream(), "UTF-8"));
            PrintWriter pw = new PrintWriter(
                new OutputStreamWriter(
                    socket.getOutputStream(), "UTF-8"), true);

            while (true) {
                System.out.print(">> ");
                String message = sc.nextLine();

                if (message.equals("exit")) {
                    break;
                }
                pw.println(message);
                pw.flush();

                String data = null;

                if ((data = br.readLine()) != null) {
                    System.out.println("<< " + data);
                }
            }
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally {
            sc.close();

            if (socket != null) {
                if (socket.isClosed() == false) {
                    try {
                        socket.close();
                    }
                    catch (IOException ioe) {
                        ioe.printStackTrace();
                    }
                }
            }
        }
    }
}
