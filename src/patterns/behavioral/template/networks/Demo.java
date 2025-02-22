package patterns.behavioral.template.networks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Network network = null;
        System.out.print("Input user name: ");
        String userName = reader.readLine();
        System.out.print("Input passwoerd: ");
        String password = reader.readLine();

        System.out.print("Input message: ");
        String message = reader.readLine();

        System.out.println("\nChoose social network for posting message.\n" +
                "1 - Facebook\n" +
                "2 - Twitter");
        int choise = Integer.parseInt(reader.readLine());

        if (choise == 1) {
            network = new Facebook(userName, password);
        } else if (choise == 2) {
            network = new Twitter(userName, password);
        }
        network.post(message);
    }
}
