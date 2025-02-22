package leetcode;

import com.sun.source.tree.BreakTree;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class ConvertTheTemperature {
    public double[] convertTemperature(double celsius) {
        double ans[] = new double[3];                 // создаем массив
        double kelvin = celsius + 273.15;              // вводим перевод в Кельвины
        double fahrenheit = celsius * 1.80 + 32.00;       // вводим перевод в Фаренгейты
        ans[0] = celsius;
        ans[1] = kelvin;                               // первый индекс массива выделяем для Кельвина
        ans[2] = fahrenheit;                           // второй индекс выделяем для Фаренгейта
        return ans;
    }

    public double[][] convertTemperature1(double... celsius) {
        double[][] table = new double[celsius.length][3];

        for (int i = 0; i < celsius.length; i++) {
            double[] currentRow = convertTemperature(celsius[i]);
            table[i] = currentRow;
        }
        return table;
    }

    public double[][] convertTemperature2(double... celsius) {
//        double[] kelvin = Arrays.stream(celsius)
//                .map(t -> t + 273.15)
//                .toArray();
//
//        double[] farenheit = Arrays.stream(celsius)
//                .map(t -> t * 1.80 + 32.00)
//                .toArray();

        return IntStream.range(0, celsius.length)
                .mapToObj(row -> IntStream.range(0, 3)
                        .mapToDouble(col -> {
                            if (col == 0) {
                                return celsius[row];
                            } else if (col == 1) {
                                return celsius[row] + 273.15;
                            } else {
                                return celsius[row] * 1.80 + 32.00;
                            }
                        })
                        .toArray())
                .toArray(double[][]::new);
    }

    public double[][] convertTemperature3(double... celsius) {
        return Arrays.stream(celsius)
                .mapToObj(t -> convertTemperature(t))
                .toArray(double[][]::new);

    }


    public static void main(String[] args) {
        ConvertTheTemperature ct = new ConvertTheTemperature();
        double[] celsius = {36.50, 55.4, 22.8, 13.0, 33.33};
        System.out.println(Arrays.deepToString(ct.convertTemperature1(celsius)));
        System.out.println(Arrays.deepToString(ct.convertTemperature2(celsius)));
        System.out.println(Arrays.deepToString(ct.convertTemperature3(celsius)));
    }
}