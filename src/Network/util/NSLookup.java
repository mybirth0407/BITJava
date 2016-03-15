package Network.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;

public class NSLookup {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                System.out.print(">>");
                String hostname = sc.nextLine();

                if (hostname.equals("exit")) {
                    break;
                }
                InetAddress inetAddress[] = InetAddress.getAllByName(
                    hostname);

                for (int i = 0; i < inetAddress.length; i++) {
                    System.out.println(inetAddress[i].getHostAddress());
                }
                sc.close();
            }
            catch (UnknownHostException e){
                e.printStackTrace();
            }
        }
        sc.close();
    }
}
