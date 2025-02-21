package algorithms.bitops;

public class Main {
    public static void main(String[] args) {
        int i = 0b00000100;
//        System.out.println(i);
//        System.out.println(Integer.toBinaryString(i));
//
//        //аналогичен целочисленному делению на 2
//        System.out.println("--побитовый сдвиг вправо---");
//        System.out.println("в десятичном виде: " + (i >> 1));
//        System.out.println("в двоичном виде: " + binaryStr(i >> 1));
//
//        //аналогичен целочисленному умножению на 2
//        System.out.println("--побитовый сдвиг влево---");
//        System.out.println("в десятичном виде: " + (i << 1));
//        System.out.println("в двоичном виде: " + binaryStr(i << 1));
//
//        //побитовые операции выполняются за 1 такт процессора
//        System.out.println("Быстрое умножение числа на 4: " + (i << 2));
//        System.out.println("Быстрое деление числа на 4: " + (i >> 2));
//
//        System.out.println("Быстрое умножение числа на 4: " + (i << 2));
//        System.out.println("Быстрое деление числа на 4: " + (i >> 2));
//
//        int b1 = 0b00001001;
//        int b2 = 0b00001010;
//
//        System.out.println("Побитовое И (AND)");
//        System.out.println("Исходное число: " + binaryStr(i));
//        printBinary(b2);
//        printBinary(b1 & b2);
//
//        System.out.println("Побитовое ИЛИ (OR)");
//        System.out.println("Исходное число: " + binaryStr(i));
//        printBinary(b1);
//        printBinary(b2);
//        printBinary(b1 | b2);
//
//        System.out.println("Исключающее ИЛИ (XOR)");
//        System.out.println("Исходное число: " + binaryStr(i));
//        printBinary(b1);
//        printBinary(b2);
//        printBinary(b1 ^ b2);
//
//        System.out.println("Инверсия (NOT)");
//        System.out.println("Исходное число: " + binaryStr(i));
//        printBinary(~b1);
//        printBinary(~b2);

//        //установка бита
//        int b = 0b11010000;
//        printBinary(b);
//        printBinary(b | 0b00000010);
//
//        //сброс бита в 0
//        printBinary(b);
//        printBinary(b & 0b11110111);
//
//        //проверка
//        System.out.println((b & 0b00001000) > 0 ? "1" : "0");


//        int r = 64;
//        int g = 128;
//        int b = 32;
//        int alpha = 255;
//        int color = alpha << 24 | r << 16 | g << 8 | b;
//        System.out.println(Integer.toBinaryString(color));

//        int b1 = color & 0b11111111;
//        int b2 = (color & 0b1111111100000000) >> 8;
//        int b3 = (color & 0b111111110000000000000000) >> 16;
//        int b4 = (color & 0b11111111000000000000000000000000) >> 24;

//        int b1 = color & 0xFF;
//        int b2 = (color & 0xFF << 8) >> 8;
//        int b3 = (color & 0xFF << 16) >> 16;
//        int b4 = (color & 0xFF << 24) >> 24;
//
//        printBinary(b1);
//        printBinary(b2);
//        printBinary(b3);
//        printBinary(b4);

        BitArray bitArray = new BitArray(10);
        bitArray.set(0, 1);
        bitArray.set(9, 1);

        bitArray.set(5, 1);
        bitArray.set(5, 0);

        System.out.println(bitArray.toString());
    }


    public static void printBinary(int b) {
        System.out.println("0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1));
    }

    public static String binaryStr(int b) {
        return "0b" + Integer.toBinaryString(0b100000000 | (b & 0xff)).substring(1);
    }
}
