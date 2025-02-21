package multithreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class ExchangerEx {
    public static void main(String[] args) {
        Exchanger<Action> exchanger = new Exchanger<>();
        List<Action> friend1Action = new ArrayList<>();
        friend1Action.add(Action.SCICCORS);
        friend1Action.add(Action.PAPER);
        friend1Action.add(Action.ROCK);

        List<Action> friend2Action = new ArrayList<>();
        friend2Action.add(Action.PAPER);
        friend2Action.add(Action.SCICCORS);
        friend2Action.add(Action.PAPER);

        new BestFriend("Alex", friend1Action, exchanger);
        new BestFriend("Zaur", friend2Action, exchanger);
    }
}

enum Action {
    ROCK, SCICCORS, PAPER;
}

class BestFriend extends Thread {
    private String name;
    private List<Action> myActions;
    private Exchanger<Action> exchanger;

    public BestFriend(String name, List<Action> myActions, Exchanger<Action> exchanger) {
        this.name = name;
        this.myActions = myActions;
        this.exchanger = exchanger;
        this.start();
    }

    private void whoWins(Action myAction, Action friendsAction) {
        if (
                (myAction == Action.ROCK && friendsAction == Action.SCICCORS)
                        || (myAction == Action.SCICCORS && friendsAction == Action.PAPER)
                        || (myAction == Action.PAPER && friendsAction == Action.ROCK)) {
            System.out.println(name + " WINS!!!");
        }
    }

    @Override
    public void run() {
        Action reply;
        for (Action action : myActions) {
            try {
                reply = exchanger.exchange(action);
                whoWins(action, reply);
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}