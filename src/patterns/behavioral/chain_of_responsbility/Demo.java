package patterns.behavioral.chain_of_responsbility;

import patterns.behavioral.chain_of_responsbility.middleware.Middleware;
import patterns.behavioral.chain_of_responsbility.middleware.RoleCheckMiddleware;
import patterns.behavioral.chain_of_responsbility.middleware.ThrottlingMiddleware;
import patterns.behavioral.chain_of_responsbility.middleware.UserExistMiddleware;
import patterns.behavioral.chain_of_responsbility.server.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Demo {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Server server;

    private static void init() {
        server = new Server();
        server.register("admin@example.com", "admin_pass");
        server.register("user@example.com", "user_pass");

        Middleware middleware = Middleware.link(
                new ThrottlingMiddleware(2),
                new UserExistMiddleware(server),
                new RoleCheckMiddleware()
        );

        server.setMiddleware(middleware);
    }

    public static void main(String[] args) throws IOException {
        init();

        boolean success;
        do {
            System.out.println("Enter email: ");
            String email = reader.readLine();
            System.out.println("Input password: ");
            String password = reader.readLine();
            success = server.logIn(email, password);
        } while (!success);
    }
}
