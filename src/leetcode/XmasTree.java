package leetcode;

public class XmasTree {
    public static void main(String[] args) throws InterruptedException {
        xmasTree(8, 3);
    }


    public static void xmasTree(int rows, int height) throws InterruptedException {
        int star = 1;
        int currRow = rows;
        int space = height + (height - 1);

        System.out.println("Я: Мам, давай купим ёлку\n" +
                "Мама: Но у нас уже есть ёлка дома\n" +
                "Ёлка дома:");

        for (int t = 1; t <= height; t++) {
            for (int i = star; i <= currRow; i++) {
                for (int j = 1; j <= rows - i + space; j++) {
                    System.out.print(" ");
                }

                Thread.sleep(250);

                for (int j = 1; j <= i * 2 - 1; j++) {
                    //Thread.sleep(250);
                    System.out.print("%");
                }
                System.out.println();
            }
            star += 2;
            currRow += 2;
        }
    }
}
