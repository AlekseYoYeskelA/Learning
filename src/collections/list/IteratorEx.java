package collections.list;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Iterator;

public class IteratorEx {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Alex");
        list.add("Zaur");
        list.add("Mariya");
        list.add("Kolya");
        list.add("Elena");

        Iterator<String> iterator = list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
