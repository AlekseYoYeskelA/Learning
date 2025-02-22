package patterns.behavioral.strategy;

import patterns.behavioral.strategy.order.Order;
import patterns.behavioral.strategy.strategies.PayByCreditCard;
import patterns.behavioral.strategy.strategies.PayByPayPal;
import patterns.behavioral.strategy.strategies.PayStrategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Demo {
    private static Map<Integer, Integer> priceOnProduct = new HashMap<>();
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static Order order = new Order();
    private static PayStrategy strategy;

    static {
        priceOnProduct.put(1, 2200);
        priceOnProduct.put(2, 1850);
        priceOnProduct.put(3, 110);
        priceOnProduct.put(4, 890);
    }


    public static void main(String[] args) throws IOException {
        while (!order.isClosed()) {
            int cost;

            String continueChoice;
            do {
                System.out.println("Please, select a product:" + "\n" +
                        "1 - Mother coard" + "\n" +
                        "2 - CPU" + "\n" +
                        "3 - GPU" + "\n" +
                        "4 - Memory" + "\n");
                int choice = Integer.parseInt(reader.readLine());
                cost = priceOnProduct.get(choice);
                System.out.println("Count: ");
                int count = Integer.parseInt(reader.readLine());
                order.setTotalCost(cost * count);
                System.out.println("Do you wish to continue selecting products? Y/N: ");
                continueChoice = reader.readLine();
            } while (continueChoice.equalsIgnoreCase("Y"));

            if (strategy == null) {
                System.out.println("Please, select a payment method: " + "\n" +
                        "1 - PayPal" + "\n" +
                        "2 - Credit Card");
                String paymentMethod = reader.readLine();

                if (paymentMethod.equals("1")) {
                    strategy = new PayByPayPal();
                } else {
                    strategy = new PayByCreditCard();
                }
            }

            order.processOrder(strategy);

            System.out.println("Pay " + order.getTotalCost() + " units or Continue shopping? P/C: ");
            String proceed = reader.readLine();
            if (proceed.equalsIgnoreCase("P")) {
                if (strategy.pay(order.getTotalCost())) {
                    System.out.println("Payment has been succesful.");
                } else {
                    System.out.println("FAIL! Please, check your data");
                }
                order.setClosed();
            }
        }
    }
}
