package patterns.behavioral.chain_of_responsbility.middleware;

import patterns.behavioral.chain_of_responsbility.server.Server;

public class UserExistMiddleware extends Middleware {
    private Server server;

    public UserExistMiddleware(Server server) {
        this.server = server;
    }

    @Override
    public boolean check(String email, String password) {
        if(!server.hasEmail(email)) {
            System.out.println("This email is not registered");
            return false;
        }
        if(!server.isValidPassword(email, password)) {
            System.out.println("Wrong password!");
        }
        return checkNext(email, password);
    }
}
