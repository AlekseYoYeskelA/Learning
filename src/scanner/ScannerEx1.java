package scanner;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerEx1 {
    public static void main(String[] args) {
 //       Scanner scanner = new Scanner(System.in);
//        System.out.println("Vvedite chislo");
//        int i = scanner.nextInt();
//        System.out.println("Vvedennoe chislo " + i);

//        System.out.println("Vvedite 2 chisla ");
//        int x = scanner.nextInt();
//        int y = scanner.nextInt();
//        System.out.println("Chastnoe = " + x/y);
//        System.out.println("Ostatok = " + x%y);

//        System.out.println("Napishite paru slov");
//        String s = scanner.next();
//        System.out.println("Vi napisali: " + s);

//        System.out.println("Vvedite drobnoe chislo");
//        double d = scanner.nextDouble();
//        System.out.println("Vvedennoe chislo " + d);


        Scanner scanner = new Scanner("Privet, moy drug!\nKak jizn?\nChto novogo?");
//        while (scanner.hasNextLine()){
//            System.out.println(scanner.nextLine());
//        }

        System.out.println(scanner.next().charAt(3));

//                String s = scanner.nextLine();
//        System.out.println(s);
//        System.out.println(scanner.nextLine());
//        System.out.println(scanner.nextLine());

    }
}
