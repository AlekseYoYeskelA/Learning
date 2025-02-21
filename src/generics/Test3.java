package generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Test3 {
    public static void main(String[] args) {
        List<?> list = new ArrayList<String>();
        List<Double> list1 = new ArrayList<>();
        list1.add(3.14);
        list1.add(3.15);
        list1.add(3.16);
        showListInfo(list1);

        List<String> list2 = new ArrayList<>();
        list2.add("privet");
        list2.add("ok");
        list2.add("poka");
        showListInfo(list2);

        List<? extends Number> list10 = new ArrayList<Integer>();
        List<? super Number> list11 = new ArrayList<Object>();

        ArrayList<Double> aLDouble = new ArrayList<>();
        aLDouble.add(3.14);
        aLDouble.add(3.15);
        aLDouble.add(3.16);
        System.out.println(summ(aLDouble));

        ArrayList<Integer> aLInt = new ArrayList<>();
        aLInt.add(314);
        aLInt.add(315);
        aLInt.add(316);
        System.out.println(summ(aLInt));

    }

    static void showListInfo(List<?> list) {
        System.out.println("List soderjit elementi" + list);
    }

    public static double summ(ArrayList<? extends Number> aL) {
        double summ = 0;
        for (Number n : aL) {
            summ += n.doubleValue();
        }
        return summ;
    }

}
